package me.RegalMachine.XanderQuest.Regions.Sessions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class StartSelectionSessionCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		Player player = Bukkit.getPlayer(sender.getName());
		if(player.hasPermission("xanderquest.admin")){
			player.setItemInHand(new ItemStack(Material.BLAZE_ROD));
			player.sendMessage(ChatColor.AQUA + "Here is your QuestWand!");
			SessionManager.newSelectionSession(player);
		}else{
			player.sendMessage(ChatColor.AQUA + "You dont have permission to get a QuestWand.");
		}
		return true;
	}

}
