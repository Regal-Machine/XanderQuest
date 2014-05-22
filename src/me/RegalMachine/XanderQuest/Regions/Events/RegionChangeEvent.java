package me.RegalMachine.XanderQuest.Regions.Events;

import me.RegalMachine.XanderQuest.Regions.AbstractRegion;
import me.RegalMachine.XanderQuest.Regions.GlobalRegion;
import me.RegalMachine.XanderQuest.Regions.Region;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RegionChangeEvent extends Event{
	
	private static final HandlerList handlers = new HandlerList();
	
	private AbstractRegion Eregion;
	private AbstractRegion previous;
	private Player Eplayer;
	
	
	
	public RegionChangeEvent(AbstractRegion region ,AbstractRegion previouss, Player player){
		Eregion = region;
		Eplayer = player;
		previous = previouss;
	}
	
	public Object getRegion(){
		if(Eregion instanceof GlobalRegion)
			return (GlobalRegion) Eregion;
		else
			return (Region) Eregion;
	}
	
	public Object getPreviousRegion(){
		if(Eregion instanceof GlobalRegion)
			return (GlobalRegion) previous;
		else
			return (Region) previous;
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
