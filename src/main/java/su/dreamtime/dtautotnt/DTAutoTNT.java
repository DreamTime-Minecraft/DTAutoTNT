package su.dreamtime.dtautotnt;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.MetadataValueAdapter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public final class DTAutoTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    Random random = new Random();
    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {
        if (e.getBlock().getType().equals(Material.TNT)) {

//            e.getBlock().setType(Material.AIR);
            Player source = e.getPlayer();

            Block block = e.getBlockPlaced();
            if (block != null) {

                World world = block.getWorld();
                Location loc2 = block.getLocation();
                Location location = new Location(loc2.getWorld(), loc2.getBlockX() + 0.5, loc2.getBlockY(), loc2.getBlockZ() + 0.5);
                TNTPrimed tnt = world.spawn(location, TNTPrimed.class);
                tnt.setFuseTicks(50);
                tnt.setGlowing(true);
                block.setType(Material.AIR);

            }
        }
    }
}
