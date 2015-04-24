package com.ntcreations.KoboldScent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		configHandler cfg = new configHandler();
		Config customConfig;
		
		if (cmd.getName().equalsIgnoreCase("KS")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
				return true;
			} else {
				if (args.length == 0){
					sender.sendMessage("KoboldScent V0.0.1");
					sender.sendMessage("Designed by Patey for the DFRP community");
					return true;
				}
				if (args.length == 1){
					if (args[0].equalsIgnoreCase("reload")){
						KoboldScent.getInstance().reloadConfig();
						sender.sendMessage("KoboldScent reloaded");
						return true;
					}
				}
			}
		}
		if (cmd.getName().equalsIgnoreCase("nose")) {
			Player p = (Player) sender;
			Utils utils = new Utils();
			Location location = p.getLocation();
			customConfig = new Config("Scents");
			
			for(String player : cfg.getCustomConfig(customConfig).getKeys(false)){
				for(String date : cfg.getCustomConfig(customConfig).getConfigurationSection("Players."+player).getKeys(false)){
					for(String time : cfg.getCustomConfig(customConfig).getConfigurationSection("Players."+player+"."+date).getKeys(false)){
						Location loc = utils.convertStringToLocation(cfg.getCustomConfig(customConfig).getString("Players."+player+"."+date+"."+time));
						if (p.getLocation().distance(loc) <= 10){
							
						}
					}	
				}
			}
		}
		
		return false;
	}
}