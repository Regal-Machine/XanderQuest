package me.RegalMachine.XanderQuest.Regions.Commands;

import me.RegalMachine.XanderQuest.Regions.Sessions.SessionManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegionCommands implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		if(args[0].equalsIgnoreCase("create")){
			if(SessionManager.selSessions.containsKey(p)){
				if(SessionManager.selSessions.get(p).canCreateRegion()){
					SessionManager.selSessions.get(p).createRegion();
					p.sendMessage(ChatColor.AQUA + "You have created a Quest Region!");
				}else{
					p.sendMessage(ChatColor.AQUA + "You must select a region first!");
				}
			}else{
				p.sendMessage(ChatColor.AQUA + "You must select a Start a session first!");
			}
		}
		
		return true;
	}

}
