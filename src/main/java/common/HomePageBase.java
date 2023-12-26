package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HomePageBase {
    public WebDriver driver;//field
    //constructor
    public HomePageBase(WebDriver driver){
        this.driver=driver;
    }

    public abstract WebElement selectUsdCurrency();
    public abstract WebElement selectInrCurrency();
    public abstract WebElement selectAedCurrency();
    public abstract String selectAdultsPassengers();
}
