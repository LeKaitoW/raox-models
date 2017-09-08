package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;

@Entity
@PersistenceUnit(unitName = "corpterminal")
@Table(name = "catalogue")
public class Part {

	@Id
	private String id;
	private String manufacturer;
	private String name;
	private String path;
	private int retailprice;
	private int purchaseprice;
	private int sellingprice;
	private int clientprice;
	private int purtnerprice;
	private int stocked;
	private int reserved;
	private String store;
	private double catalogueprice;

	public String getId() {
		return id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public int getRetailprice() {
		return retailprice;
	}

	public int getPurchaseprice() {
		return purchaseprice;
	}

	public int getSellingprice() {
		return sellingprice;
	}

	public int getClientprice() {
		return clientprice;
	}

	public int getPurtnerprice() {
		return purtnerprice;
	}

	public int getStocked() {
		return stocked;
	}

	public int getReserved() {
		return reserved;
	}

	public String getStore() {
		return store;
	}

	public double getCatalogueprice() {
		return catalogueprice;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", manufacturer=" + manufacturer + ", name=" + name + ", path=" + path
				+ ", retailprice=" + retailprice + ", purchaseprice=" + purchaseprice + ", sellingprice=" + sellingprice
				+ ", clientprice=" + clientprice + ", purtnerprice=" + purtnerprice + ", stocked=" + stocked
				+ ", reserved=" + reserved + ", store=" + store + ", catalogueprice=" + catalogueprice + "]";
	}

}