package com.ntcreations.KoboldScent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerEvents implements Listener{
	
	configHandler cfg = new configHandler();
	Config customConfig = new Config("Scents");
	
	@EventHandler
	public void join(PlayerJoinEvent event){
		 Player p = event.getPlayer();
		 String n = p.getName();
		
		 for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
			 if (n.equalsIgnoreCase(key)){
				 
			 }
		 }
	}
	
	@EventHandler
	public void move(PlayerMoveEvent event){
		 Player p = event.getPlayer();
		 String n = p.getName();
		 Location q = event.getFrom();
		 Location w = event.getTo();
		 int mcount = 0;
		 
		 for (String key : cfg.getCustomConfig(customConfig).getKeys(false)){
			 if (key.equalsIgnoreCase(n)){
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				 Date datec = new Date();
				 Date daten = new Date();
				 List<String> player = cfg.getCustomConfig(customConfig).getStringList("Players."+key);
					 for (int i = 0; i < player.size(); i++){
						 try {
							datec = formatter.parse(player.get(i));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 if (datec.before(daten)){
							 player.remove(player.get(i));
						 }
					 }
				List<String> locations = cfg.getCustomConfig(customConfig).getStringList("Players."+key+"."+formatter.format(daten));
				if (locations)
				 
			 }
		 }
		 
	}
	
}
