package com.util;

import java.util.UUID;

public class GuidGeneratorUtil {

	public static String generateGuid() {
		return UUID.randomUUID().toString().toUpperCase();
	}

}
