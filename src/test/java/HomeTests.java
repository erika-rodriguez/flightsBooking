import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(LoggingListeners.class)
public class HomeTests extends BaseTest{
    //HomePage homePage =
    //HomePage home=new HomePage(driver);
    @Test
    public void isUsdCurrencySelected(){
        WebElement usdOption=home.selectUsdCurrency();
        Assert.assertTrue(usdOption.getText().equals("USD"),"Selection does not match USD");
    }
    @Test
    public void isInrCurrencySelected(){
        WebElement inrOption=home.selectInrCurrency();
        Assert.assertTrue(inrOption.getText().equals("INR"),"Selection does not match INR");
    }
    @Test
    public void isAedCurrencySelected(){
        WebElement aedOption= home.selectAedCurrency();
        Assert.assertTrue(aedOption.isSelected());
    }
    @Test
    public void addAdultsPassengers(){
        String adultsCount=home.selectAdultsPassengers();
        Assert.assertTrue(adultsCount.equals("4 Adult"),"Selection does not match");
    }

    @Test(retryAnalyzer = Retry.class)
    public void selectDepartureAndArrival(){
        home.selectDepartureCity();
        home.selectArrivalCity();
    }

    @Test(description = "AutoSuggestive Dropdown")
    public void resultsMatchSearch(){
        Assert.assertTrue(home.doResultsMatchSearch(home.typeToSelect("aru"),"ar"),"Results do not match");
    }

    @Test(description = "Checkbox")
    public void checkFamilyAndFriendsDiscount(){
        Assert.assertTrue(home.selectFamilyAndFriendsDiscount().isSelected());
    }



}
