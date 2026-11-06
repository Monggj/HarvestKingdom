package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Field;

public class FieldModel {
	public void plantCrop(int playerId, int plantId, int plantDay) {
		try {

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "insert into field (playerid, plaintid, plant_day, grow_percent, water_level, status) values (?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, playerId);
			stmt.setInt(2, plantId);
			stmt.setInt(3, plantDay);
			stmt.setInt(4, 0); //%grow
			stmt.setInt(5, 100); //water lv
			stmt.setString(6, "GROWING");
			stmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<Field> getAllFields() {
		ArrayList<Field> fields = new ArrayList<Field>();

		try {

			

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from field";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Field f = new Field();
				f.setFieldId(rs.getInt("fieldid"));
				f.setPlayerId(rs.getInt("playerid"));
				f.setPlaintId(rs.getInt("plaintid"));
				f.setPlantDay(rs.getInt("plant_day"));
				f.setGrowPercent(rs.getInt("grow_percent"));
				f.setWaterLevel(rs.getInt("water_level"));
				f.setStatus(rs.getString("status"));
				fields.add(f);
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return fields;

	}

	public void havestCrop(int fieldId) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "update field set plaintid = null,"
					+ " plant_day = 0,"
					+ " grow_percent = 0,"
					+ " water_level = 0,"
					+ " status = ? where fieldid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "EMPTY");
			stmt.setInt(2, fieldId);
			stmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateGrowth(int fieldId, int newGrowPercent, String newStatus) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "update field set grow_percent = ?, status = ? where fieldid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newGrowPercent);
			stmt.setString(2, newStatus);
			stmt.setInt(3, fieldId);
			stmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public Field getEmptyField() {
	    ArrayList<Field> fields = getAllFields();
	    for (Field f : fields) {
	        if (f.getStatus().equals("EMPTY")) {
	            return f;
	        }
	    }
	    return null;
	}

	public void plantOnField(int fieldId, int plantId, int plantDay) {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update field set plaintid = ?, plant_day = ?, grow_percent = 0, water_level = 100, status = ? where fieldid = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, plantId);
	        stmt.setInt(2, plantDay);
	        stmt.setString(3, "GROWING");
	        stmt.setInt(4, fieldId);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void clearAllFields() {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "delete from field";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void reduceWater(int fieldId, int newWaterLevel) {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update field set water_level = ? where fieldid = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, newWaterLevel);
	        stmt.setInt(2, fieldId);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
	public void waterField(int fieldId) {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update field set water_level = 100 where fieldid = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, fieldId);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
