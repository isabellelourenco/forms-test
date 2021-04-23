package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {
    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String catchSuccessMessage(){

        return driver.findElement(By.className("ddm-form-description")).getText();
    }
}
