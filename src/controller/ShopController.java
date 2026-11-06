package controller;

import java.util.ArrayList;

import entity.Field;
import entity.Plant;
import entity.Player;
import model.FieldModel;
import model.PlantModel;
import model.PlayerModel;

public class ShopController {

    public boolean buySeed(int plantId) {
        PlayerModel playerModel = new PlayerModel();
        PlantModel plantModel = new PlantModel();
        FieldModel fieldModel = new FieldModel();

        Player player = playerModel.getPlayer();
        Plant plant = plantModel.getPlantById(plantId);

       
        if (player.getMoney() < plant.getSeedCost()) {
            System.out.println("Not enough money!");
            return false;
        }

      
        int newMoney = player.getMoney() - plant.getSeedCost();
        playerModel.updateMoney(newMoney);

      
        Field emptyField = fieldModel.getEmptyField();
        if (emptyField != null) {
            fieldModel.plantOnField(emptyField.getFieldId(), plantId, player.getCurruntDay());
        } else {
            fieldModel.plantCrop(1, plantId, player.getCurruntDay());
        }

        return true;
    }
    
    public boolean sellCrop(int fieldId) {
        PlayerModel playerModel = new PlayerModel();
        PlantModel plantModel = new PlantModel();
        FieldModel fieldModel = new FieldModel();

        Player player = playerModel.getPlayer();
        ArrayList<Field> fields = fieldModel.getAllFields();

        Field targetField = null;
        for (Field f : fields) {
            if (f.getFieldId() == fieldId) {
                targetField = f;
            }
        }

        Plant plant = plantModel.getPlantById(targetField.getPlaintId());
        int newMoney = player.getMoney() + plant.getPrice();
        playerModel.updateMoney(newMoney);
        fieldModel.havestCrop(fieldId);

        return true;
    }
}