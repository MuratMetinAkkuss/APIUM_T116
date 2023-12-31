package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Reusablemethods;


public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirOlarakDevamEt;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement fromTextBox;

    @FindBy(xpath = "(//*[@class='android.view.View'])[8]")
    public WebElement fromBoxIlkSecenek;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButton;

    @FindBy(xpath = "//*[@text='Search']")
    public WebElement aramaButonu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement fiyatSonucu;





    public void ilkSayfaGecisleri() {
        for (int i=0; i<3; i++){
            Reusablemethods.clickCoordinate(538,1689,2000);
        }
    }
}
