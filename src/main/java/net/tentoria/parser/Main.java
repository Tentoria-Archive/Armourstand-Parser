package net.tentoria.parser;

import net.tentoria.parser.Commands.CommandBeginLoad;
import net.tentoria.parser.Commands.CommandParse;
import net.tentoria.parser.Commands.CommandStopLoad;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    public static Main plugin;

    private boolean loadAllChunks;

    public static Main getMainPlugin(){
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        loadAllChunks = false;

        getServer().getWorlds().get(0).setAutoSave(false);

        this.getCommand("beginforceload").setExecutor(new CommandBeginLoad());
        this.getCommand("parsemap").setExecutor(new CommandParse());
        this.getCommand("stopforceload").setExecutor(new CommandStopLoad());

    }

    public boolean isLoadAllChunks() {
        return loadAllChunks;
    }

    public void setLoadAllChunks(boolean loadAllChunks) {
        this.loadAllChunks = loadAllChunks;
    }
}
