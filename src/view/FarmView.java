package view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import entity.Field;
import entity.Plant;
import entity.Player;
import model.PlantModel; 

public class FarmView {
	 private PlantModel plantModel = new PlantModel();

    public void showStatus(Player player, ArrayList<Field> fields, ArrayList<Plant> plants) {
        try {
            FileWriter dw = new FileWriter("farm.html");

            dw.write("<link rel='stylesheet' href='style.css'>");
            dw.write("<h1 style='text-align:center;'>Harvest Kingdom</h1>");

            // player
            dw.write("<div class='player-section'>");
            dw.write("<h2>Player Status</h2>");
            dw.write("<div class='player-card'>");
            dw.write("<div class='player-info'>");
            dw.write("<p class='player-day'>Day: " + player.getCurruntDay() + "</p>");
            dw.write("<p class='player-money'>Money: $" + player.getMoney() + "</p>");
            dw.write("</div>");
            dw.write("</div>");
            dw.write("</div>");

            // field
            dw.write("<div class='field-section'>");
            dw.write("<h2>Fields</h2>");
            dw.write("<div class='field-list'>");

            for (Field f : fields) {
                dw.write("<div class='field-card'>");
                dw.write("<h3>Field #" + f.getFieldId() +"</h3>");
                if (f.getPlaintId() != 0) {   // co dang trong cay
                    Plant plant = plantModel.getPlantById(f.getPlaintId());
                    dw.write("<p>Growing: " + plant.getName() + "</p>");
                    dw.write("<img height='100px' src='"+plant.getImage()+"'>");
                }
                dw.write("<div class='field-info'>");
                dw.write("<p>Status: " + f.getStatus() + "</p>");

                dw.write("<p>Growth</p>");
                dw.write("<div class='growth-bar'>");
                dw.write("<div class='growth-percent' style='width:" + f.getGrowPercent() + "%'></div>");
                dw.write("</div>");

                dw.write("<p>Water</p>");
                dw.write("<div class='water-bar'>");
                dw.write("<div class='water-level' style='width:" + f.getWaterLevel() + "%'></div>");
                dw.write("</div>");

                dw.write("<p class='field-status'>" + f.getStatus() + "</p>");
                dw.write("</div>"); // field-info
                dw.write("</div>"); // field-card
            }

            dw.write("</div>"); // field-list
            dw.write("</div>"); // field-section

            // shop
            dw.write("<div class='plant-section'>");
            dw.write("<h2>Shop - Seeds</h2>");
            dw.write("<div class='plant-list'>");

            for (Plant p : plants) {
                dw.write("<div class='plant-card'>");
                dw.write("<h3>" + p.getName() + "</h3>");
                dw.write("<div class='plant-info'>");
                dw.write("<p>Weather: " + p.getWeather() + "</p>");
                dw.write("<p>Grow days: " + p.getGrowDays() + "</p>");
                dw.write("<p class='seed-cost'>Seed cost: $" + p.getSeedCost() + "</p>");
                dw.write("<p class='plant-price'>Sell price: $" + p.getPrice() + "</p>");
                dw.write("<img height='100px' src='"+p.getImage()+"'>");
                dw.write("</div>"); // plant-info
                dw.write("</div>"); // plant-card
            }

            dw.write("</div>"); // plant-list
            dw.write("</div>"); // plant-section

            dw.close();

            File file = new File("farm.html");
            Desktop.getDesktop().browse(file.toURI());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}