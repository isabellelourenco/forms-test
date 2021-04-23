package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome() {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");

        driver.manage().window().maximize();

        return driver;
    }

}
