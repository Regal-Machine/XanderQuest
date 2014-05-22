package me.RegalMachine.XanderQuest.Regions.Events;

import me.RegalMachine.XanderQuest.Regions.Region;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RegionChangeEvent extends Event{
	
	private static final HandlerList handlers = new HandlerList();
	
	private Region Eregion;
	private Region previous;
	private Player Eplayer;
	
	
	
	public RegionChangeEvent(Region region,Region previouss, Player player){
		Eregion = region;
		Eplayer = player;
		previous = previouss;
	}
	
	public Region getRegion(){
		return Eregion;
	}
	
	public Region getPreviousRegion(){
		return previous;
	}
	
	
	public Player getPlayer(){
		return Eplayer;
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
