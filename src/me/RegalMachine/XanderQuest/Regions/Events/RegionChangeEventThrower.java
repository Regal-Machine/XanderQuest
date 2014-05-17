package me.RegalMachine.XanderQuest.Regions.Events;

import java.util.HashMap;
import java.util.Map;

import me.RegalMachine.XanderQuest.Regions.Region;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class RegionChangeEventThrower implements Listener{
	
	
	public static Map<Player, Region> playerRegions = new HashMap<Player, Region>();
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		
		// TODO Make the plugin throw a RegionChangeEvent when a player switches region. 
		
		
		
		
	}

}
