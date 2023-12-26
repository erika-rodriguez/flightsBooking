package common;

import org.openqa.selenium.WebDriver;

public abstract class HomePageBase {
    public WebDriver driver;//field
    //constructor
    public HomePageBase(WebDriver driver){
        this.driver=driver;
    }
}
