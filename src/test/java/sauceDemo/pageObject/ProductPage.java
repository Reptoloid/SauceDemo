package sauceDemo.pageObject;

import framework.BasePage;
import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static framework.Browser.getDriver;
import static framework.Browser.waitForPageLoad;

public class ProductPage extends BasePage {

    private static final List<String> PRODUCT_LIST = getDriver().findElements(By.xpath("//div[@class='inventory_item_name ']"))
            .stream().map(e -> e.getText()).collect(Collectors.toList());

    private static final String ITEM = "//div[@class='inventory_item_name ' and text()='%s']";
    private WebElement productItem;
    public static String productName;
    private static final String PRICE = "//a/div[text()='%s']/../../..//div[@class='inventory_item_price']";
    public static double price;
    private static final String PAGE_LOCATOR = "//span[@class='title' and text()='Products']";
    public ProductPage(){
        super(By.xpath(PAGE_LOCATOR),"'Products' Page");
    }
    public WebElement productSelection() {
        Random random = new Random();
        int i = random.nextInt(1, PRODUCT_LIST.size())-1;
        productName = PRODUCT_LIST.get(i);
        System.out.println(productName);
       return productItem = getDriver().findElement(By.xpath(String.format(ITEM, productName)));
    }

    public double getProductPrice(){
        WebElement  productPrice = getDriver().findElement(By.xpath(String.format(PRICE, productName)));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("$","");
        System.out.println(Double.parseDouble(partPriceText));
        return  price = Double.parseDouble(partPriceText);
    }

    public void clickOnProductItem(){

        productItem.click();
    }
}
