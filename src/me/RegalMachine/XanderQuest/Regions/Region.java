package me.RegalMachine.XanderQuest.Regions;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Region extends AbstractRegion{
	
	private String name;
	private Vector v1, v2;
	List<SubRegion> subRegions = new ArrayList<SubRegion>();
	
	public Region(Vector vect1, Vector vect2, String namee){
		int xlow, xhigh, zlow, zhigh, ylow, yhigh;
		
		if(vect1.getBlockX() >= vect2.getBlockX()){
			xhigh = vect1.getBlockX();
			xlow = vect2.getBlockX();
		}else{
			xhigh = vect2.getBlockX();
			xlow = vect1.getBlockX();
		}
		
		if(vect1.getBlockY() >= vect2.getBlockY()){
			yhigh = vect1.getBlockY();
			ylow = vect2.getBlockY();
		}else{
			yhigh = vect2.getBlockY();
			ylow = vect1.getBlockY();
		}
		
		if(vect1.getBlockZ() >= vect2.getBlockZ()){
			zhigh = vect1.getBlockZ();
			zlow = vect2.getBlockZ();
		}else{
			zhigh = vect2.getBlockZ();
			zlow = vect1.getBlockZ();
		}
		
		v1 = new Vector(xlow, ylow, zlow);
		v2 = new Vector(xhigh, yhigh, zhigh);
		
		name = namee;
		
	}
	public Vector getLowVector(){
		return v1;
	}
	
	public Vector getHighVector(){
		return v2;
	}
	
	public RegionManager getRegionManager(){
		for(RegionManager rm: WorldManager.regionManagers){
			if(rm.contains(this)){
				return rm;
			}
		}
		return null;
	}
	
	public boolean contains(Location loc){
		if((loc.getBlockX() >= v1.getBlockX()) && (loc.getBlockX() <= v2.getBlockX()) && (loc.getBlockY() >= v1.getBlockY()) && (loc.getBlockY() <= v2.getBlockY()) && (loc.getBlockZ() >= v1.getBlockZ()) && (loc.getBlockZ() <= v2.getBlockZ()))
			return true;
		return false;
	}
	
	
	public String getName(){
		//Go in config and do it.
		return name;
	}
	
	public String getDesc(){
		return "";
	}
	
	public List<SubRegion> getSubRegions(){
		return subRegions;
	}
	
	
}
