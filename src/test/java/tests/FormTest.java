package tests;

import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.FormPage;
import support.Screenshot;
import support.Web;
import support.Generator;

@RunWith(DataDrivenTestRunner.class)

public class FormTest{

    private WebDriver driver;

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp(){
        driver = Web.createChrome();
    }

    @Test
    public void successSubmitFormEnglishTest() throws InterruptedException {
        String successMessage = new FormPage(driver)
                .enterName("Isabelle Lourenço")
                .enterDateBirth("02/20/1990")
                .enterTextArea("I choose Software Testing as a carrer because i love dealing with challenges, and in this area, we dealing with challenges and puzzles all day.")
                .clickSubmitSucess()
                .catchSuccessMessage();
        assertEquals("Success:Your request completed successfully.",successMessage);


    }

    @Test
    public void failedSubmitFormEnglishTest() throws InterruptedException {
        String fieldRequiredMessage = new FormPage(driver)
                .enterName("Isabelle Lourenço")
                .enterDateBirth("")
                .enterTextArea("I choose Software Testing as a carrer because i love facing challenges, and in this " +
                        "area, we dealing with challenges all day.")
                .clickSubmitFailed()
                .catchFieldRequiredMessage();
        assertEquals("This field is required.",fieldRequiredMessage);


    }

    @Test
    public void successSubmitFormPortugueseTest() throws InterruptedException {
        String successMessage = new FormPage(driver)
                .selectPortugueseLanguage()
                .enterName("Isabelle Lourenço") //configurar arquivo csv depois
                .enterDateBirth("02/20/1990")
                .enterTextArea("Escolhi o Teste de Software como carreira porque adoro lidar com desafios e nesta " +
                        "área, lidamos com desafios o dia todo.")
                .clickSubmitSucess()
                .catchSuccessMessage();
        assertEquals("Informações enviadas com sucesso!",successMessage);


    }

    @Test
    public void failedSubmitFormPortugueseTest() throws InterruptedException {
        String fieldRequiredMessage = new FormPage(driver)
                .selectPortugueseLanguage()
                .enterName("Isabelle Lourenço")
                .enterDateBirth("")
                .enterTextArea("Escolhi o Teste de Software como carreira porque adoro lidar com desafios e nesta área, lidamos com desafios o dia todo.")
                .clickSubmitFailed()
                .catchFieldRequiredMessage();
        assertEquals("Este campo é obrigatório.",fieldRequiredMessage);


    }

    @After
    public void after(){
        screenshot();
        tearDown();
    }
    
    public void screenshot(){
        Screenshot.take(driver,"src\\main\\resources\\report\\" + Generator.DateHourFile() + test.getMethodName() +
                ".png");
    }

    public void tearDown(){
        driver.quit();
    }
}
