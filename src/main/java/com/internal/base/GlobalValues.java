package com.internal.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GlobalValues {
	
	public GlobalValues() {
	}

	public static Properties envConfig;

	public static Properties getEnvConfig() {
		return envConfig;
	}

	public static void setEnvConfig(Properties envConfig) {
		GlobalValues.envConfig = envConfig;
	}

	public static Map<String, Object> dataBuffer = new HashMap<>();

}
