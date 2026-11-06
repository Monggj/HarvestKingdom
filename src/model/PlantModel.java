package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Plant;

public class PlantModel {

	public ArrayList<Plant> getAllPlants() {
		ArrayList<Plant> plants = new ArrayList<Plant>();
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from plant";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Plant p = new Plant();
				p.setPlantId(rs.getInt("plantid"));
				p.setName(rs.getString("name"));
				p.setGrowDays(rs.getInt("grow_days"));
				p.setWeather(rs.getString("weather"));
				p.setSeedCost(rs.getInt("seed_cost"));
				p.setPrice(rs.getInt("price"));
				p.setImage(rs.getString("image"));
				plants.add(p);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return plants;
		
	}
	
	
	public Plant getPlantById(int plantId) {
	    Plant p = null;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "select* from plant where plantid = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, plantId);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	          p = new Plant();
	           
				p.setPlantId(rs.getInt("plantid"));
				p.setName(rs.getString("name"));
				p.setGrowDays(rs.getInt("grow_days"));
				p.setWeather(rs.getString("weather"));
				p.setSeedCost(rs.getInt("seed_cost"));
				p.setPrice(rs.getInt("price"));
				p.setImage(rs.getString("image"));
				
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return p;
	}
}
