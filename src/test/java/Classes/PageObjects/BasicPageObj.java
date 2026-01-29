package Classes.PageObjects;

import Classes.stepDefinitions.Hooks;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasicPageObj {

    
       protected WebDriver driver ;


    public BasicPageObj(Hooks hooks) {
      this.driver = hooks.getDriver();
        PageFactory.initElements(driver, this);
    }


    WebDriverWait Smallwait = new WebDriverWait(this.driver,Duration.ofSeconds(5));
    WebDriverWait Longwait = new WebDriverWait(this.driver,Duration.ofSeconds(15));


    public WebElement findElementUsingPartialText(String arg0){
        WebElement r= this.driver.findElement(By.xpath("//*[contains(text(),'"+arg0+"')]"));
        return r;

    }

    public void SmallWaitForElementToLoad(WebElement Element){
        Smallwait.until(ExpectedConditions.visibilityOf(Element));
    }
    public void LongWaitForElementToLoad(WebElement Element){
        Longwait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void SmallWaitForElementToBeClickable(WebElement Element){
        Smallwait.until(ExpectedConditions.elementToBeSelected(Element));
    }
    public void LongWaitForElementToBeClickable(WebElement Element){
        Longwait.until(ExpectedConditions.elementToBeSelected(Element));
    }

    public String takeScreenShot(String fileName){
        try{
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
            File src= ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
            String path= System.getProperty("user.dir") + "/Reports/SparkReport/Screenshots/"+fileName+""+timestamp+".png";
            FileUtils.copyFile(src, new File(path));
            return path;
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }

    public void AttachScreeshot(String fileName){
        String SSpath= takeScreenShot(fileName);
        if(SSpath != null){
            ExtentCucumberAdapter.getCurrentStep().addScreenCaptureFromPath(SSpath);

        }
    }
    public byte[] getScreenshotBytes(){
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

}


