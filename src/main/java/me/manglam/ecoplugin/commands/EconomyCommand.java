package me.manglam.ecoplugin.commands;

import me.manglam.ecoplugin.data.EconomyDAO;
import me.manglam.ecoplugin.players.TopPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class EconomyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;


        if (args.length > 0) {
            String subCommand = args[0].toLowerCase();
            switch (subCommand) {
                case "balance":
                    double balance = EconomyDAO.getBalance(player.getUniqueId());
                    player.sendMessage("Your balance: " + balance);
                    break;
                case "add":
                    if (args.length == 3) {
                        double amount = Double.parseDouble(args[2]);
                        EconomyDAO.addToBalance(player.getUniqueId(), amount);
                        player.sendMessage("Added " + amount + " to your balance.");
                    } else {
                        player.sendMessage("Usage: /eco add <amount>");
                    }
                    break;
                case "top":

                    List<TopPlayer> topPlayers = EconomyDAO.getTopPlayers(10);
                    player.sendMessage("Top 10 Players:");
                    for (TopPlayer topPlayer : topPlayers) {
                        player.sendMessage(topPlayer.getName() + ": " + topPlayer.getBalance());
                    }
                    break;

                default:
                    player.sendMessage("Invalid subcommand. Usage: /eco <balance/add/top/balancetop>");
            }
        } else {
            player.sendMessage("Usage: /eco <balance/add/top/balancetop>");
        }

        return true;
    }
}

