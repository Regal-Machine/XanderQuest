package me.RegalMachine.XanderQuest.Regions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.RegalMachine.XanderQuest.Regions.RegionManager.ChunkRef;

public class ChunkRefList {
	
	private Map<ChunkRef, ArrayList<Region>> regionsInChunkRef = new HashMap<ChunkRef, ArrayList<Region>>();
	
	public ArrayList<Region> getRegionsInChunk(ChunkRef cr){
		for(ChunkRef ch: regionsInChunkRef.keySet()){
			if(cr.equals(ch))
				return regionsInChunkRef.get(ch);
		}
		return null;
	}
	
	public void addRegionToChunk(ChunkRef ref, Region reg){
		boolean chunkStored = false;
		for(ChunkRef ch: regionsInChunkRef.keySet()){
			if(ref.equals(ch)){
				regionsInChunkRef.get(ch).add(reg);
				chunkStored = true;
			}
		}
		if(!chunkStored){
			regionsInChunkRef.put(ref, new ArrayList<Region>());
			regionsInChunkRef.get(ref).add(reg);
		}
	}
}
