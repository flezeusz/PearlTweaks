package pl.flezy.pearltweaks.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.flezy.pearltweaks.PearlTweaks;

public class PearlTweaksCommand implements CommandExecutor {
    private final PearlTweaks p;
    public PearlTweaksCommand(PearlTweaks p) {
        this.p = p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(args.length>=1 && args[0].equalsIgnoreCase("reload")){
            p.config.reload();
            Bukkit.broadcastMessage(ChatColor.YELLOW+"Configuration has been reloaded.");
        }
        return true;
    }
}
