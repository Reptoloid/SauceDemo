package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;

public class BasketPage extends BasePage {
    private static final String PAGE_LOCATOR = "//a[@class='shopping_cart_link']";
    private static final Button checkout = new Button(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
    private static final TextBox item = new TextBox(By.xpath("//div[@class='inventory_item_name']"));
    public static final Button basket = new Button(By.xpath( "//a[@class='shopping_cart_link']"));


    public  BasketPage() {
        super(By.xpath(PAGE_LOCATOR),"Basket page");
    }
    public void openBasketPage(){
        basket.click();
    }

    public void basketCheck(){
        try {
            if(item.isDisplayed()){
                System.out.println("Basket has item/s");
            }
        }catch (Exception e){
            System.out.println("Basket is empty");
        }
    }

    public void clickCheckout(){
        checkout.click();
    }


}
