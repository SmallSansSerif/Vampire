package com.massivecraft.vampire.cmd;

import org.bukkit.entity.Player;

import com.massivecraft.vampire.*;

public class CmdAdminFeed extends VCommand
{
	public CmdAdminFeed() {
		aliases.add("afeed");

		requiredArgs.add("playername");
		optionalArgs.put("food", "20");
		
		helpShort = "feed someone";
		
		permission = Permission.COMMAND_FEED.node;
		senderMustBePlayer = false;
		senderMustBeVampire = false;
	}
	
	@Override
	public void perform()
	{
		Player you = this.argAsBestPlayerMatch(0);
		if (you == null) return;
		
		int foodToAdd = this.argAsInt(1, 20);

		String msg = you.getDisplayName() + " was fed from " + you.getFoodLevel();
		you.setFoodLevel(VPlayer.limitNumber(you.getFoodLevel() + foodToAdd, 0, 20));
		msg += " to " + you.getFoodLevel() + ".";
		
		this.msg(msg);
	}
}