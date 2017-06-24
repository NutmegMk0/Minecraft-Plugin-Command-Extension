package com.github.nutmegmk0.commandextension.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;

public class CommandBullet implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		//コマンドの引数メモ：/Bullet 射出元プレイヤー 設定する名前 飛行速度 消滅までのタイマー 透明かどうか
		//          それの例：/Bullet NutmegMk0 エクスプロージョン 0.5 100(Tick単位) false(true以外なら何でも透明にはならない)

		Player player =arg0.getServer().getPlayer(arg3[0]);

		if (player == null) {

			arg0.sendMessage(arg3[0] + " というプレイヤーはいません！");
		}

		Silverfish Bullet = (Silverfish) player.getWorld().spawnEntity(player.getLocation(), EntityType.SILVERFISH);

		return false;
	}

}
