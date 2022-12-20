package com.nocommerce.demo.pages;

import com.nocommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
public class DesktopPage extends Utility {
    private static final Logger log = LogManager.getLogger(DesktopPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByAToZ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hpProduct;

    public DesktopPage() {
        PageFactory.initElements(driver, this);
    }

    public String navigateToDesktopErrorMessage() {
        log.info("Navigate to desktop error message");
        return getTextFromElement(desktopText);

    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        log.info("Arrange products in descending order");
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);

        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;
    }

    public void sortByName() {
        log.info("Selecting text from drop down");
        selectByVisibleTextFromDropDown(sortByAToZ, "Name (A - Z)");
    }

    public void clickOnHpProduct() {
        log.info("Cliking on HP product");
        clickOnElement(hpProduct);
    }
}