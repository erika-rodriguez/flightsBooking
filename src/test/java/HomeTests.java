import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest{
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

    @Test
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
