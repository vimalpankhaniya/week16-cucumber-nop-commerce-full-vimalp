package com.nocommerce.demo.pages;
import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(MyAccountPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickOnMyAccountLink() {
        log.info("Click on my account link " + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }


}
