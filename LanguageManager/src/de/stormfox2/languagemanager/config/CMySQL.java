package de.stormfox2.languagemanager.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.stormfox2.languagemanager.mysql.MySQL;

public class CMySQL {

	public void setStandart() {
		FileConfiguration cfg = getFileConfiguration();
		
		cfg.options().copyDefaults(true);
		cfg.addDefault("host", "localhost");
		cfg.addDefault("port", 3306);
		cfg.addDefault("username", "root");
		cfg.addDefault("password", "password");
		cfg.addDefault("database", "languagemanager");
		
		try {
			cfg.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getFile() {
		
		File file = new File("plugins/LanguageManager", "mysql.yml");
		
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return file;
	}
	
	public FileConfiguration getFileConfiguration() {
		return YamlConfiguration.loadConfiguration(getFile());
	}
	
	public void readData() {
		FileConfiguration cfg = getFileConfiguration();
		MySQL mySQL = MySQL.getInstance();

		mySQL.setHost(cfg.getString("host"));
		mySQL.setPort(cfg.getInt("port"));
		mySQL.setDatabase(cfg.getString("database"));
		mySQL.setUsername(cfg.getString("username"));
		mySQL.setPassword(cfg.getString("password"));
		
	}
	
}
