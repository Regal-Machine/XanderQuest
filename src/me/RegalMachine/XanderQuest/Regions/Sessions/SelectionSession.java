package me.RegalMachine.XanderQuest.Regions.Sessions;

import me.RegalMachine.XanderQuest.Regions.Region;
import me.RegalMachine.XanderQuest.Regions.WorldManager;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SelectionSession {
	
	private Vector vLoc1 = null;
	private Vector vLoc2 = null;
	private World world;
	
	public SelectionSession(Player p){
		world = p.getWorld();
	}
	
	public World getWorld(){
		return world;
	}
	
	public void setLocationOne(Vector loc){
		vLoc1 = new Vector(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
	}
	
	public void setLocationTwo(Vector loc){
		vLoc2 = new Vector(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
	}
	
	public Vector getLocationOne(){
		return vLoc1;
	}
	
	public Vector getLocationTwo(){
		return vLoc2;
	}
	
	public boolean canCreateRegion(){
		
			if(vLoc1 == null || vLoc2 == null)
				return false;
			
			return true;
	}
	
	public void createRegion(String name) {
		// TODO Auto-generated method stub
		WorldManager.worlds.get(world).addRegion(new Region(vLoc1, vLoc2, name));
	}
	
	
}
