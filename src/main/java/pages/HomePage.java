package pages;

import common.HomePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends HomePageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private WebElement currencyDropdown= driver.findElement(By.xpath("//select[contains(@name,\"Currency\")]"));
    private WebElement passengersDropdown=driver.findElement(By.cssSelector("div #divpaxinfo"));
    private WebElement addAdultBtn=driver.findElement(By.id("hrefIncAdt"));
    private WebElement doneBtn=driver.findElement(By.id("btnclosepaxoption"));
    private WebElement fromDropdown=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));
    private WebElement toDropdown=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']"));
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
    @Override
    public void selectDepartureCity() {
        fromDropdown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement delhiOption= driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']/descendant::div[@class='dropdownDiv']/ul/li/a[text()=' Delhi (DEL)']"));
        delhiOption.click();
    }
    @Override
    public void selectArrivalCity() {
        toDropdown.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dubaiOption= driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']/descendant::div[@class='dropdownDiv']/ul/li/a[text()=' Dubai, All Airports(DWC) (DXB)']"));
        dubaiOption.click();
    }
    @Override
    public List<WebElement> typeToSelect(String search) {
        WebElement searchInput=driver.findElement(By.xpath("//input[@id='autosuggest']"));
        searchInput.click();
        searchInput.sendKeys(search);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> results=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        return results;
    }
    @Override
    public boolean doResultsMatchSearch(List<WebElement> results,String match) {
        for (WebElement e:results) {
            System.out.println(e.getText());
            if (e.getText().toLowerCase().contains(match)){
                return true;
            }
        }
        return false;
    }


}
