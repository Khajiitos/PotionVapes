package me.khajiitos.potionvapes.common;

import me.khajiitos.potionvapes.common.config.ServerVapeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PotionVapes {
	public static final String MOD_ID = "potionvapes";
	public static final Logger LOGGER = LoggerFactory.getLogger("Potion Vapes");

	public static void init() {
		ServerVapeConfig.init();
	}
}