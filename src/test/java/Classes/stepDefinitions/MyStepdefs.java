package Classes.stepDefinitions;

import Classes.PageObjects.AmznPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.FileNotFoundException;


public class MyStepdefs {
    public final Hooks hooks;
     public final AmznPage page;
    public MyStepdefs(Hooks hooks){
        super();
        this.hooks =  hooks;
        this.page = new AmznPage(hooks);
//AmznPage page = new AmznPage(hooks);
    }
    @Given("User login to {string}")
    public void userLoginTo(String arg0) throws FileNotFoundException, InterruptedException {
    page.getsite(arg0);
    }

    @When("User Search {string} in {string}")
    public void userSearchIn(String arg0, String arg1) throws AWTException, InterruptedException {
        page.SearchProduct(arg0,arg1);
    }

    @And("^User validate (.*) in the Result$")
    public void userValidateSamsungGalaxySInTheResult(String Product) {
       String a= page.findElementUsingPartialText(Product).getText();
        System.out.println(a);
    }

    @Then("^User validate (.*) as (.*) Jan$")
    public void userValidateFREEDeliveryAsFryJan(String arg0,String arg1) {
        String a= page.findElementUsingPartialText(arg0).getText();
        System.out.println(a);
        String b= page.findElementUsingPartialText(arg1).getText();
        System.out.println(b);
    }

    @And("^User validate date ([0-9]{2}\\/[0,9]{2}\\/[0,9]{4}) and time ([0-9]{2}:[0-9]{2}\\s+(AM|PM))$")
    public void userValidateDateAndTimePM(String date,String time) {

    }
}
