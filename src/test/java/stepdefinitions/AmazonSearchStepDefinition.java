package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchStepDefinition {
    AmazonPage amazonpage=new AmazonPage();

    @Given("User select books and search Momo")
    public void user_select_books_and_search_momo() {
        Select select = new Select(amazonpage.dropdownElement);
        select.selectByVisibleText("Books");
        amazonpage.searchBox.sendKeys("Momo"+ Keys.ENTER);

    }

    @When("Select first product")
    public void select_first_product() throws InterruptedException {
        Thread.sleep(2000);
        amazonpage.firstProduct.click();

    }

    @And("Verify author is {string}")
    public void verify_author_is(String string) {
      Assert.assertTrue(amazonpage.authorInfo.getText().contains(string));

    }

    @Given("User search headphones")
    public void user_search_headphones() {
        amazonpage.searchBox.sendKeys("headphones"+Keys.ENTER);

    }
    @Then("User select brand is {string}")
    public void user_select_brand_is(String string) {
    amazonpage.sonyIconButton.click();

    }
    @And("Verify products contain a product name {string}")
    public void verify_products_contain_a_product_name(String string) {
    List<WebElement> products= new ArrayList<>();
    products=amazonpage.productList;
    Assert.assertTrue(products.contains(string));
    }

    @Given("User search bicycle")
    public void user_search_bicycle() {
        amazonpage.searchBox.sendKeys("bicycle"+Keys.ENTER);

    }
    @Then("User select price ${string} to ${string}")
    public void user_select_price_$_to_$(String string, String string2) {
        Actions action= new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        for(int i=0; i<amazonpage.leftOptions.size(); i++){
            if((amazonpage.leftOptions.get(i).getText()).contains("$100 to $200")){
                amazonpage.leftOptions.get(i).click();
            }
        }

    }
    @Then("User click third line product from the results")
    public void user_click_third_line_product_from_the_results() {
        amazonpage.thirdLineProduct.click();

    }
    @Then("Verify product is bicycle and price is in the range {string} to {string}")
    public void verify_product_is_bicycle_and_price_is_in_the_range_to_(String string, String string2) {
        String price=amazonpage.productPrice.getText();
        price= price.replace("$","");

        Assert.assertTrue(Double.parseDouble(price)<Double.parseDouble(string2)
                &Double.parseDouble(price)>Double.parseDouble(string));

    }
}
