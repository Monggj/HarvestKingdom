package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.DayController;
import controller.ShopController;
import entity.Field;
import entity.Plant;
import entity.Player;
import model.FieldModel;
import model.PlantModel;
import model.PlayerModel;

public class GameView {

    private Scanner scanner = new Scanner(System.in);
    private DayController dayController = new DayController();
    private ShopController shopController = new ShopController();
    private PlayerModel playerModel = new PlayerModel();
    private PlantModel plantModel = new PlantModel();
    private FieldModel fieldModel = new FieldModel();
    
    private FarmView farmView = new FarmView();  


    public void start() {
        boolean running = true;
        while (running) {
            showStatus();
            showMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
               
                ArrayList<Plant> plants = plantModel.getAllPlants();
                for (Plant p : plants) {
                    System.out.println(p.getPlantId() + ". " + p.getName() + " - $" + p.getSeedCost());
                }
                System.out.print("which crops do you want to buy: ");
                int plantId = scanner.nextInt();
                shopController.buySeed(plantId);

            } else if (choice == 2) {
            	 System.out.print("what field do u want to sell: ");
                int fieldId = scanner.nextInt();
                boolean sold = shopController.sellCrop(fieldId);

                if (sold) {
                    System.out.println("Done!");
                } else {
                    System.out.println("Fail!");
                }
            } else if (choice == 3) {
             
                dayController.nextDay();
                System.out.println("the next day!");

            }else if (choice== 4) {
            	 System.out.print("Which plants do you want to water: ");
            	int fieldId = scanner.nextInt();
            	fieldModel.waterField(fieldId);
			}
            else if (choice == 5) {
                playerModel.resetPlayer();
                fieldModel.clearAllFields();
                System.out.println("rest world!");

            } else if (choice == 6) {
                break;

            }
            else {
                System.out.println("invalid !");
            }
        }
        System.out.println("bai bai!");
    }

    
    private void showStatus() {
        Player p = playerModel.getPlayer();
        ArrayList<Field> fields = fieldModel.getAllFields();
        ArrayList<Plant> plants = plantModel.getAllPlants();
        farmView.showStatus(p, fields, plants);
    }

    private void showMenu() {
        System.out.println("\n1. buy and farming");
        System.out.println("2. sell crop");
        System.out.println("3. next day");
        System.out.println("4. Water");
        System.out.println("5. new game");
        System.out.println("6. exit");
        System.out.print("chose: ");
    }
}