package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='checkout_complete_container']";
    private static final Button backHomeButton = new Button(By.xpath("//button[@class='btn btn_primary btn_small']"));
    public CheckoutCompletePage() {
        super(By.xpath(PAGE_LOCATOR),"Complete checkout");
    }

    public void returnBack(){
        backHomeButton.click();
    }
}
