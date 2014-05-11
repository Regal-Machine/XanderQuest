package me.RegalMachine.XanderQuest.Regions.Sessions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SelectionSession {
	
	private Location loc1, loc2;
	private World world;
	
	public SelectionSession(Player p){
		world = p.getWorld();
	}
	
	public World getWorld(){
		return world;
	}
	
	public void setLocationOne(Location loc){
		loc1 = loc;
	}
	
	public void setLocationTwo(Location loc){
		loc2 = loc;
	}
	
	public Location getLocationOne(){
		return loc1;
	}
	
	public Location getLocationTwo(){
		return loc2;
	}
	
	public Vector getLocationOneVector(){
		return new Vector(loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ());
	}
	
	public Vector getLocationTwoVector(){
		return new Vector(loc2.getBlockX(), loc2.getBlockY(), loc2.getBlockZ());
	}
	
	public boolean canCreateRegion(){
		
		if(loc1 != null && loc2 != null)
			return true;
		
		return false;
	}
	
	public void createRegion() {
		// TODO Auto-generated method stub
		Bukkit.getServer().broadcastMessage("Simulate Making of a Reigon!");
	}
	
	
}
