package tacs;

import org.springframework.web.client.RestTemplate;

import apiResult.Configuration;

public class ConfigHolder {
	
	private static ConfigHolder instance;
	private static RestTemplate api = new RestTemplate();
	private static Configuration conf;
	
	public static ConfigHolder getInstance() {
		if (instance == null) {
			instance = new ConfigHolder();
		}
		
		return instance;
	}
	
	public ConfigHolder() {
		conf = api.getForObject("https://api.themoviedb.org/3/configuration?api_key=3eb489d424860bc6870dc6776d05f6b9", Configuration.class);
	}
	
	public Configuration getConfig() {
		return conf;
	}

}
