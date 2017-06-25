package com.github.nutmegmk0.commandextension.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.github.nutmegmk0.commandextension.main.CommandExtension;

public class CommandBullet implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		//コマンドの引数メモ：/Bullet 射出元プレイヤー 設定する名前 飛行速度 消滅までのタイマー 透明かどうか
		//          それの例：/Bullet NutmegMk0 エクスプロージョン 0.5 100(Tick単位) false(true以外なら何でも透明にはならない)

		Player player =arg0.getServer().getPlayer(arg3[0]);

		if (player == null) {

			arg0.sendMessage(arg3[0] + " というプレイヤーはいません！");
		}

		Silverfish bullet = (Silverfish) player.getWorld().spawnEntity(player.getLocation(), EntityType.SILVERFISH);

		bullet.setCustomName(arg3[1]);

		bullet.setGravity(false);

		Vector vel = player.getLocation().getDirection();

		//bullet.setVelocity(vel.multiply(Float.parseFloat(arg3[2])));

		bullet.setInvulnerable(true);

		if (arg3[4].equals("true")) {

			PotionEffect effect = new PotionEffect(PotionEffectType.INVISIBILITY, Integer.parseInt(arg3[3]), 1, false, false);

			bullet.addPotionEffect(effect, true);
		}

		int count = 0;

        new BukkitRunnable() {

            @Override
            public void run() {

            	if (count > Integer.parseInt(arg3[3])) {
            		bullet.damage(10000);
            		cancel();
            	}

            	Location loc = bullet.getLocation();

            	loc.add(vel.multiply(Float.parseFloat(arg3[2])));

            	bullet.teleport(loc);

            }
        }.runTaskTimer(new CommandExtension(), 0, 0);

		return false;
	}

}
