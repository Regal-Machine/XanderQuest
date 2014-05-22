package me.RegalMachine.XanderQuest;

import java.io.File;
import java.io.InputStream;

import me.RegalMachine.XanderQuest.Regions.ChunkRefList;
import me.RegalMachine.XanderQuest.Regions.GlobalRegion;
import me.RegalMachine.XanderQuest.Regions.RegionManager;
import me.RegalMachine.XanderQuest.Regions.WorldManager;
import me.RegalMachine.XanderQuest.Regions.Commands.RegionCommands;
import me.RegalMachine.XanderQuest.Regions.Events.LoginHandler;
import me.RegalMachine.XanderQuest.Regions.Events.RegionChangeEventThrower;
import me.RegalMachine.XanderQuest.Regions.Sessions.SessionManagerEvents;
import me.RegalMachine.XanderQuest.Regions.Sessions.StartSelectionSessionCommand;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class XanderQuest extends JavaPlugin{
	
	
	FileConfiguration regionData = null;
	File regionDataFile = null;
	public static XanderQuest instance;
	
	
	@Override
	public void onEnable() {
		
		instance = this;
		getCommand("qwand").setExecutor(new StartSelectionSessionCommand());
		getCommand("region").setExecutor(new RegionCommands());
		
		getServer().getPluginManager().registerEvents(new SessionManagerEvents(), this);
		getServer().getPluginManager().registerEvents(new RegionChangeEventThrower(), this);
		getServer().getPluginManager().registerEvents(new LoginHandler(), this);
		
		for(World world: Bukkit.getWorlds()){
			RegionManager rm = new RegionManager();
			WorldManager.chunks.put(world, new ChunkRefList());
			WorldManager.worlds.put(world, rm);
			WorldManager.gRegions.put(world, new GlobalRegion(world));
			WorldManager.regionManagers.add(rm);
		}
		
		
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}
	
	
	public FileConfiguration getRegionData(){ 
		if(this.regionData == null)
			reloadRegionData();
		return regionData;
	}

	private void reloadRegionData(){
		if(this.regionData == null){
			this.regionDataFile = new File(getDataFolder(), "Region.yml");
		}
		this.regionData = YamlConfiguration.loadConfiguration(this.regionDataFile);
		InputStream defConfigStream = getResource("Region.yml");
		if(defConfigStream != null){
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
		    this.regionData.setDefaults(defConfig);
		}
	}
	
}
