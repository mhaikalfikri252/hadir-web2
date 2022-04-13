package com.hadir.web2.utils;

public enum TestCases {

	T1("Testing Login User"), T2("Testing ??"), T3("Testing ??");

	private String testName;

	TestCases(String value) {
		this.testName = value;
	}

	public String getTestName() {
		return testName;
	}
}
