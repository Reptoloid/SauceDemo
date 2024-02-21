package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static framework.Browser.*;

@Listeners(TestListener.class)
public class BaseTest {


    @BeforeMethod
    public void setUp() {
        getInstance();
        windowsMaximize();
        navigateTo(PropertyReader.getProperty("base.URL"));
    }

    @AfterMethod(alwaysRun = true, description = "Closing browser")
    public void tearDown() {
        quite();
    }
}
