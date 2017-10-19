package domain;

import java.time.LocalDate;
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
	 * Дата последнего изменения, служебный столбец для отслеживания старых или забытых заявок
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateOfProcessing")
	public Calendar dateOfProcessing;

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

	public LocalDate getDateOfCreation() {
		return LocalDate.of(dateOfCreation.get(Calendar.YEAR), dateOfCreation.get(Calendar.MONTH),
				dateOfCreation.get(Calendar.DAY_OF_MONTH));
	}

	@Override
	public String toString() {
		return "Order [id=" + id + "]";
	}
}
