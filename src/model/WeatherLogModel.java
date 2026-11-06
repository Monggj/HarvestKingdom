package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.WeatherLog;

public class WeatherLogModel {

	public ArrayList<WeatherLog> getAllWeatherLogs() {
		ArrayList<WeatherLog> weatherLogs = new ArrayList<WeatherLog>();

		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from weather_log";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				WeatherLog wl = new WeatherLog();
				wl.setLogId(rs.getInt("log_id"));
				wl.setPlayerId(rs.getInt("player_id"));
				wl.setDay(rs.getInt("day"));
				wl.setWeather_type(rs.getString("weather_type"));
				weatherLogs.add(wl);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weatherLogs;
	}
}