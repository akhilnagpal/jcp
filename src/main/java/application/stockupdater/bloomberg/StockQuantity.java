package application.stockupdater.bloomberg;

public class StockQuantity  implements Comparable<StockQuantity>{
	
	private String name;
	private int quantity;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	

	@Override
	public String toString() {
		return "StockQuantity [quantity=" + quantity + ", name=" + name + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockQuantity other = (StockQuantity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int getQuantity() {
		return quantity;
	}

	public String getName() {
		return name;
	}

	
	
	public StockQuantity(int quantity,String name) {
		this.name=name;
		this.quantity=quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(StockQuantity o) {
		if(quantity>o.quantity) {
			return -1;
		}
		if(quantity<o.quantity) {
			return 1;
		}
		return 0;
	}
	
	
}
