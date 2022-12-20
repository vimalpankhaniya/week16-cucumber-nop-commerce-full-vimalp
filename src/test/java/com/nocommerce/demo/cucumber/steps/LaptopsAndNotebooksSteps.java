package com.nocommerce.demo.cucumber.steps;
import com.nocommerce.demo.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Map;

public class LaptopsAndNotebooksSteps {
    @When("^I mouse hover to LaptopsAndNotebooks tab and click$")
    public void iMouseHoverToLaptopsAndNotebooksTabAndClick() {
        new HomePage().mouseHoverToLaptopsNotebooksAndClick();
    }

    @Then("^Verify product are arranged in high to low order$")
    public void verifyProductAreArrangedInHighToLowOrder() {
        Map<String, ArrayList> mapArrays = new LaptopsAndNotebooksPage().arrangeProductHighToLowOrder();
        Assert.assertEquals(mapArrays.get("originalProductsPrice"), mapArrays.get("afterSortByPrice"));
    }

    @And("^I and selecting Price \\(High > Low\\) from Sort By dropdown$")
    public void iAndSelectingPriceHighLowFromSortByDropdown() {
        new LaptopsAndNotebooksPage().productSortBy();
    }
    @And("^I click on MacBook Link$")
    public void iClickOnMacBookLink() {
        new LaptopsAndNotebooksPage().clickOnMacBookLink();
    }

    @And("^Verify “MacBook” text$")
    public void verifyMacBookText() {
        Assert.assertEquals(new MacBookPage().macBookErrorMessage(), "MacBook", "MacBook Product not display");
    }

    @And("^I click on Shopping cart link$")
    public void iClickOnShoppingCartLink() {
        new MacBookPage().clickOnShoppingCartButton();
    }

    @And("^Verify Shopping Cart$")
    public void verifyShoppingCart() {
        Assert.assertEquals(new ShoppingCartPage().shoppingCartTextErrorMessage(),"Shopping Cart  (0.00kg)", "Shopping cart is not displayed" );
    }

    @And("^I update product quantity$")
    public void iUpdateProductQuantity() {
        new ShoppingCartPage().updateMacBookQuantity();
    }

    @And("^Verify Total price$")
    public void verifyTotalPrice() {
        Assert.assertEquals(new ShoppingCartPage().macBookTotalErrorMessage(), "£737.45", "Total not matched" );
    }

    @And("^I click on Checkout Button$")
    public void iClickOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckButton();
    }

    @And("^Verify “MacBook” product name$")
    public void verifyMacBookProductName() {
        new ShoppingCartPage().macBookNameErrorMessage();
    }

    @And("^Verify Checkout text$")
    public void verifyCheckoutText() {
        Assert.assertEquals(new CheckOutPage().verifyCheckoutText(),"Checkout","Invalid text displayed");
    }

    @And("^I click on Guest Checkout$")
    public void iClickOnGuestCheckout() {
        new CheckOutPage().clickOnGuestCheckOut();
    }


    @And("^Verify \"([^\"]*)\"$")
    public void verify(String expectedText){
        Assert.assertEquals("Invalid data",expectedText,new CheckOutPage().verifyCustomerText());
    }

    @And("^I enter first name$")
    public void iEnterFirstName() {
        new CheckOutPage().enterFirstName("Champ");
    }

    @And("^I enter last name$")
    public void iEnterLastName() {
        new CheckOutPage().enterLastName("Pankhaniya");
    }

    @And("^I enter email$")
    public void iEnterEmail() {
        new CheckOutPage().enterEmail("ChampPankhaniya@example.com");
    }

    @And("^I enter telephone number$")
    public void iEnterTelephoneNumber() {
        new CheckOutPage().enterTelephone("78681115555");
    }

    @And("^I enter address$")
    public void iEnterAddress() {
        new CheckOutPage().enterAddress("5 Slough Close");
    }

    @And("^I enter city$")
    public void iEnterCity() {
        new CheckOutPage().enterCity("London");
    }

    @And("^I enter postcode$")
    public void iEnterPostcode() {
        new CheckOutPage().enterPostcode("NW9 0PY");
    }

    @And("^I enter country$")
    public void iEnterCountry() {
        new CheckOutPage().entercountry("222");
    }

    @And("^I enter state$")
    public void iEnterState() {
        new CheckOutPage().enterState("3603");
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {

        new CheckOutPage().checkOutContinueButton();
    }

    @And("^I add comments$")
    public void iAddComments() {
        new CheckOutPage().addComments();
    }

    @And("^I click on checkbox$")
    public void iClickOnCheckbox() {
        new CheckOutPage().clickOnCheckBox();
    }

    @And("^I click on checkout continue button$")
    public void iClickOnCheckoutContinueButton() {
        new CheckOutPage().checkOutContinueButton();
    }

}
