package me.RegalMachine.XanderQuest.Regions.Events;

import me.RegalMachine.XanderQuest.Regions.WorldManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginHandler implements Listener{
	
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJoin(PlayerJoinEvent e){
		Player  p = e.getPlayer();
		RegionChangeEventThrower.playerRegions.put(p, WorldManager.gRegions.get(p.getWorld()));
	}
	

}
