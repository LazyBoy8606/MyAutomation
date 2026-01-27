package Classes.stepDefinitions;

import Classes.PageObjects.AmznPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @And("User Add to cart")
    public void userAddToCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("User validate order appeared in Cart")
    public void userValidateOrderAppearedInCart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


}
