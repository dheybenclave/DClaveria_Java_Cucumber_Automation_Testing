package com.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

	public Utils() {
	}

	public static String randomString(int count) {
		String retRandName = RandomStringUtils.randomAlphabetic(count);
		return retRandName;
	}
}
