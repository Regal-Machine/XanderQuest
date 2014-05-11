package me.RegalMachine.XanderQuest.Regions.Sessions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SelectionSession {
	
	
	private Location loc1, loc2;
	private World world;
	
	public SelectionSession(Player p){
		p.setItemInHand(new ItemStack(Material.POISONOUS_POTATO));
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
	
	
}
