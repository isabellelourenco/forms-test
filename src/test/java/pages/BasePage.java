package pages;

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


    public void Screenshot(){
        Screenshot.take(driver,"report" + Generator.DateHourFile() + test.getMethodName() + ".png");
    }
}
