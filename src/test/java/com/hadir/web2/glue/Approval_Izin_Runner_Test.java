package com.hadir.web2.glue;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports.html" }, features = {
		"src/main/resources/features/Approval_Izin.feature" })
public class Approval_Izin_Runner_Test {

}
