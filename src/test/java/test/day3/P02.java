package test.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArabamPage;
import utilities.Driver;
import utilities.Reusablemethods;

public class P02 {

    @Test
    public void test01(){
        AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
        TouchAction action=new TouchAction<>(driver);
        ArabamPage arabamPage = new ArabamPage();



        // Arabam kac para bolumune tiklayalim
        Reusablemethods.clickCoordinate(220,1200,300);

        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(220,1360,300);

        // Wolkswagen markasini secelim
        Reusablemethods.waitS(1);
        Reusablemethods.screenScrollDown(300);
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(780,1525,300);

        // yil secimi yapalim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(120,617,300);
        if (driver.isKeyboardShown()){
            Reusablemethods.clickCoordinate(92,1700,300);
            driver.getKeyboard().pressKey("2000");
        }else {
            driver.getKeyboard().sendKeys("2000");
        }
        Reusablemethods.clickCoordinate(300,825,300);

        // model secimi yapalim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(770,1080,300);

        // govde tipini secelim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(305,625,300);

        // yakit tipini secelim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(305,625,300);

        // vites tipini secelim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(305,625,300);

        // Versiyon secimi yapalim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(400,1325,300);

        // aracin km bilgilerini girelim
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("100000");
        }else {
            driver.getKeyboard().sendKeys("150000");
        }
        Reusablemethods.clickCoordinate(535,756,300);

        // aracin rengini secelim
        Reusablemethods.waitS(1);
        Reusablemethods.screenScrollDown(300);
        Reusablemethods.clickCoordinate(786,1665,300);
        // opsiyel donanim (varsa) seecelim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(305,625,300);
        Reusablemethods.clickCoordinate(770,625,300);
        Reusablemethods.clickCoordinate(283,815,300);
        Reusablemethods.clickCoordinate(550,1680,300);
        // degisen bilgisi ekleyerek tramer kaydi belirtelim
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(550,780,300);
        Reusablemethods.clickCoordinate(170,1620,300);
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(525,1700,300);

        //Accident report about how much got damaged as money you must click one of chooses
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(62,664,300);
        Reusablemethods.clickCoordinate(525,1700,300);

        // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
        Reusablemethods.waitS(1);
        String actualPrice = arabamPage.avarageMarketPrice.getText().replaceAll("\\D","");
        int expectedPrice= 500000;

        Assert.assertTrue(Integer.parseInt(actualPrice)>expectedPrice);

        // uygulamayi kapatalim
        driver.closeApp();
    }
}
