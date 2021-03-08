package net.tentoria.parser.Commands;

import net.minecraft.server.v1_8_R3.CommandExecute;
import net.tentoria.parser.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBeginLoad implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            Main.getMainPlugin().setLoadAllChunks(true);
            player.sendMessage(ChatColor.GOLD + "Parser >> "+ChatColor.YELLOW+"Please fly around the world to load all the chunks. The server may possibly lag if the world is big.");

        }

        return true;
    }

}
