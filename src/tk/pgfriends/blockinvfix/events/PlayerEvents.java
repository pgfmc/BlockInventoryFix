package tk.pgfriends.blockinvfix.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import tk.pgfriends.blockinvfix.Main;
import tk.pgfriends.blockinvfix.inventories.SmithingTable;

public class PlayerEvents implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		if (!(e.getClickedBlock().getType().equals(Material.SMITHING_TABLE))) { return; }
		 
		if (e.getClickedBlock().getType().equals(Material.SMITHING_TABLE))
		{
			if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) { return; }
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			{
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
				
					@Override
					public void run()
					{
						SmithingTable gui = new SmithingTable();
						e.getPlayer().openInventory(gui.getInventory());
					}
					
				}, 1);
			}
		}
	}

}