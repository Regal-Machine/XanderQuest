package me.RegalMachine.XanderQuest.Regions.Sessions;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SessionManager implements Listener{
	
	public static Map<Player, SelectionSession> selSessions = new HashMap<>();
	
	public static void newSelectionSession(Player p){
		selSessions.put(p, new SelectionSession(p));
	}
	
	@EventHandler
	public void onWorldSwitch(PlayerChangedWorldEvent e){
		if(selSessions.containsKey(e.getPlayer())){
			selSessions.remove(e.getPlayer());
		}
	}
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		// TODO: Handle the left and right click of blocks with QuestWand in order to make selections for regions in the world.
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getPlayer().getItemInHand().equals(Material.BLAZE_ROD) && selSessions.containsKey(e.getPlayer())){
				selSessions.get(e.getPlayer()).setLocationTwo(e.getClickedBlock().getLocation());
				e.getPlayer().sendMessage(ChatColor.AQUA + "Block One Selected!");
			}
		}else if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			if(e.getPlayer().getItemInHand().equals(Material.BLAZE_ROD) && selSessions.containsKey(e.getPlayer())){
				selSessions.get(e.getPlayer()).setLocationTwo(e.getClickedBlock().getLocation());
				e.getPlayer().sendMessage(ChatColor.AQUA + "Block Two Selected!");
			}
		}
		
	}
	
	
}
