package domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@Column(name = "Price")
	public int price;

	@Column(name = "DateOfDelivery")
	public LocalDate dateOfDelivery;

	@Column(name = "Count")
	private int count;

	public int getCount() {
		if (count > 1000)
			return 1;
		return count;
	}

	@Override
	public String toString() {
		return "PartRequest [Part=" + part + ", Count=" + count + ", Price=" + price + "]";
	}

	@SuppressWarnings("serial")
	public static class PartRequestId implements Serializable {
		public Order order;
		public Part part;
	}
}
