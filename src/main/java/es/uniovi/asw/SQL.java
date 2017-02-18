package es.uniovi.asw;

import java.io.IOException;
import java.util.Properties;

public class SQL {

private static final String FILE = "sql.properties";
	
	private static SQL instance;
	private Properties properties;

	private SQL(){
		properties = new Properties();
		try {
			properties.load(SQL.class.getClassLoader().getResourceAsStream(FILE));
		} catch (IOException e) {
			throw new RuntimeException("Propeties file can not be loaded", e);
		}
	}
	
	/**
	 * looks for the query or DB configuration associated whose name is passed as parameter.
	 * @param key name of the query / DB configuration (like URL, user, pass)
	 * @return the query / DB configuration
	 */
	public static String get(String key) {
		return getInstance().getProperty( key );
	}

	private String getProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found in config file");
		}
		return value;
	}

	private static SQL getInstance() {
		if (instance == null) {
			instance = new SQL();
		}
		return instance;
	}
}
