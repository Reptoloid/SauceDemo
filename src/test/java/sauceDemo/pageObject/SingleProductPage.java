package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.*;

public class SingleProductPage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@class='inventory_details_name large_size' and text()='%s']";
    public static final TextBox PRODUCT_ITEM = new TextBox(By.xpath("//div[@class='inventory_details_name large_size']"));
    public static final String PRICE = "//div[@class='inventory_details_price']";
    public static final Button addToCart = new Button(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
    public static double price;

    String productItem;

    public SingleProductPage() {
        super(By.xpath(String.format(PAGE_LOCATOR, ProductPage.productName)), "'Single Product Page'" + ProductPage.productName);
    }

    public String getProductItem() {
        return productItem = PRODUCT_ITEM.getText();
    }

    public double priceValidation() {
        WebElement productPrice = getDriver().findElement(By.xpath(PRICE));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("$", "");
        System.out.println(Double.parseDouble(partPriceText));
        return price = Double.parseDouble(partPriceText);
    }

    public void itemValidation() {
        getProductItem();
        if (productItem.equals(ProductPage.productName) && price == ProductPage.price) {
            System.out.println("P2: " + ProductPage.productName);
            System.out.println("Spp: " + productItem);
            System.out.println("Items are equal");

        } else {
            System.out.println("P2: " + ProductPage.productName);
            System.out.println("Spp: " + productItem);
            System.out.println("Items arent equal");
        }
    }

    public void clickOnAddToCart(){
        addToCart.click();
    }
}

