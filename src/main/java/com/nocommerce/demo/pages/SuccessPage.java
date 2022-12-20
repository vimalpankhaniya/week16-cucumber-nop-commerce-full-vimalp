package com.nocommerce.demo.pages;

import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends Utility {
    private static final Logger log = LogManager.getLogger(SuccessPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement yourAccountText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement successContinue;

    public SuccessPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyYourAccountMessage() {
        log.info("Verify your Account Message" + yourAccountText.toString());
        return getTextFromElement(yourAccountText);
    }

    public void clickOnSuccessContinueButton() {
        log.info("Click on success continue button " + successContinue.toString());
        clickOnElement(successContinue);
    }
}
