package com.ntcreations.KoboldScent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KoboldScent extends JavaPlugin {
	 private static KoboldScent instance = null;
	
	@Override
	public void onEnable() {
		instance = this;
		 registerEvents(this,new PlayerEvents());
		 
	    getCommand("KS").setExecutor(new Commands());
	    initconfig();
	    getLogger().info("KoboldScent Initialized");
	}
 
	@Override
	public void onDisable() {
		getLogger().info("KoboldScent Unloaded");
	}
	 public static KoboldScent getInstance() {
		 return instance;
		 }
	 
	private void initconfig(){
	    FileConfiguration config = getConfig();
	    
	    List<String> players = config.getStringList("Players");
	    players.add("Patey");
	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	    Date date = new Date();
	    config.addDefault("Players.Patey",dateFormat.format(date));
	    config.addDefault("Players.Patey."+dateFormat.format(date)+".Location",Bukkit.getPlayer("Patey").getLocation());
	    config.addDefault("Players.Patey."+dateFormat.format(date)+".Race", );
	    config.options().copyDefaults(true);
	    saveConfig();
	}
	
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
	
}
