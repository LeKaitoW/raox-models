package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalogue")
public class Part {

	@Id
	public String id;

	public String manufacturer;

	public String name;

	public String path;

	public int retailprice;

	public int purchaseprice;

	public int sellingprice;

	public int clientprice;

	public int purtnerprice;

	public int stocked;

	public int reserved;

	public String store;

	public double catalogueprice;

	@OneToMany(mappedBy = "part", fetch = FetchType.LAZY)
	public List<PartRequest> requestedParts;

	@Override
	public String toString() {
		return "Part [name=" + name + ", retailprice=" + retailprice + ", purchaseprice=" + purchaseprice
				+ ", sellingprice=" + sellingprice + ", clientprice=" + clientprice + ", purtnerprice=" + purtnerprice
				+ ", stocked=" + stocked + ", reserved=" + reserved + ", store=" + store + ", catalogueprice="
				+ catalogueprice + "]";
	}
}
