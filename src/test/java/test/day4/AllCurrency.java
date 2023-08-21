package test.day4;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Reusablemethods;

import java.io.ObjectInputFilter;

public class AllCurrency {


    @Test
    public void test01(){
        AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
        TouchAction action;
        AllCurrencyPage allCurrency = new AllCurrencyPage();

        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("allCurrencyConverterBundle")));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(allCurrency.trendsCharts.isEnabled());
        // cevirmek istedigimiz para birimi zloty olarak secilir
        Reusablemethods.clickCoordinate(360,330,500);
        Reusablemethods.waitS(1);
        Reusablemethods.scrollWithUiScrollable("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        Reusablemethods.clickCoordinate(360,460,500);
        Reusablemethods.waitS(1);
        Reusablemethods.scrollWithUiScrollable("Turkish Lira");
        Reusablemethods.scrollWithUiScrollable("1");
        for (int i = 0; i <3; i++) {
            Reusablemethods.scrollWithUiScrollable("0");
        }
        // cevrilen tutar screenShot olarak kaydedilir
        Reusablemethods.getScreenShot("ZlotyToTL");
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String resultOfTL = allCurrency.result.getText();
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
    }
}
