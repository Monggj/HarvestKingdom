package entity;

public class Plant {

	private int plantId;
	private String name;
	private int growDays;
	private String weather;
	private int seedCost;
	private int price;
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrowDays() {
		return growDays;
	}

	public void setGrowDays(int growDays) {
		this.growDays = growDays;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getSeedCost() {
		return seedCost;
	}

	public void setSeedCost(int seedCost) {
		this.seedCost = seedCost;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
