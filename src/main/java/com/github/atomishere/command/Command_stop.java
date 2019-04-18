package com.github.atomishere.command;

import com.github.atomishere.rank.Rank;
import com.github.atomishere.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and stops the server.", usage = "/<command>")
public class Command_stop extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is going offline, come back in about 20 seconds.");
        }

        server.shutdown();

        return true;
    }
}