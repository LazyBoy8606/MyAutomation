package Classes.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class Hooks {

    public static ThreadLocal<WebDriver> driverThreadLocal= new ThreadLocal<>();

    @Before
    public  void setup() throws FileNotFoundException {
        FileInputStream settingspath = new FileInputStream("src/test/resources/TestFiles/Settings.yaml");
        Yaml yaml = new Yaml();
        Map<String,String> settingsData = yaml.load(settingspath);
        String Browser = settingsData.get("Browser");
        String ChromeWindow = settingsData.get("Window");
if(Browser.equals("Chrome")&&ChromeWindow.equals("Incognito")){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");   // optional
        options.addArguments("--disable-notifications");
        driverThreadLocal.set(new ChromeDriver(options));
        WebDriver driver = (WebDriver) driverThreadLocal.get();
            driver.manage().window().maximize();
    }
    if(Browser.equals("Chrome")&&!ChromeWindow.equals("Incognito")){
        driverThreadLocal.set(new ChromeDriver());
        WebDriver driver = (WebDriver) driverThreadLocal.get();
        driver.manage().window().maximize();
    }
    else if(Browser.equals("Edge")){
    driverThreadLocal.set(new EdgeDriver());
    WebDriver driver = (WebDriver) driverThreadLocal.get();
    driver.manage().window().maximize();
    }
    }

    public static WebDriver getDriver(){
        return (WebDriver) driverThreadLocal.get();
    }

    @After
    public void teardown(Scenario scenario){
        WebDriver driver = (WebDriver)driverThreadLocal.get();
        try{
            if(scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed_Step_Screenshot");
                System.out.println("Screenshot Captured for FAILED Scenario!");
            }
        } catch (Exception e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }

        if (driver != null) {
            System.out.println("Closing browser...");
            driver.quit();
        }
            }
        }


