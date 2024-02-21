package sauceDemo.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    private static final String PAGE_LOCATOR ="//div[@class='login-box']";
    private static final TextBox USERNAME = new TextBox(By.xpath("//input[@id='user-name']"));

    private static final TextBox PASSWORD = new TextBox(By.xpath("//input[@id='password']"));
    private static final Button loginButton = new Button(By.xpath("//input[@id='login-button']"));

    public LoginPage() {
        super(By.xpath(PAGE_LOCATOR), "Login Page");
    }

    public void setUsername(String username){
        USERNAME.sendKeys(username);
    }

    public void setPassword(String password){
        PASSWORD.sendKeys(password);
    }
    @Step("TEst")
    public void clickOnLoginButton(){
        loginButton.click();
    }

}
