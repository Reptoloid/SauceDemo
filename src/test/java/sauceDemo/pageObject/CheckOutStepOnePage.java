package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class CheckOutStepOnePage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='checkout_info']";
    private static final TextBox FRIST_NAME = new TextBox(By.xpath("//input[@id='first-name']"));

    private static final TextBox LAST_NAME = new TextBox(By.xpath("//input[@id='last-name']"));
    private static final TextBox ZIPCODE = new TextBox(By.xpath("//input[@id='postal-code']"));

    private static final Button continueButton = new Button(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']"));

    public CheckOutStepOnePage() {
        super(By.xpath(PAGE_LOCATOR),"Checkout info");
    }

    public void fillCheckoutInfoPage(String firstname, String lastname, String zipcode){
        FRIST_NAME.sendKeys(firstname);
        LAST_NAME.sendKeys(lastname);
        ZIPCODE.sendKeys(zipcode);
        continueButton.click();
    }

}
