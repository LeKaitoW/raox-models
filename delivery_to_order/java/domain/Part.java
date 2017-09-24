package domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "catalogue")
@Entity
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
	// @OneToMany

	@Override
	public String toString(){
		return name;
	};
	
}
