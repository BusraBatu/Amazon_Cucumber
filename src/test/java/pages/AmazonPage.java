package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="nav-link-accountList")
    public WebElement signInAndAccountButton;

    @FindBy (id="ap_email")
    public WebElement emailTextBox;

    @FindBy (id="ap_password")
    public WebElement passwordTextBox;

    @FindBy (className="a-alert-heading")
    public WebElement allertMessage;

    @FindBy (id = "searchDropdownBox")
    public WebElement dropdownElement;

    @FindBy (xpath="//span[.='Momo']")
    public WebElement firstProduct;

    @FindBy (xpath="//div[@id='bylineInfo']")
    public WebElement authorInfo;

    @FindBy (xpath="(//i[@class='a-icon a-icon-checkbox'])[2]")
    public WebElement sonyIconButton;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> productList;

    @FindBy (xpath="//span[@class='a-size-base a-color-base']")
    public List<WebElement> leftOptions;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[4]")
    public WebElement thirdLineProduct;

    @FindBy (xpath="(//span[@aria-hidden='true'])[4]")
    public WebElement productPrice;

    @FindBy (xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[18]")
    public WebElement computerdesk;

    @FindBy (xpath="(//span[@aria-hidden='true'])[4]")
    public WebElement pagePrice;

    @FindBy(xpath="//input[@id='add-to-cart-button']")
    public WebElement addToCartButton;

    @FindBy (xpath="//div[@id='sw-subtotal']")
    public WebElement cartPrice;

    @FindBy (id="twotabsearchtextbox")
    public WebElement searchBox;


}
