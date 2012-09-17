package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_qop extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        if (!(senderIsConsole || sender.isOp()))
        {
            sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }

        boolean matched_player = false;

        String target = args[0].toLowerCase();

        for (Player p : server.getOnlinePlayers())
        {
            if (p.getName().toLowerCase().contains(target))
            {
                matched_player = true;

                TFM_Util.adminAction(sender.getName(), "Opping " + p.getName(), false);
                p.setOp(true);
                p.sendMessage(TotalFreedomMod.YOU_ARE_OP);
            }
        }

        if (!matched_player)
        {
            TFM_Util.playerMsg(sender, "No targets matched.");
        }

        return true;
    }
}
