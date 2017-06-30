package com.github.nutmegmk0.commandextension.main;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.nutmegmk0.commandextension.command.CommandBullet;
import com.github.nutmegmk0.commandextension.command.CommandDamage;
import com.github.nutmegmk0.commandextension.command.CommandTrueDamage;
import com.github.nutmegmk0.commandextension.manager.ConfigManagerChunkloader;

public class CommandExtension extends JavaPlugin{

	public static CommandExtension plugin;

	public static ConfigManagerChunkloader managerChunkloader;


	public FileConfiguration config;

	public static boolean debugmode;

	@Override
	public void onEnable () {

		plugin = this;

		managerChunkloader = new ConfigManagerChunkloader();


		config = getConfig();

		debugmode = config.getBoolean("debug");


		managerChunkloader.load(plugin);



		//コマンド登録
		CommandBullet comBullet = new CommandBullet();
		getCommand("bullet").setExecutor(comBullet);

		CommandTrueDamage comTrueDamage = new CommandTrueDamage();
		getCommand("truedamage").setExecutor(comTrueDamage);

		CommandDamage comDamage = new CommandDamage();
		getCommand("damage").setExecutor(comDamage);

	}


	@Override
	public void onDisable () {


	}
}
