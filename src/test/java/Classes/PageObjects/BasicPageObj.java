package Classes.PageObjects;

import Classes.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasicPageObj {

    
       protected WebDriver driver ;


    public BasicPageObj(Hooks hooks) {
      this.driver = hooks.getDriver();
        PageFactory.initElements(driver, this);
    }
    public WebElement findElementUsingPartialText(String arg0){
        WebElement r= this.driver.findElement(By.xpath("//*[contains(text(),'"+arg0+"')]"));
        return r;

    }

}


