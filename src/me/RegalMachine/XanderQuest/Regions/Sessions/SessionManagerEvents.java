package me.RegalMachine.XanderQuest.Regions.Sessions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SessionManagerEvents implements Listener{
	@EventHandler
	public void onWorldSwitch(PlayerChangedWorldEvent e){
		if(SessionManager.selSessions.containsKey(e.getPlayer())){
			SessionManager.selSessions.remove(e.getPlayer());
		}
	}
	
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		// TODO: Handle the left and right click of blocks with QuestWand in order to make selections for regions in the world.
		
		Player player = e.getPlayer();
		
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(player.getInventory().getItemInHand().getType().equals(Material.BLAZE_ROD) && SessionManager.selSessions.containsKey(player)){
				SessionManager.selSessions.get(player).setLocationTwo(e.getClickedBlock().getLocation().toVector());
				player.sendMessage(ChatColor.AQUA + "Block Two Selected!");
				
				if(SessionManager.selSessions.get(player).getLocationTwo() == null)
					player.sendMessage("Selection 2 Not Sucessfull!");
			}
		}else if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			if(player.getInventory().getItemInHand().getType().equals(Material.BLAZE_ROD) && SessionManager.selSessions.containsKey(player)){
				SessionManager.selSessions.get(player).setLocationOne(e.getClickedBlock().getLocation().toVector());
				player.sendMessage(ChatColor.AQUA + "Block One Selected!");
				
				if(SessionManager.selSessions.get(player).getLocationOne() == null)
					player.sendMessage("Selection 1 Not Sucessfull!");
			}
		}
		
	}

}
