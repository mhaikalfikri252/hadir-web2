package com.hadir.web2.glue;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports-reimbursement.html" }, features = {
		"src/main/resources/features/Reimbursement.feature" })

public class ReimbursementRunnerTest {

}
