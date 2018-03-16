package de.stormfox2.languagemanager;

import org.bukkit.plugin.java.JavaPlugin;

import de.stormfox2.languagemanager.config.CMySQL;
import de.stormfox2.languagemanager.mysql.MySQL;
import de.stormfox2.languagemanager.utils.Language;
import de.stormfox2.languagemanager.utils.Manager;

public class LanguageManager extends JavaPlugin{

	@Override
	public void onEnable() {
		new MySQL();
		CMySQL cMySQL = new CMySQL();
		cMySQL.setStandart();
		cMySQL.readData();
		MySQL.getInstance().connect();
		super.onEnable();
		
		new Manager();
		
	}
	
	@Override
	public void onDisable() {
		MySQL.getInstance().disconnect();
		super.onDisable();
	}
}
