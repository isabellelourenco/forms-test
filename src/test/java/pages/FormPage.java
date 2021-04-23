package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage extends BasePage{

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage enterName(String name) throws InterruptedException {
        WebElement inputName = driver.findElement(By.xpath("//label[text()=\"What is your " +
                "name?\"]/following-sibling::input"));
        inputName.sendKeys(name);

        Thread.sleep(1000);

        inputName.sendKeys(Keys.chord(Keys.TAB));

        return this;
    }

    public FormPage enterDateBirth(String date) throws InterruptedException {
        WebElement inputDate = driver.findElement(By.className("input-group-inset-after"));
        inputDate.sendKeys(date);

        Thread.sleep(1000);

        inputDate.sendKeys(Keys.chord(Keys.TAB));

        return this;
    }

    public FormPage enterTextArea(String text) throws InterruptedException {
        WebElement inputText = driver.findElement(By.xpath("//label[text()=\"Why did you join the testing " +
                "area?\"]/following-sibling::textarea"));
        inputText.sendKeys(text);

        Thread.sleep(1000);

        return this;
    }

    public SuccessPage clickSubmit() throws InterruptedException {
        driver.findElement(By.className("lfr-ddm-form-submit")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains("Form - Forms"));

        return new SuccessPage(driver);
    }



}
