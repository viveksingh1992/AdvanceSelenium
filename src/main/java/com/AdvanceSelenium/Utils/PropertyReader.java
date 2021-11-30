package com.AdvanceSelenium.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private static volatile PropertyReader propInstance;

	private PropertyReader() {

	}

	public static synchronized PropertyReader getInstance() {
		if (propInstance == null) {
			propInstance = new PropertyReader();
		}

		return propInstance;
	}

	public String getProperty(String propertyName) {
		Properties prop = new Properties();
		@SuppressWarnings("static-access")
		InputStream is = getClass().getClassLoader().getSystemResourceAsStream("application.properties");

		try {
			prop.load(is);
			if (prop.getProperty(propertyName) != null) {
				return prop.getProperty(propertyName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
