package test.day2;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Reusablemethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task01 {
    AndroidDriver<AndroidElement> driver;
    @BeforeTest
    public void before() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HUAWEI\\IdeaProjects\\Appium_Team116\\apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HUAWEI\\IdeaProjects\\Appium_Team116\\apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        //uygulamanin basarili bir sekilde yuklendifggi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        //uygulamanin basarili bir sekilde acildigi dogrulanir
        AndroidElement headerText=driver.findElementById("com.dogan.arabam:id/tvShowroomInfo");
        Assert.assertTrue(headerText.isDisplayed());

        // Arabam kac para bolumune tiklayalim
        driver.findElementByXPath("//*[@text='Arabam kaç para?']").click();
        Reusablemethods.waitS(1);

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();
        Reusablemethods.waitS(2);

        // Wolkswagen markasini secelim
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(538,2030))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(538,400))
                .release()
                .perform();
        Reusablemethods.waitS(2);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // yil secimi yapalim
        Reusablemethods.waitS(2);
        driver.findElementByXPath("//*[@text='2018']").click();

        // model secimi yapalim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Transporter']").click();

        // govde tipini secelim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Camlı Van']").click();
        // yakit tipini secelim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Dizel']").click();
        // vites tipini secelim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Düz']").click();
        // Versiyon secimi yapalim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Seç']").click();
        // aracin km bilgilerini girelim
        driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("100000");
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracin rengini secelim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Mavi']").click();
        // opsiyel donanim (varsa) seecelim

        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Devam']").click();
        Reusablemethods.waitS(1);
        action = new TouchAction<>(driver);
        action.tap(PointOption.point(65,811)).perform();
        Reusablemethods.waitS(1);
        driver.findElementByXPath("//*[@text='Devam']").click();

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        Reusablemethods.waitS(1);
        String priceFromApp= driver.findElementById("com.dogan.arabam:id/tvAveragePrice").getText();
        String[] priceFromAppArr = priceFromApp.split(" ");
        priceFromApp = priceFromAppArr[0].replaceAll("\\D","");
        int actualPrice = Integer.parseInt(priceFromApp);
        int expectedPrice = 500000;
        Assert.assertTrue(actualPrice>expectedPrice);
        // uygulamayi kapatalim
        driver.closeApp();
    }
}
