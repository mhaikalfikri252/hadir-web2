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

	@Value("${textApprovalIzin}")
	private String textApprovalIzin;

	@Value("${textShowEntries}")
	private String textShowEntries;

	@Value("${textShowEntriesReport}")
	private String textShowEntriesReport;

	@Value("${textSuccessAdd}")
	private String textSuccessAdd;

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

	public String getTextApprovalIzin() {
		return textApprovalIzin;
	}

	public String getTextShowEntries() {
		return textShowEntries;
	}

	public String getTextShowEntriesReport() {
		return textShowEntriesReport;
	}

	public String getTextSuccessAdd() {
		return textSuccessAdd;
	}

}
