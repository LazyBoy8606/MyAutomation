package Classes.PageObjects;

import Classes.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicPageObj {

    
       protected WebDriver driver ;


    public BasicPageObj(Hooks hooks) {
      this.driver = hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

}


