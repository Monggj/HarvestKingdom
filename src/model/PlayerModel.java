package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Player;

public class PlayerModel {

	public Player getPlayer() {
		Player p = null;
		Connection conn = null;
		try {
			
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from player where playerid = 1";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				p= new Player();
				p.setPlayerId(rs.getInt("playerid"));
				p.setMoney(rs.getInt("money"));
				p.setCurrentDay(rs.getInt("current_day"));
			
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	
	
	public void updateMoney(int newMoney) {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update player set money = ? where playerid = 1";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, newMoney);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void updateCurrentDay(int newDay) {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update player set current_day = ? where playerid = 1";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, newDay);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void resetPlayer() {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
	        String sql = "update player set money = 1000, current_day = 1 where playerid = 1";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.executeUpdate();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
