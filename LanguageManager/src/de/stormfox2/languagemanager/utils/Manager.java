package de.stormfox2.languagemanager.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import de.stormfox2.languagemanager.mysql.MySQL;

public class Manager {
	public static Manager instance;
	private HashMap<String, String> player;
	
	public Manager() {
		instance = this;
		
		player = new HashMap<>();
		
		init();
	}
	
	public void init(){
		MySQL mysql = MySQL.getInstance();
		String sql = "SELECT * FROM Language";
		try {
			PreparedStatement request = mysql.getConnection().prepareStatement(sql);
			ResultSet result = request.executeQuery();
			while(result.next()) {
				String languageID= result.getString(1);
				String name = result.getString(2);
				
				System.out.println("[LanguageManager] Initializing language: " + name + "/" + languageID);
				setPlayer(languageID, name);
				request.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap<String, String> getPlayer() {
		return player;
	}

	public void setPlayer(String UUID, String LID) {
		player.put(UUID, LID);
	}

	public static Manager getInstance() {
		return instance;
	}
	
}
