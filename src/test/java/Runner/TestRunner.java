package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions (
  features="src/test/resources/Features",
  glue = {"Classes.stepDefinitions"},
  plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json",
          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@OrderPlacing",
  monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
@Override
@DataProvider(parallel = false)
public Object[][] scenarios(){
    return super.scenarios();
}
}
