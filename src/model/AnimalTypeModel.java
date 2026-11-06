package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.AnimalType;

public class AnimalTypeModel {

	public ArrayList<AnimalType> getAllAnimalTypes() {
		ArrayList<AnimalType> animalTypes = new ArrayList<AnimalType>();

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from animalType";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AnimalType at = new AnimalType();
				at.setTypeId(rs.getInt("type_id"));
				at.setName(rs.getString("name"));
				at.setBuyCost(rs.getInt("buy_cost"));
				at.setProduceDays(rs.getInt("produce_days"));
				at.setProductPrice(rs.getInt("product_price"));
				at.setProductName(rs.getString("product_name"));
				animalTypes.add(at);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return animalTypes;
	}
}
