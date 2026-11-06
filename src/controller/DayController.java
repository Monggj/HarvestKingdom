package controller;

import java.util.ArrayList;

import entity.Field;
import entity.Plant;
import entity.Player;
import model.FieldModel;
import model.PlantModel;
import model.PlayerModel;

public class DayController {

	public void nextDay() {
		PlayerModel playerModel = new PlayerModel();
		PlantModel plantModel = new PlantModel();
		FieldModel fieldModel = new FieldModel();

		Player player = playerModel.getPlayer();
		int currentDay = player.getCurruntDay();

		ArrayList<Field> fields = fieldModel.getAllFields();

		for (Field f : fields) {
			if (f.getStatus().equals("GROWING")) {
				//cay dang trong
				Plant plant = plantModel.getPlantById(f.getPlaintId());

				// so ngay trong
				int daysPassed = currentDay - f.getPlantDay();

				// ngay thu hoach ％ ＝ そだてた日 かける 100 わる おおきくなる日
				if (daysPassed >= plant.getGrowDays()) {
					fieldModel.updateGrowth(f.getFieldId(), 100, "READY");
				} else {
					int percent = (daysPassed * 100) / plant.getGrowDays();
					fieldModel.updateGrowth(f.getFieldId(), percent, "GROWING");
				}
				int newWater = f.getWaterLevel() - 20;
		        if (newWater < 0) newWater = 0;
		        fieldModel.reduceWater(f.getFieldId(), newWater);
			}
		}
		playerModel.updateCurrentDay(currentDay + 1);
	}
	
}