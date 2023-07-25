package me.maikkrs.replant;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;


public final class Replant extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[Replant] ON");
        getServer().getPluginManager().registerEvents(this,this);

    }

    @EventHandler
    public void onPlayerRightClickCrop (PlayerInteractEvent event){
        Block crop = event.getClickedBlock();
        assert crop != null;
        Material material = crop.getType();

        Ageable ageable = (Ageable) crop.getBlockData();
        int age = ageable.getAge();



        if(event.getAction().toString().equals("RIGHT_CLICK_BLOCK") && isCrop(material) && age == ageable.getMaximumAge()){
            crop.breakNaturally();
           crop.setType(material);
        }
    }

    public boolean isCrop(Material material) {
        switch (material) {
            case WHEAT:
            case CARROTS:
            case POTATOES:
            case BEETROOTS:
            case MELON:
            case PUMPKIN:
            case SUGAR_CANE:
            case COCOA_BEANS:
            case NETHER_WART:
            case SWEET_BERRY_BUSH:
                return true;
            default:
                return false;
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[Replant] OFF");
    }
}
