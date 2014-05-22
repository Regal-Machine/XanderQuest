package me.RegalMachine.XanderQuest.Regions.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.RegalMachine.XanderQuest.Regions.AbstractRegion;
import me.RegalMachine.XanderQuest.Regions.ChunkRefList;
import me.RegalMachine.XanderQuest.Regions.Region;
import me.RegalMachine.XanderQuest.Regions.RegionManager.ChunkRef;
import me.RegalMachine.XanderQuest.Regions.WorldManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RegionChangeEventThrower implements Listener{
	
	
	public static Map<Player, AbstractRegion> playerRegions = new HashMap<Player, AbstractRegion>();
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		// TODO Make the plugin throw a RegionChangeEvent when a player switches region. 
		Player p = e.getPlayer();
		
		if(playerRegions.get(p) instanceof Region){
			if(!((Region) playerRegions.get(p)).contains(p.getLocation())){
			
				ChunkRef chunk = new ChunkRef(p.getLocation());
				ChunkRefList crl = WorldManager.chunks.get(p.getWorld());
				ArrayList<Region> regionsToCheck = crl.getRegionsInChunk(chunk);
				
				boolean newFoundRegion = false;
				
				for(Region region: regionsToCheck){
					if(region.contains(p.getLocation())){
						
						newFoundRegion = true;
						
						Region[] regions = new Region[1];
						regions[0] = (Region) playerRegions.get(p);
						regions[1] = region;
						playerRegions.remove(p);
						playerRegions.put(p, region);
						
						RegionChangeEvent event = new RegionChangeEvent(regions[1], regions[0], p);
						Bukkit.getServer().getPluginManager().callEvent(event);
					
					
							
						break;
					}
				}
				
				if(!newFoundRegion){
					playerRegions.remove(p);
					playerRegions.put(p, WorldManager.gRegions.get(p.getWorld()));
				}
				
			}
		}else{
			ChunkRef chunk = new ChunkRef(p.getLocation());
			ChunkRefList crl = WorldManager.chunks.get(p.getWorld());
			ArrayList<Region> regionsToCheck = crl.getRegionsInChunk(chunk);
			
			for(Region region: regionsToCheck){
				if(region.contains(p.getLocation())){
					playerRegions.remove(p);
					playerRegions.put(p, region);
					
					Bukkit.getServer().getPluginManager().callEvent(new RegionChangeEvent(playerRegions.get(p), WorldManager.gRegions.get(p.getWorld()),p));
				}
			}
			
		}
	}
	
	@EventHandler
	public void onRegionChangeEvent(RegionChangeEvent e){
		e.getPlayer().sendMessage("Region Change Event Thrown!");
	}
	
}
