package me.RegalMachine.XanderQuest.Regions;

import java.util.ArrayList;
import java.util.List;

public class RegionManager {
	
	public List<Region> regions = new ArrayList<Region>();
	
	
	public boolean contains(Region r){
		if(regions.contains(r)){
			return true;
		}
		return false;
	}
	
	public Region getRegion(int id){
		for(Region r: regions){
			if(r.getID() == id)
				return r;
		}
		return null;
	}
}
