package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage extends BasePage {
    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String catchSuccessMessage(){

        return driver.findElement(By.id("ToastAlertContainer")).getText();

    }
}
