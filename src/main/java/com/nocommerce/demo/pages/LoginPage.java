package com.nocommerce.demo.pages;

import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailId;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordfield;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginText;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyReturningCustomer() {
        log.info("Verifying returning customer: " + returningCustomerText.toString());
        return getTextFromElement(returningCustomerText);
    }

    public void enterEmailId(String email) {
        log.info("Enter email " + email + " to email field " + emailId.toString());
        sendTextToElement(emailId, email);
    }

    public void enterPassword(String password) {
        log.info("Enter password " + password + " to email field " + passwordfield.toString());
        sendTextToElement(passwordfield, password);
    }

    public void clickOnLoginButton() {
        log.info("Clicking on login button");
        clickOnElement(loginText);
    }
}
