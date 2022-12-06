package com.multifinance.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLoggerUtil {
	private static Logger logger = LogManager.getLogger(CustomLoggerUtil.class);

	public static void logError(Exception e) {
		logger.info(e.getMessage());
	}

}
