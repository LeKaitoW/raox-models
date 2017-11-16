package domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sparepartsrequests")
public class Order {

	@Id
	@Column(name = "ID")
	public int id;

	@Column(name = "Status")
	public String status;

	@Column(name = "SolutionName")
	public String solutionName;

	/**
	 * Дата поступления заказа
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateOfCreation")
	public Calendar dateOfCreation;

	/**
	 * Дата последнего изменения, служебный столбец для отслеживания старых или
	 * забытых заявок
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateOfProcessing")
	private Calendar dateOfProcessing;

	/**
	 * Дата отгрузки, если {@code NULL}, то отгрузки не было
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateOfRealization")
	public Calendar dateOfRealization;

	@Column(name = "OrderNumber")
	public int orderNumber;

	@Column(name = "OutfitNumber")
	public int outfitNumber;

	@Column(name = "DiagnosticOrderNumber")
	public int diagnosticOrderNumber;

	@Column(name = "DiagnosticOutfitNumber")
	public int diagnosticOutfitNumber;

	@Column(name = "Selected")
	public boolean selected;

	@Column(name = "MustBeOrdered")
	public boolean mustBeOrdered;

	@Column(name = "Shipped")
	public boolean shipped;

	@Column(name = "TypeOfPrice")
	public int typeOfPrice;

	@Column(name = "ResponsibleForSelection")
	public String responsibleForSelection;

	@Column(name = "ResponsibleForOrdering")
	public String responsibleForOrdering;

	@Column(name = "ResponsibleForShipping")
	public String responsibleForShipping;

	@Column(name = "PartsRecipient")
	public String partsRecipient;

	@Column(name = "Description")
	public String description;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	public List<PartRequest> requestedParts;

	/**
	 * Дата поступления заказа
	 * 
	 * @return null, если поле имеет значение null
	 */
	public LocalDate getDateOfCreation() {
		return toLocalDate(dateOfCreation);
	}

	public long getEpochDayOfCreation() {
		return getDateOfCreation().toEpochDay();
	}

	/**
	 * @return можно ли вычислить интервал последнего изменения
	 */
	public boolean hasProcessingInterval() {
		return dateOfProcessing != null;
	}
	
	/**
	 * Дата последнего изменения, служебный столбец для отслеживания старых или
	 * забытых заявок
	 * 
	 * @return null, если поле имеет значение null
	 */
	private LocalDate getDateOfProcessing() {
		return toLocalDate(dateOfProcessing);
	}

	/**
	 * Дата отгрузки
	 * 
	 * @return null, если поле имеет значение null
	 */
	public LocalDate getDateOfRealization() {
		return toLocalDate(dateOfRealization);
	}
	
	/**
	 * @return можно ли вычислить интервал реализации
	 */
	public boolean hasRealizationInterval() {
		return dateOfRealization != null;
	}
	
	/**
	 * @return разница между датой создания и реализации
	 */
	public long getRealizationInterval() {
		LocalDate start = getDateOfCreation();
		LocalDate end = getDateOfRealization();
		long result = start.until(end, ChronoUnit.DAYS);
		if(result < 0) {
			throw new IllegalStateException("getRealizationInterval " + result);
		}
		return result;
	}

	/**
	 * @return разница между датой создания и последнего изменения
	 */
	public long getModificationInterval() {
		LocalDate start = getDateOfCreation();
		LocalDate end = getDateOfProcessing();
		long result = start.until(end, ChronoUnit.DAYS);
		if(result < 0) {
			throw new IllegalStateException("getModificationInterval " + result);
		}
		return result;
	}

	public LocalDate toLocalDate(Calendar calendar) {
		return calendar == null ? null
				: LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
						calendar.get(Calendar.DAY_OF_MONTH));
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "]";
	}
}
