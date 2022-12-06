package com.multifinance.util;

import java.util.List;

public class CheckUtil {
	public static boolean isNotNull(Object object) {
		if (object != null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNull(Object object) {
		if (object != null) {
			return false;
		} else {
			return true;
		}
	}

	public static <T> boolean isListNotEmpty(List<T> object) {
		if (object.size() != 0) {
			return true;
		} else {
			return false;
		}
	}
}