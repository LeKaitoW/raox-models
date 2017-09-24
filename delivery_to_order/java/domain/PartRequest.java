package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "requestedpartslist")
@IdClass(value = PartRequest.PartRequestId.class)
@Entity
public class PartRequest {
	
	@Id	
	@ManyToOne
	@JoinColumn(name="RequestID")
	public Order order;
	
	
	@ManyToOne
	@Id
	@JoinColumn(name="SparePartID")
	public Part part;
	
	public int Price;
	
	@Temporal(TemporalType.DATE)
	public Date DateOfDelivery;
	
	public int Count;

	@Override
	public String toString() {
		return "Delivery [Part=" + part.name + ", Price=" + Price + ", DateOfDelivery=" + DateOfDelivery + ", Count="
				+ Count + "]";
	}

	@SuppressWarnings("serial")
	public static class PartRequestId implements Serializable {
		public Order order;
		public Part part;
	}
}
