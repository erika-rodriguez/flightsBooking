import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    //protected HomePage home;


    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //home=new HomePage(driver);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
