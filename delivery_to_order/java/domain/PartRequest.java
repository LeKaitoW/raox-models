package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ru.bmstu.rk9.rao.lib.runtime.LoggerExtensions;

@Entity
@Table(name = "requestedpartslist")
@IdClass(value = PartRequest.PartRequestId.class)
public class PartRequest {

	@Id
	@ManyToOne
	@JoinColumn(name = "RequestID")
	public Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "SparePartID")
	public Part part;

	/**
	 * Цена продажи в момент формирования заказа. Учитывать не нужно
	 */
	@Column(name = "Price")
	public int price;

	/**
	 * Дата доставки, если {@code NULL}, то доставки не было
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "DateOfDelivery")
	public Calendar dateOfDelivery;

	@Column(name = "Count")
	public int count;

	public LocalDate getDateOfDelivery() {
		return toLocalDate(dateOfDelivery);
	}

	/**
	 * @return длительность доставки в днях
	 */
	public long getDeliveryInterval() {
		LocalDate start = order.getDateOfCreation();
		LocalDate end = getDateOfDelivery();
		long interval = start.until(end, ChronoUnit.DAYS);
		LoggerExtensions.log("Деталь " + part.name + " будет доставлена через " + interval + " дней"); 
		// TODO есть детали, у которых дата доставки раньше даты создания заказа
		return Math.abs(interval);
	}
	
	/**
	 * @return определена ли длительность доставки (т.е. заказ был отгружен)
	 */
	public boolean hasDeliveryInterval() {
		return dateOfDelivery != null && order.dateOfCreation != null;
	}
	
	/**
	 * Забрать детали со склада
	 * 
	 * @return возможно ли забрать деталь со склада
	 */
	public boolean takeParts() {
		if (part.stocked >= count) {
			part.stocked -= count;
			return true;
		} else {
			part.stocked = 0;
			return false;
		}
	}

	private LocalDate toLocalDate(Calendar calendar) {
		return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	@Override
	public String toString() {
		return "PartRequest [Part=" + part.name + ", DeliveryInterval=" + getDeliveryInterval() + ", Count=" + count
				+ "]";
	}

	@SuppressWarnings("serial")
	public static class PartRequestId implements Serializable {
		public Order order;
		public Part part;
	}
}
