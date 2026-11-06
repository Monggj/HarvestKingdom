package entity;

public class AnimalType {

	private int typeId;
	private String name;
	private String productName;
	private int productPrice;
	private int buyCost;
	private int produceDays;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getBuyCost() {
		return buyCost;
	}

	public void setBuyCost(int buyCost) {
		this.buyCost = buyCost;
	}

	public int getProduceDays() {
		return produceDays;
	}

	public void setProduceDays(int produceDays) {
		this.produceDays = produceDays;
	}

}
