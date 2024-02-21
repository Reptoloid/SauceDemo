package sauceDemo.tests;

import framework.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import sauceDemo.pageObject.*;


public class LoginTest extends BaseTest {

    @Test
    @Description("test desc")
    public void loginWithCorrectUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        ProductPage productPage = new ProductPage();
        productPage.productSelection();
        productPage.getProductPrice();
        productPage.clickOnProductItem();

        SingleProductPage singleProductPage = new SingleProductPage();
        singleProductPage.priceValidation();
        singleProductPage.itemValidation();
        singleProductPage.clickOnAddToCart();


        BasketPage basketPage = new BasketPage();
        basketPage.openBasketPage();
        basketPage.basketCheck();
        basketPage.clickCheckout();

        CheckOutStepOnePage checkoutStepOne = new CheckOutStepOnePage();
        checkoutStepOne.fillCheckoutInfoPage("Danik","Pravilo", "11111");

        CheckOutStepTwoPage checkOutStepTwo = new CheckOutStepTwoPage();
        checkOutStepTwo.priceValidation();
        checkOutStepTwo.checkTotalCount();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        checkoutCompletePage.returnBack();

    }
}