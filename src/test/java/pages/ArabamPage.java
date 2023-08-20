package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class ArabamPage {
    public ArabamPage() {
        PageFactory.initElements( (WebDriver)Driver.getAndroidDriver(),this);
    }
    @FindBy(id = "com.dogan.arabam:id/tvGarageBanner")
    public WebElement garaj;
    @FindBy(id = "com.dogan.arabam:id/textViewSkip")
    public WebElement atla;
    @FindBy(xpath = "//*[@text='Servis / Bakım']")
    public WebElement servisBakim;
    @FindBy(id = "com.dogan.arabam:id/textViewTitle")
    public WebElement periyodikBakim;
    @FindBy(xpath = "//*[@text='Volkswagen']")
    public WebElement volkswagen;
    @FindBy(xpath = "//*[@text='2014']")
    public WebElement arabaYil;
    @FindBy(xpath = "//*[@text='Passat']")
    public WebElement marka;
    @FindBy(xpath = "//*[@text='Sedan']")
    public WebElement kasaTipi;
    @FindBy(xpath = "//*[@text='Benzin']")
    public WebElement yakitTuru;
    @FindBy(xpath = "//*[@text='Düz']")
    public WebElement vitesTuru;
    @FindBy(xpath = "//*[@resource-id='com.dogan.arabam:id/tvAveragePrice']")
    public WebElement avarageMarketPrice;



    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public WebElement version1;
    @FindBy(id = "com.dogan.arabam:id/btnShowService")
    public WebElement servisleriGor;
    @FindBy(id = "com.dogan.arabam:id/btnGarageInfo")
    public WebElement izinVer;
    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement allowOnlyWhileUsingApp;
    @FindBy(id = "com.dogan.arabam:id/btnGarageInfo")
    public WebElement garajaDon;
    @FindBy(id = "com.dogan.arabam:id/imageViewToolbar")
    public WebElement garajAnaSayfa;



}