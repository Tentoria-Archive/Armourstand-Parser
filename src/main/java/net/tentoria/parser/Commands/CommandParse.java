package net.tentoria.parser.Commands;

import net.minecraft.server.v1_8_R3.CommandExecute;
import net.tentoria.parser.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class CommandParse implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            player.sendMessage(ChatColor.GOLD + "Parser >> "+ChatColor.YELLOW+"Beginning Parse. Do not move else you may cause issues.");

            try {
                Writer writer = new FileWriter(new File(Bukkit.getServer().getWorlds().get(0).getWorldFolder().getPath()+"/data.amf"));
                BufferedWriter write = new BufferedWriter(writer);

                String finalString = "";

                for(Entity entity: Bukkit.getServer().getWorlds().get(0).getEntities()){
                    if(entity.getType() == EntityType.ARMOR_STAND){
                        if(entity.isCustomNameVisible()){
                            finalString = finalString.concat("\n"+entity.getCustomName() + "="+String.valueOf(entity.getLocation().getBlockX())+","+String.valueOf(entity.getLocation().getBlockY())+","+String.valueOf(entity.getLocation().getBlockZ()));
                            entity.remove();
                        }
                    }
                }

                finalString = finalString.substring(1);

                write.write(finalString);
                write.close();


            } catch (Exception err) {
                err.printStackTrace();
                player.sendMessage(ChatColor.GOLD + "Parser >> "+ChatColor.YELLOW+"Error: The parser experienced an error while writing to the config. The error has been logged.");
            }

            player.sendMessage(ChatColor.GOLD + "Parser >> "+ChatColor.YELLOW+"Successfully parsed map. The generated file (data.amf) is now in the world's directory");

        }

        return true;
    }

}
