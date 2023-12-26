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

}
