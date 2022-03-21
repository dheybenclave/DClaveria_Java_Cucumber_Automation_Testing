package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;

	/**
	 * This method is used  to load  the properties from config.properties file
	 * @return 	Properties and Config Object
	 */
	public Properties init() {
		properties = new Properties();
		
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config/config.properties");
			properties.load(fileInputStream);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}
}
