package com.github.nutmegmk0.commandextension.command;

import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;

import com.github.nutmegmk0.commandextension.main.CommandExtension;

public class CommandDamage implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		//引数：検索対象のタグ,ダメージ

		if (arg3.length != 2) {

			arg0.sendMessage("引数の数がおかしいです！");
			return false;
		}

		boolean check = false;

		List<World> worldlist = Bukkit.getWorlds();

		for (int i = 0, n = worldlist.size(); i < n;i++) {

			World w = worldlist.get(i);

			List<LivingEntity> el = w.getLivingEntities();

			if (!el.isEmpty()) {

				for (int ii = 0, nn = el.size(); ii < nn; ii++) {

					LivingEntity e = el.get(ii);

					Set<String> s = e.getScoreboardTags();

					if (!s.isEmpty()) {

						if (s.contains(arg3[0])) {

							e.damage(Double.parseDouble(arg3[1]));

							check = true;

						}

					}

				}

			}



			//デバッグメッセージ
			if (CommandExtension.debugmode) arg0.sendMessage((i + 1) + "つめのワールドのチェックが完了しました ");

		}

		if (check == false) {
			arg0.sendMessage("検索条件に1件もヒットしませんでした。タグを間違えている可能性があります");

			return false;
		}

		return true;
	}

}
