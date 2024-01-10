package pages;

import common.HomePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends HomePageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//select[contains(@name,\"Currency\")]")
    private WebElement currencyDropdown;
    @FindBy(css = "div #divpaxinfo")
    private WebElement passengersDropdown;
    @FindBy(id = "hrefIncAdt")
    private WebElement addAdultBtn;
    @FindBy(id = "btnclosepaxoption")
    private WebElement doneBtn;
    @FindBy(xpath = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")
    private WebElement fromDropdown;
    @FindBy(xpath ="//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")
    private WebElement toDropdown;
    @FindBy(xpath = "//div[@id='travelOptions']/descendant::input[@value='RoundTrip']")
    private WebElement roundTripOption;
//    @FindBy(xpath = "//a[@class='ui-state-default ui-state-highlight ui-state-active']")
//    private WebElement currentDate;
//    @FindBy(xpath = "(//a[@class='ui-state-default ui-state-highlight ui-state-active']/parent::td/following-sibling::td)[1]")
//    private WebElement returnDate;
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
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(addAdultBtn));
        for (int i = 1; i < 4; i++) {
            addAdultBtn.click();
        }
        doneBtn.click();
        return passengersDropdown.getText();
    }
    @Override
    public void selectDepartureCity() {
        fromDropdown.click();
        WebElement delhiOption= driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']/descendant::div[@class='dropdownDiv']/ul/li/a[text()=' Delhi (DEL)']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(delhiOption));
        delhiOption.click();
    }
    @Override
    public void selectArrivalCity() {
        toDropdown.click();
        WebElement dubaiOption= driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']/descendant::div[@class='dropdownDiv']/ul/li/a[text()=' Dubai, All Airports(DWC) (DXB)']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(dubaiOption));
        dubaiOption.click();
    }
    @Override
    public List<WebElement> typeToSelect(String search) {
        WebElement searchInput=driver.findElement(By.xpath("//input[@id='autosuggest']"));
        searchInput.click();
        searchInput.sendKeys(search);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@id='ui-id-1']"))));
        List<WebElement> results=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        return results;
    }
    @Override
    public boolean doResultsMatchSearch(List<WebElement> results,String match) {
        boolean condition=false;
        for (WebElement e:results) {
            System.out.println(e.getText());
            if (e.getText().toLowerCase().contains(match)){
                condition=true;
            }
        }
        return  condition;
    }
    @Override
    public WebElement selectFamilyAndFriendsDiscount() {
        WebElement familyAndFriendsCheckbox=driver.findElement(By.xpath("//div[@id='discount-checkbox']//input[contains(@id,'friendsandfamily')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(familyAndFriendsCheckbox));
        familyAndFriendsCheckbox.click();
        return familyAndFriendsCheckbox;
    }

    @Override
    public void selectRoundTripOption() {
        roundTripOption.click();
    }

    @Override
    public void selectDepartureDate() {
        driver.findElement(By.xpath("(//div[@class='picker-first2'])[1]")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active']")).click();
    }

    @Override
    public void selectReturnDate() {
//        driver.findElement(By.xpath("//div[@id='Div1']")).click();
//        returnDate.click();
    }


}
