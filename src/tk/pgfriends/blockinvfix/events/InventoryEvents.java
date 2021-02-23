package tk.pgfriends.blockinvfix.events;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import tk.pgfriends.blockinvfix.inventories.SmithingTable;

public class InventoryEvents implements Listener {
	
	@EventHandler
	public void onInteract(InventoryClickEvent e)
	{
		if (!(e.getClickedInventory().getHolder() instanceof SmithingTable)) { return; }
		if (e.getClickedInventory().getHolder().equals(null)) { return; }
		if (e.getSlot() != 1 && e.getSlot() != 3 && e.getSlot() != 7) { e.setCancelled(true); }
		if (e.getCurrentItem().equals(null)) { return; }
		
		ItemStack[] validItems = {createItem(Material.DIAMOND_SHOVEL), createItem(Material.DIAMOND_PICKAXE), createItem(Material.DIAMOND_AXE), createItem(Material.DIAMOND_HOE), createItem(Material.DIAMOND_HELMET), createItem(Material.DIAMOND_CHESTPLATE), createItem(Material.DIAMOND_LEGGINGS), createItem(Material.DIAMOND_BOOTS)};
		ItemStack[] netheriteItems = {createItem(Material.NETHERITE_SHOVEL), createItem(Material.NETHERITE_PICKAXE), createItem(Material.NETHERITE_AXE), createItem(Material.NETHERITE_HOE), createItem(Material.NETHERITE_HELMET), createItem(Material.NETHERITE_CHESTPLATE), createItem(Material.NETHERITE_LEGGINGS), createItem(Material.NETHERITE_BOOTS)};
		ItemStack netherite = createItem(Material.NETHERITE_INGOT);
		
		Inventory inv = e.getClickedInventory();
		// ItemStack[] items = inv.getContents();
		List<ItemStack> list = Arrays.asList(validItems);
		// List<ItemStack> list2 = Arrays.asList(netheriteItems);
		// Player player = (Player) e.getWhoClicked();
		
		
		// Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
			
			// @Override
			// public void run()
			// {
		for (ItemStack item : validItems)
		{
			if (item.getType().equals(inv.getItem(1).getType()))
			{
				if (inv.getItem(3).getType().equals(netherite.getType()))
				{
					if (!inv.getItem(7).getType().equals(netheriteItems[list.indexOf(item)].getType()))
					{
						ItemStack diaItem = inv.getItem(1).clone();
						diaItem.setType(netheriteItems[list.indexOf(item)].getType());
						inv.setItem(7, diaItem);
						// item.setType(validItems[list.indexOf(item)].getType());
						
					}
					
					
					if (e.getSlot() == 7 && e.getCurrentItem().getType().equals(netheriteItems[list.indexOf(item)].getType()))
					{
						inv.clear(1);
						if (inv.getItem(3).getAmount() > 1)
						{
							ItemStack itemStack = inv.getItem(3);
							itemStack.setAmount(inv.getItem(3).getAmount() - 1);
							inv.setItem(3, itemStack);
						} else
						{
							if (inv.getItem(3).getAmount() == 1)
							{
								inv.clear(3);
							}
						}
					}
					
					if (e.getSlot() == 1 || e.getSlot() == 3)
					{
						inv.clear(7);
					}
				}
			}
		}

	}

			// }
				
		// }, 5);
	
	@EventHandler
	public void onCloseInv(InventoryCloseEvent e)
	{
		ItemStack[] validItems = {createItem(Material.DIAMOND_SHOVEL), createItem(Material.DIAMOND_PICKAXE), createItem(Material.DIAMOND_AXE), createItem(Material.DIAMOND_HOE), createItem(Material.DIAMOND_HELMET), createItem(Material.DIAMOND_CHESTPLATE), createItem(Material.DIAMOND_LEGGINGS), createItem(Material.DIAMOND_BOOTS)};
		ItemStack[] netheriteItems = {createItem(Material.NETHERITE_SHOVEL), createItem(Material.NETHERITE_PICKAXE), createItem(Material.NETHERITE_AXE), createItem(Material.NETHERITE_HOE), createItem(Material.NETHERITE_HELMET), createItem(Material.NETHERITE_CHESTPLATE), createItem(Material.NETHERITE_LEGGINGS), createItem(Material.NETHERITE_BOOTS)};
		ItemStack netherite = createItem(Material.NETHERITE_INGOT);
		
		List<ItemStack> list = Arrays.asList(validItems);
		Inventory inv = e.getInventory();
		
		
		if (!(inv.getHolder() instanceof SmithingTable)) { return; }
		
		for (ItemStack item : validItems)
		{
			if (e.getPlayer().getInventory().addItem(inv.getItem(1)).equals(null)) { break; }
			if (e.getPlayer().getInventory().addItem(inv.getItem(3)).equals(null)) { break; }
			if (e.getPlayer().getInventory().addItem(inv.getItem(7)).equals(null)) { break; }
			
			e.getPlayer().sendMessage("1");
			if (item.getType().equals(inv.getItem(1).getType()))
			{
				e.getPlayer().sendMessage("2");
				if (inv.getItem(3).getType().equals(netherite.getType()))
				{
					e.getPlayer().sendMessage("3");
					if (inv.getItem(7).getType().equals(netheriteItems[list.indexOf(item)].getType()))
					{
						e.getPlayer().sendMessage("Deleting Netherite!");
						inv.clear(7);
						ItemStack item1 = inv.getItem(1);
						ItemStack item2 = inv.getItem(3);
						
						e.getPlayer().getInventory().addItem(item1);
						e.getPlayer().getInventory().addItem(item2);
						return;
					}
				}
			}
				
		}
		
		e.getPlayer().sendMessage("Valid upgrade not found");
		
		if (!e.getPlayer().getInventory().addItem(inv.getItem(1)).equals(null)) { e.getPlayer().getInventory().addItem(inv.getItem(1)); }
		if (!e.getPlayer().getInventory().addItem(inv.getItem(3)).equals(null)) { e.getPlayer().getInventory().addItem(inv.getItem(3)); }
		if (!e.getPlayer().getInventory().addItem(inv.getItem(7)).equals(null)) { e.getPlayer().getInventory().addItem(inv.getItem(7)); }
		
	}
		
		
	
	private ItemStack createItem(Material mat)
	{
		ItemStack item = new ItemStack(mat, 1);
		// ItemMeta meta = item.getItemMeta();
		// meta.setDisplayName(name);
		// meta.setLore(lore);
		// item.setItemMeta(meta);
		return item;
		
	}

}
