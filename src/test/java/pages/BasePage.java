package pages;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import suport.Generator;
import suport.Screenshot;

import java.awt.geom.GeneralPath;

public class BasePage {

    protected WebDriver driver;

    @Rule
    public TestName test = new TestName();

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    //aqui eu devo fazer uma função que retorne a resposta do assert

    @After

    public void screenshot(){

        Screenshot.take(driver,"src/main/resources/report" + Generator.DateHourFile() + test.getMethodName() + ".png");
    }

    public void tearDown(){
        driver.quit();

    }
}
