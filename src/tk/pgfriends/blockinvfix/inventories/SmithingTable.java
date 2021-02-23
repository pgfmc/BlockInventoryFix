package tk.pgfriends.blockinvfix.inventories;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SmithingTable implements InventoryHolder {
	
	private Inventory inv;
	
	public SmithingTable()
	{
		inv = Bukkit.createInventory(this, 9, "Smithing Table"); //54 is max size, must be divisible by 9
		init();
	}
	
	public void init()
	{
		List<String> lore = new ArrayList<>();
		ItemStack item1 = createItem(Material.SUNFLOWER);
		lore.add("§5Click this piece of paper");
		lore.add("If something isn't working.");
		lore.add("This may or may not work.");
		ItemStack item2 = createItem("Smithing Table", Material.PAPER, lore);
		
		for (int i = 0; i < 9; i++)
		{
			if (i % 2 == 0 || i == 7)
			{
				inv.setItem(i,  item1);
			}
			if (i == 5)
			{
				inv.setItem(i, item2);
			}
		}
	}
	
	private ItemStack createItem(String name, Material mat, List<String> lore)
	{
		ItemStack item = new ItemStack(mat, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
		
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

	
	@Override
	public Inventory getInventory()
	{		
		return inv;
	}

}