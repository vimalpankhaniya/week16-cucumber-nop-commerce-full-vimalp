package com.nocommerce.demo.pages;
import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MacBookPage extends Utility {
    private static final Logger log = LogManager.getLogger(MacBookPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement macAddToCart;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    public MacBookPage() {
        PageFactory.initElements(driver, this);
    }
    public String macBookErrorMessage() {
        log.info("Verify Macbook error Message " + macBookText.toString());
        return getTextFromElement(macBookText);
    }

    public void macBookAddToCart() {
        log.info("mac book add to cart" + macAddToCart.toString());
        clickOnElement(macAddToCart);

    }

    public void clickOnShoppingCartButton() {
        log.info("Click on shopping cart button" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

}
