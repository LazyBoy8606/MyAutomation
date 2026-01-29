package Classes.PageObjects;

import Classes.stepDefinitions.Hooks;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class AmznPage extends BasicPageObj{

    public AmznPage(Hooks hooks) {
        super(hooks);

    }

    @FindBy (className = "lNPl8b")
    public WebElement FlipKartSerchBox;

    @FindBy (id = "twotabsearchtextbox")
    public WebElement AmazoneSerchBox;


public void getsite(String arg0) throws FileNotFoundException, InterruptedException {
    FileInputStream path = new FileInputStream("src/test/resources/TestFiles/Application.yaml");
        Yaml yaml = new Yaml();
        Map<String,Map<String,String>> AppPath = yaml.load(path);
    Map<String,String> Application = AppPath.get("Application");
        String url= Application.get(arg0);
        System.out.println(url);
    driver.get(url);

}
public void SearchProduct(String product, String Application) throws AWTException, InterruptedException {
if(Application.equals("FlipKart")){
    LongWaitForElementToLoad(FlipKartSerchBox);
    FlipKartSerchBox.sendKeys(product);
    }
else if (Application.equals("Amazon")) {
    SmallWaitForElementToLoad(AmazoneSerchBox);
    AmazoneSerchBox.sendKeys(product);

    }
    Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(3000);
}

}
