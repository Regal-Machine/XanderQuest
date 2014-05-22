package me.RegalMachine.XanderQuest.Regions;

import java.util.ArrayList;
import java.util.List;



import org.bukkit.Location;
import org.bukkit.World;


public class RegionManager{
	
	private List<Region> regions = new ArrayList<Region>();
	
	public List<Region> getRegions(){
		return regions;
	}
	
	public void addRegion(Region region){
		regions.add(region);
		ChunkRefList chunkList = WorldManager.chunks.get(getWorld());
		for(int z = region.getLowVector().getBlockZ(); z<= region.getHighVector().getBlockZ();z++){
			for(int x = region.getLowVector().getBlockX(); x<=region.getHighVector().getBlockX(); x++){
				ChunkRef ref = new ChunkRef(x,z);
				chunkList.addRegionToChunk(ref, region);
			}
		}
		// TODO Link the regions to the config. 
	}
	
	
	public boolean contains(Region r){
		if(regions.contains(r)){
			return true;
		}
		return false;
	}
	
	public Region getRegion(String name){
		for(Region r: regions){
			if(r.getName().equalsIgnoreCase(name))
				return r;
		}
		return null;
	}
	
	public World getWorld(){
		for(World world: WorldManager.worlds.keySet()){
			if(WorldManager.worlds.get(world).equals(this)){
				return world;
			}
		}
		return null;
	}
	
public static final class ChunkRef{
		
		protected int baseX;
		protected int baseZ;
		
		public ChunkRef(Location loc){
			this.baseX = (loc.getBlockX()) >> 4;
			this.baseZ = (loc.getBlockZ()) >> 4;
		}
		
		public ChunkRef(int x, int z){
			baseX = x >> 4;
			baseZ = z >> 4;
		}
		
		
		public boolean equals(final ChunkRef ref){
			if(ref == this)
				return true;
			if(ref == null)
				return false;
			if(getClass() != this.getClass())
				return false;
			return this.baseX == ref.getX() && this.baseZ == ref.getZ();
		}
		
		public int getX(){
			return baseX;
		}
		public int getZ(){
			return baseZ;
		}
		
		
	}
	
}
