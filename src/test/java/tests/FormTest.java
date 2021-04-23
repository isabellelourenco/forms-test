package tests;

import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import suport.Screenshot;
import suport.Web;

@RunWith(DataDrivenTestRunner.class)

public class FormTest {

    private WebDriver driver;

    @Before

    public void setUp(){
        driver = Web.createChrome();
    }

    @Test
    public void successSubmitFormEnglishTest() throws InterruptedException {
        String successMessage = new FormPage(driver)
                .enterName("Isabelle Lourenço")
                .enterDateBirth("20/02/1990")
                .enterTextArea("I choose Software Testing as a carrer because i love facing challenges, and in this " +
                        "area, we dealing with challenges and puzzles all day.")
                .clickSubmitSucess()
                .catchSuccessMessage();
        assertEquals("Information sent successfully!",successMessage);


    }

    @Test
    public void failedSubmitFormEnglishTest() throws InterruptedException {
        String fieldRequiredMessage = new FormPage(driver)
                .enterName("Isabelle Lourenço")
                .enterDateBirth("")
                .enterTextArea("I choose Software Testing as a carrer because i love facing challenges, and in this " +
                        "area, we dealing with challenges and puzzles all day.")
                .clickSubmitFailed()
                .catchFieldRequiredMessage();
        assertEquals("This field is required.",fieldRequiredMessage);


    }

    @Test
    public void successSubmitFormPortugueseTest() throws InterruptedException {
        String successMessage = new FormPage(driver)
                .selectPortugueseLanguage()
                .enterName("Isabelle Lourenço") //configurar arquivo csv depois
                .enterDateBirth("20/02/1990")
                .enterTextArea("I choose Software Testing as a carrer because i love facing challenges, and in this " +
                        "area, we dealing with challenges and puzzles all day.")
                .clickSubmitSucess()
                .catchSuccessMessage();
        assertEquals("Informações enviadas com sucesso!",successMessage);


    }



}
