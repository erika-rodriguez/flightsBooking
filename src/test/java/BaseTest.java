import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
