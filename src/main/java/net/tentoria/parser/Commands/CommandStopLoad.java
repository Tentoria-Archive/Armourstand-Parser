package net.tentoria.parser.Commands;

import net.minecraft.server.v1_8_R3.CommandExecute;
import net.tentoria.parser.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStopLoad implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            Main.getMainPlugin().setLoadAllChunks(false);
            player.sendMessage(ChatColor.GOLD + "Parser >> "+ChatColor.YELLOW+"Finished loading chunks & Unloaded chunks. Parsing will no longer work properly.");

        }

        return true;
    }

}
