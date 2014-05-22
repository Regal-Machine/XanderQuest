package me.RegalMachine.XanderQuest.Regions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.World;

public class WorldManager {
		
	
	public static Map<World, RegionManager> worlds = new HashMap<World, RegionManager>();
	public static Map<World, ChunkRefList> chunks = new HashMap<World,ChunkRefList>();
	public static Map<World, GlobalRegion> gRegions = new HashMap<World, GlobalRegion>();
	public static List<RegionManager> regionManagers = new ArrayList<RegionManager>();
	
	
	
	
	
	
	
	
}
