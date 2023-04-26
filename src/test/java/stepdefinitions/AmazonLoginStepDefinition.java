package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonLoginStepDefinition {
    AmazonPage amazonpage= new AmazonPage();
    public static String pagePrice;

    @Given("User navigate to the amazon homepage")
    public void user_navigate_to_the_amazon_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("AmazonURL"));


    }
    @When("User click sign in button")
    public void user_click_sign_in_button() {
        amazonpage.signInAndAccountButton.click();

    }
    @Then("User enter valid email {string}")
    public void user_enter_valid_email(String string) {
        amazonpage.emailTextBox.sendKeys(string+ Keys.ENTER);


    }
    @Then("User enter invalid email {string}")
    public void user_enter_invalid_email(String string) {
        amazonpage.emailTextBox.sendKeys(string + Keys.ENTER);


    }

    @And("User enter valid password {string}")
    public void user_enter_valid_password(String string) {
        amazonpage.passwordTextBox.sendKeys(string +Keys.ENTER);

    }
    @And("User enter invalid password {string}")
    public void user_enter_invalid_password(String string) {
        amazonpage.passwordTextBox.sendKeys(string +Keys.ENTER);

    }
    @Then("Verify successful login")
    public void verify_successful_login() {
        String accountName="Miracle";
        Assert.assertTrue(amazonpage.signInAndAccountButton.getText().contains(accountName));


    }

    @Then("Verify unsuccessful login")
    public void verify_unsuccessful_login() throws InterruptedException {
        Thread.sleep(2000);
        String alert="There was a problem";
        Assert.assertTrue(amazonpage.allertMessage.getText().contains(alert));

    }
    @Given("User search desk")
    public void user_search_desk() {
        amazonpage.searchBox.sendKeys("desk"+Keys.ENTER);
        System.out.println("deneme");
    }



    @When("User click eighteenth product")
    public void user_click_eighteenth_product() throws InterruptedException {
         JavascriptExecutor jse=(JavascriptExecutor)Driver.getDriver();
         jse.executeScript("arguments[0].scrollIntoView(true);", amazonpage.computerdesk);
         jse.executeScript("arguments[0].click()", amazonpage.computerdesk);
         Thread.sleep(2000);
       pagePrice=amazonpage.pagePrice.getText().replace("$","");
    }

    @Then("Add to cart to product")
    public void add_to_cart_to_product() {
        amazonpage.addToCartButton.click();

    }

    @Then("Verify the page price and cart price is same")
    public void verify_the_page_price_and_cart_price_is_same() throws InterruptedException {

        String cartPrice=amazonpage.cartPrice.getText();

        Assert.assertTrue(cartPrice.contains(pagePrice));

    }


}
