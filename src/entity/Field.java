package entity;

public class Field {

	private int fieldId;
	private int playerId;
	private int plaintId;
	private int plantDay;
	private int growPercent;
	private int waterLevel;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getPlaintId() {
		return plaintId;
	}

	public void setPlaintId(int plaintId) {
		this.plaintId = plaintId;
	}

	public int getPlantDay() {
		return plantDay;
	}

	public void setPlantDay(int plantDay) {
		this.plantDay = plantDay;
	}

	public int getGrowPercent() {
		return growPercent;
	}

	public void setGrowPercent(int growPercent) {
		this.growPercent = growPercent;
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(int waterLevel) {
		this.waterLevel = waterLevel;
	}

	

}
