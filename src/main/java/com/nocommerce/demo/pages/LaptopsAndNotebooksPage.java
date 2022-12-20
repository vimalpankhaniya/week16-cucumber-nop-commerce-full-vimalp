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



public class LaptopsAndNotebooksPage extends Utility {
    private static final Logger log = LogManager.getLogger(LaptopsAndNotebooksPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsNotebookLink;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPrice;
    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macBookLink;


    public LaptopsAndNotebooksPage() {
        PageFactory.initElements(driver, this);
    }
    public String navigateToLaptopsNotebooksErrorMessage() {
        log.info("Navigating to laptops and notebooks error message: " + laptopsNotebookLink.toString());
        return getTextFromElement(laptopsNotebookLink);

    }

    public void productSortBy() {
        log.info("Select price from drop down");
        selectByVisibleTextFromDropDown(sortByPrice, "Price (High > Low)");
    }

    public void clickOnMacBookLink() {
        log.info("Clicking pn MacBook Menu");
        clickOnElement(macBookLink);
    }

    public Map<String, ArrayList> arrangeProductHighToLowOrder() {
        log.info("Arranging product in high to low order: ");
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        // Get all the products price and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }

        mapArrays.put("originalProductsPrice", (ArrayList) originalProductsPrice);
        mapArrays.put("afterSortByPrice", afterSortByPrice);
        return mapArrays;
    }

}

