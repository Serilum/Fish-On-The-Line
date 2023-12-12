package com.natamus.fishontheline.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.fishontheline.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean mustHoldBellInOffhand = true;

	public static void initConfig() {
		configMetaData.put("mustHoldBellInOffhand", Arrays.asList(
			"If enabled, the fish on the line sound will only go off if a bell is held in the offhand while fishing."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}