package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    public abstract void selectDepartureCity();
    public abstract void selectArrivalCity();
    public abstract List<WebElement> typeToSelect(String search);
    public abstract boolean doResultsMatchSearch(List<WebElement> results,String search);
    public abstract WebElement selectFamilyAndFriendsDiscount();
    public abstract void selectRoundTripOption();
    public abstract void selectDepartureDate();
    public abstract void selectReturnDate();
}
