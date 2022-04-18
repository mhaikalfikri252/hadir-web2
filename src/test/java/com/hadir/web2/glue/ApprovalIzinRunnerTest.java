package com.hadir.web2.glue;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports-approvalizin.html" }, features = {
		"src/main/resources/features/ApprovalIzin.feature" })
public class ApprovalIzinRunnerTest {

}
