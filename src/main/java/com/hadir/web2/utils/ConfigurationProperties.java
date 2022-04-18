package com.hadir.web2.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;

	@Value("${usernamee}")
	private String userName;

	@Value("${password}")
	private String password;

	@Value("${textInvalidLogin}")
	private String textInvalidLogin;

	@Value("${textDashboard}")
	private String textDashboard;
	
	@Value("${textIzin}")
	private String textIzin;

	public String getBrowser() {
		return browser;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public String getTextInvalidLogin() {
		return textInvalidLogin;
	}

	public String getTextDashboard() {
		return textDashboard;
	}

	public String getTextIzin() {
		return textIzin;
	}
	
	

}
