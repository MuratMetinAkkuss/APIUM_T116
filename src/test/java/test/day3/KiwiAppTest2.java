package test.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Reusablemethods;

public class KiwiAppTest2 {
    @Test
    public void test01(){
        AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
        TouchAction action=new TouchAction<>(driver);
        KiwiPage kiwiPage=new KiwiPage();
        // verify that app is installed
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiAppBundle")));
        // verify that app is opened successfuly
        Reusablemethods.waitS(1);
        Assert.assertTrue(kiwiPage.misafirOlarakDevamEt.isDisplayed());
        // click 'Continue as a guest'
        kiwiPage.misafirOlarakDevamEt.click();

        // click that there are three repetad button on same coordinate
        Reusablemethods.waitS(1);
        kiwiPage.ilkSayfaGecisleri();

        // choose "trip type" as a 'one way'
        Reusablemethods.waitS(1);
        Assert.assertTrue(kiwiPage.aramaButonu.isDisplayed());
        Reusablemethods.clickCoordinate(240,620,300);
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(1010,1457,300);

        // Click on the departure country option and the default country will be removed
        Reusablemethods.waitS(1);
        kiwiPage.fromBoxIlkSecenek.clear();

        // Enter the country/city of departure and click select
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Amsterdam");
        }else {
            driver.getKeyboard().sendKeys("Rotterdam");
        }
        Reusablemethods.waitS(2);
        Reusablemethods.clickCoordinate(370,290,300);
        Reusablemethods.clickCoordinate(800,980,300);

        // Click on the destination country option and enter the destination country.
        Reusablemethods.waitS(1);
        Reusablemethods.clickCoordinate(335,920,300);
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("izmir");
        }else {
            driver.getKeyboard().sendKeys("istanbul");
        }
        Reusablemethods.waitS(2);
        Reusablemethods.clickCoordinate(370,290,300);
        Reusablemethods.clickCoordinate(800,980,300);

        // The departure date is selected as the 21st of September and set date is clicked.
        Reusablemethods.waitS(1);
        Reusablemethods.screenScrollDown(600);

        // click on search button
        // the cheapest and non-stop filtering is done
        // Incoming ticket price is recorded and sent to the user's phone as an SMS.
    }

}
