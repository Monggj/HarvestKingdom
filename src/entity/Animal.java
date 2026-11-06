package entity;

public class Animal {

	private int animalId;
	private int playerId;
	private int typeId;
	private int health;
	private int hunger;
	private int product_ready;
	
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public int getProduct_ready() {
		return product_ready;
	}
	public void setProduct_ready(int product_ready) {
		this.product_ready = product_ready;
	}
}
