package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static framework.Browser.getDriver;

public class CheckOutStepTwoPage extends BasePage {
    private static final String PAGE_LOCATOR = "//div[@id='contents_wrapper']";
    private static final String PRICE = "//div[@class='inventory_item_price']";
    private static final String PRICE1 = "//div[@class='summary_subtotal_label']";
    private static final String TAX = "//div[@class='summary_tax_label']";
    private static final String TOTAL_COUNT = "//div[@class='summary_info_label summary_total_label']";

    private static final Button finishButton = new Button(By.xpath("//button[@class='btn btn_action btn_medium cart_button']"));

    public static double price;

    public CheckOutStepTwoPage() {
        super(By.xpath(PAGE_LOCATOR), "Checkout Step Two");
    }

    public double priceValidationOnCheckoutStepTwo() {
        WebElement productPrice = getDriver().findElement(By.xpath(PRICE));
        String textPrice = productPrice.getText();
        String partPriceText = textPrice.replace("$", "");
        System.out.println(Double.parseDouble(partPriceText));
        return price = Double.parseDouble(partPriceText);
    }

    public double priceValidationOnCheckoutStepTwo1() {
        WebElement productPrice1 = getDriver().findElement(By.xpath(PRICE1));
        String textPrice1 = productPrice1.getText();
        String partPriceText1 = textPrice1.replace("Item total: $", "");
        System.out.println(Double.parseDouble(partPriceText1));
        return price = Double.parseDouble(partPriceText1);
    }

    public void priceValidation() {
        if (priceValidationOnCheckoutStepTwo() == priceValidationOnCheckoutStepTwo1()) {
            System.out.println("Price are equal");
        } else {
            System.out.println("Price aren't equal");
        }
    }

    public double priceTax() {
        WebElement productTax = getDriver().findElement(By.xpath(TAX));
        String textTAX = productTax.getText();
        String partTAXText = textTAX.replace("Tax: $", "");
        System.out.println(Double.parseDouble(partTAXText));
        return price = Double.parseDouble(partTAXText);
    }
    public double priceTotal() {
        WebElement productTotal = getDriver().findElement(By.xpath(TOTAL_COUNT));
        String textTotal = productTotal.getText();
        String partTotalText = textTotal.replace("Total: $", "");
        System.out.println(Double.parseDouble(partTotalText));
        return price = Double.parseDouble(partTotalText);
    }


    public void checkTotalCount() {
    double total = priceTax() + priceValidationOnCheckoutStepTwo();
    if(priceTotal() == total){
        System.out.println("Total count is correct");
        finishButton.click();
    }else {
        System.out.println("Total count isn't correct");
    }
    }



}
