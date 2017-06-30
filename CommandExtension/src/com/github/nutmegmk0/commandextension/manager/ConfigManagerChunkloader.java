package com.github.nutmegmk0.commandextension.manager;

import java.util.List;
import java.util.logging.Level;

import com.github.nutmegmk0.commandextension.main.CommandExtension;

public class ConfigManagerChunkloader {

	public static String[] loadChunksString;


	public ConfigManagerChunkloader () {

	}

	public void load (CommandExtension plugin) {


		List<String> loadchunks = plugin.config.getStringList("chunkload.load");

		loadChunksString = (String[])loadchunks.toArray(loadChunksString);

		if (CommandExtension.debugmode && loadChunksString.length != 0) {

			plugin.getServer().getLogger().log(Level.INFO, "Chunks:");

			for (int i = 0; i < loadChunksString.length; i++) {

				if (i == 0) {

					plugin.getServer().getLogger().log(Level.INFO,loadChunksString[i]);

				} else {

					plugin.getServer().getLogger().log(Level.INFO," "+loadChunksString[i]);

				}

			}

		} else if (CommandExtension.debugmode) {

			plugin.getServer().getLogger().log(Level.INFO, "Chunks is empty");

		}
	}

}
