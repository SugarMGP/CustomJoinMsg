package io.github.sugarmgp.Command;

import io.github.sugarmgp.CustomJoinMsg;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainCommand implements CommandExecutor, TabExecutor {
    private static String msgHead = ChatColor.YELLOW + "[CustomJoinMsg] ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = CustomJoinMsg.getProvidingPlugin(CustomJoinMsg.class);
        if (!(sender.hasPermission("cjm.commands.use"))) {
            sender.sendMessage(msgHead + ChatColor.RED + "No permission.");
            return false;
        }
        if (args.length == 1 && Objects.equals(args[0], "reload")) {
            plugin.reloadConfig();
            sender.sendMessage(msgHead + ChatColor.AQUA + "Config reload successfully.");
        } else {
            sender.sendMessage(msgHead + ChatColor.RED + "Wrong parameters.");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> commandTab = new ArrayList<>();
        commandTab.add("reload");
        if (args.length == 1) {
            return commandTab;
        }
        return null;
    }
}