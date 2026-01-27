package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
  features="src/test/resources/Features",
  glue = {"Classes.stepDefinitions"},
  plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"},
        tags = "@OrderPlacing",
  monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
