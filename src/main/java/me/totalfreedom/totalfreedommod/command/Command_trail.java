package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Trails rainbow wool behind you as you walk/fly.", usage = "/<command>")
public class Command_trail extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (plugin.tr.contains(playerSender))
        {
            plugin.tr.remove(playerSender);
            msg("Trail disabled.");
        }
        else
        {
            plugin.tr.add(playerSender);
            msg("Trail enabled. Use \"/trail off\" to disable.");
        }

        return true;
    }

}
