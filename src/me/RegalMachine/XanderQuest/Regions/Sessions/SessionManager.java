package me.RegalMachine.XanderQuest.Regions.Sessions;

import java.util.HashMap;
import java.util.Map;


import org.bukkit.entity.Player;

public class SessionManager{
	
	public static Map<Player, SelectionSession> selSessions = new HashMap<>();
	
	public static void newSelectionSession(Player p){
		selSessions.put(p, new SelectionSession(p));
	}
	
	

	
	
	
}
