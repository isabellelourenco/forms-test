package tests;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import suport.Web;

public class FormTest {

    private WebDriver driver;

    @Before

    public void setUp(){
        driver = Web.createChrome();
    }

    @Test
    public void successSubmitFormTest() throws InterruptedException {
        String successMessage = new FormPage(driver)
                .enterName("Ana Maria Souza") //configurar arquivo csv depois
                .enterDateBirth("20/02/1990")
                .enterTextArea("Why did you join the testing area")
                .clickSubmit()
                .catchSuccessMessage();
        assertEquals("Information sent successfully!",successMessage);
    }

    @After
    public void tearDown(){
        //driver.quit();
    }


}
