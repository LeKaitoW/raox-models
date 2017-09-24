package domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "sparepartsrequests")
@Entity
public class Order {
	@Id
	public int ID;
	public String Status;
	public String SolutionName;
	@Temporal(TemporalType.TIMESTAMP)
	public Date DateOfCreation;
	@Temporal(TemporalType.TIMESTAMP)
	public Date DateOfProcessing;
	@Temporal(TemporalType.TIMESTAMP)
	public Date DateOfRealization;
	public int OrderNumber;
	public int OutfitNumber;
	public int DiagnosticOrderNumber;
	public int DiagnosticOutfitNumber;
	public boolean Selected;
	public boolean MustBeOrdered;
	public boolean Shipped;
	public int TypeOfPrice;
	public String ResponsibleForSelection;
	public String ResponsibleForOrdering;
	public String ResponsibleForShipping;
	public String PartsRecipient;
	public String Description;
	
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY)
	public List<PartRequest> requestedParts;
}
