package net.tentoria.parser;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;


import java.util.UUID;

public class EHandler implements Listener {

    @EventHandler
    public void onTarget(ChunkUnloadEvent event){
        if(Main.getMainPlugin().isLoadAllChunks()){
            event.setCancelled(true);
        }
    }

}
