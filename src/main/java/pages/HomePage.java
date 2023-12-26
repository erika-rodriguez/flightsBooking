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
    private WebElement passengersDropdown=driver.findElement(By.cssSelector("div #divpaxinfo"));
    private WebElement addAdultBtn=driver.findElement(By.id("hrefIncAdt"));
    private WebElement doneBtn=driver.findElement(By.id("btnclosepaxoption"));

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

    @Override
    public String selectAdultsPassengers() {
        passengersDropdown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < 4; i++) {
            addAdultBtn.click();
        }
        doneBtn.click();
        return passengersDropdown.getText();
    }
}
