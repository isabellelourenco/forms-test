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

    public FormPage selectPortugueseLanguage() throws InterruptedException {
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.className("lfr-icon-item")).click();

        Thread.sleep(1000);


        return this;
    }

    public FormPage enterName(String name) throws InterruptedException {
        WebElement inputName = driver.findElement(By.cssSelector("input[class='form-control ddm-field-text']"));
        inputName.sendKeys(name);

        Thread.sleep(1000);

        inputName.sendKeys(Keys.TAB);

        return this;
    }

    public FormPage enterDateBirth(String date) throws InterruptedException {

        WebElement inputDate = driver.findElement(By.className("input-group-inset-after"));
        inputDate.sendKeys(Keys.CONTROL,"a");
        inputDate.sendKeys(Keys.DELETE);
        inputDate.sendKeys(date);

        Thread.sleep(1000);

        return this;
    }

    public FormPage enterTextArea(String text) throws InterruptedException {
        WebElement inputText = driver.findElement(By.cssSelector("textarea[class='ddm-field-text form-control']"));
        inputText.sendKeys(text);

        Thread.sleep(1000);

        return this;
    }

    public SuccessPage clickSubmitSucess() throws InterruptedException {
        driver.findElement(By.className("lfr-ddm-form-submit")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains("Form - Forms"));

        return new SuccessPage(driver);

    }

    public FormPage clickSubmitFailed(){
        driver.findElement(By.className("lfr-ddm-form-submit")).click();
        return this;
    }

    public String catchFieldRequiredMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.className("form-feedback-group"))));

        return driver.findElement(By.className("form-feedback-group")).getText();
    }



}
