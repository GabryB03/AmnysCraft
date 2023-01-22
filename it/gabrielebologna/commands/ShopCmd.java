package it.gabrielebologna.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import it.gabrielebologna.amnyscraft.AmnysCraft;

public class ShopCmd implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			
			try
			{
				if (!AmnysCraft.getCreativeShop().isPlayerPresent(player))
				{
					AmnysCraft.sendMessage(player, "�7Eccoci qua! Adesso sei in modalit� creativa e puoi scegliere tutti gli items e blocchi che vuoi, ovviamente poi li dovrai pagare. Buona spesa! Ah, e appena hai finito, esegui il comando �c/'complete'&7.");
					AmnysCraft.getCreativeShop().openShop(player);
					return true;
				}
				else
				{
					AmnysCraft.sendMessage(player, "�7Stai gi� effettuando degli acquisti!");
					return true;
				}
			}
			catch (Exception ex)
			{
				AmnysCraft.sendMessage(player, "�7Impossibile eseguire il comando. Per favore, riprova in seguito.");
				return true;
			}
		}
		else
		{
			sender.sendMessage("�fDevi essere un player per poter utilizzare questo comando.");
			return true;
		}
	}
}