package Classes.stepDefinitions;

import Classes.PageObjects.AmznPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



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
    public void userLoginTo(String arg0) {
    page.getsite(arg0);
    }

    @When("User Search {string}")
    public void userSearch(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
