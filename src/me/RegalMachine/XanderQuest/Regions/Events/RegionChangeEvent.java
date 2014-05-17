package me.RegalMachine.XanderQuest.Regions.Events;

import me.RegalMachine.XanderQuest.Regions.Region;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RegionChangeEvent extends Event{
	
	private static final HandlerList handlers = new HandlerList();
	
	private Region Eregion;
	private Player Eplayer;
	private boolean cancelled;
	
	
	
	public RegionChangeEvent(Region region, Player player){
		Eregion = region;
		Eplayer = player;
	}
	
	public Region getRegion(){
		return Eregion;
	}
	
	public Player getPlayer(){
		return Eplayer;
	}
	
	public void setCancled(boolean b){
		cancelled = b;
	}
	
	public boolean isCancelled(){
		return cancelled;
	}
	
	
	
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}
	
	
}
