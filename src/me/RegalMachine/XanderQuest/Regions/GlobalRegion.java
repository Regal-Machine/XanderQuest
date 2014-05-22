package me.RegalMachine.XanderQuest.Regions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class GlobalRegion extends AbstractRegion{
	
	private World world;
	
	public GlobalRegion(World worldd){
		world = worldd;
	}
	
	public boolean contains(Player p){
		return p.getWorld().equals(world);
	}
	
	public boolean contains(Location loc){
		return loc.getWorld().equals(world);
	}
	

}
