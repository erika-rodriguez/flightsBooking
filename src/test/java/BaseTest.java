import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage home;


    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        home= PageFactory.initElements(driver, HomePage.class);
        //home=new HomePage(driver);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
