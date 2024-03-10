package com.internal.base;

import java.util.*;

public class GlobalValues {
	
	public static Properties envConfig;
	public static Properties getEnvConfig() {
		return envConfig;
	}
	public static void setEnvConfig(Properties envConfig) {
		GlobalValues.envConfig = envConfig;
	}
	public Map<String, Object> dataBuffer = new HashMap<>();

}
