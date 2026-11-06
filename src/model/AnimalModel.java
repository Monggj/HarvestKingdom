package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Animal;

public class AnimalModel {

	public ArrayList<Animal> getAllAnimals() {
		ArrayList<Animal> animals = new ArrayList<Animal>();

		try {

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from animal";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Animal a = new Animal();
				a.setAnimalId(rs.getInt("animal_id"));
				a.setPlayerId(rs.getInt("player_id"));
				a.setTypeId(rs.getInt("type_id"));
				a.setHealth(rs.getInt("health"));
				a.setHunger(rs.getInt("hunger"));
				a.setProduct_ready(rs.getInt("product_ready"));
				animals.add(a);

			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return animals;
	}
}