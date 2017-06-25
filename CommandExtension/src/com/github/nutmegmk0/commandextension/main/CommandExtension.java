package com.github.nutmegmk0.commandextension.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.nutmegmk0.commandextension.command.CommandBullet;

public class CommandExtension extends JavaPlugin{

	public static CommandExtension plugin;

	@Override
	public void onEnable () {

		plugin = this;

		//コマンド登録
		CommandBullet comBullet = new CommandBullet();
		getCommand("bullet").setExecutor(comBullet);

	}


	@Override
	public void onDisable () {


	}
}
