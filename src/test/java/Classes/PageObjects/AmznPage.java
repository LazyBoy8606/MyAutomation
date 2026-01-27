package Classes.PageObjects;

import Classes.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmznPage extends BasicPageObj{
//    private static final WebDriver hooks = ;

    public AmznPage(Hooks hooks) {
        super(hooks);

    }
public void getsite(String arg0){
        driver.get(arg0);
}
}
