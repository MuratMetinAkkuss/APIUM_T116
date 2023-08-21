package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencyPage {

    public AllCurrencyPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='TRENDS & CHARTS']")
    public WebElement trendsCharts;
    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement result;
}
