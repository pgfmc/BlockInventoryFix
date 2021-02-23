package tk.pgfriends.blockinvfix;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import tk.pgfriends.blockinvfix.events.InventoryEvents;
import tk.pgfriends.blockinvfix.events.PlayerEvents;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		
	}
}