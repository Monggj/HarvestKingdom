package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Transaction;

public class TransactionModel {

	public ArrayList<Transaction> getAllTransaction() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();

		try {

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:harvestKingdom.db");
			String sql = "select* from transactionl";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();
				t.setTransactionId(rs.getInt("transaction_id"));
				t.setPlayerId(rs.getInt("player_id"));
				t.setType(rs.getString("type"));
				t.setItemName(rs.getString("item_name"));
				t.setAmount(rs.getInt("amount"));
				t.setDay(rs.getInt("day"));
				transactions.add(t);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactions;
	}
}