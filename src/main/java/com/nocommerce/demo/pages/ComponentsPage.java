package com.nocommerce.demo.pages;

import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPage extends Utility {
    private static final Logger log = LogManager.getLogger(ComponentsPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsTest;

    public ComponentsPage() {
        PageFactory.initElements(driver, this);
    }

    public String navigateToComponentsErrorMessage() {
        log.info("verify navigate to components error message" + componentsTest.toString());
        return getTextFromElement(componentsTest);
    }

}
