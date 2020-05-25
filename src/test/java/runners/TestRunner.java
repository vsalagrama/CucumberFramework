package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Dryrun/blazedemo.feature", glue = { "stepDefinitions" }, 

plugin = {
		 "json:target/cucumber.json"}, monochrome = true, strict = true)



//"html:target/site/cucumber-pretty"

public class TestRunner {



}