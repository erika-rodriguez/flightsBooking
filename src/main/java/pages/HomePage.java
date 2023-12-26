package pages;

import common.HomePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends HomePageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private WebElement currencyDropdown= driver.findElement(By.xpath("//select[contains(@name,\"Currency\")]"));

    @Override
    public WebElement selectUsdCurrency(){
        Select staticDropdown =new Select(currencyDropdown);
        staticDropdown.selectByIndex(3);
        return staticDropdown.getFirstSelectedOption();
    }

    @Override
    public WebElement selectInrCurrency() {
        Select  staticDropdown=new Select(currencyDropdown);
        staticDropdown.selectByVisibleText("INR");
        return staticDropdown.getFirstSelectedOption();
    }

    @Override
    public WebElement selectAedCurrency() {
        Select staticDropdown= new Select(currencyDropdown);
        staticDropdown.selectByValue("AED");
        return staticDropdown.getFirstSelectedOption();
    }
}
