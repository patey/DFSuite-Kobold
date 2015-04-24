package com.ntcreations.KoboldScent;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Utils {
	public Location convertStringToLocation(String s) {
		String[] split = s.split("_");
		return new Location(Bukkit.getWorld(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]));
	}
	public String convertLocationToString(Location loc) {
		return loc.getWorld().getName() + "_" + loc.getX() + "_" + loc.getY() + "_" + loc.getZ() + "_" + loc.getPitch() + "_" + loc.getYaw();
	}
}
