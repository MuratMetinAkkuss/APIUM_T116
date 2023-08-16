package test.day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KiwiApp {
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
        //bir uygulamanin on bellegini her testten sonra sifirlamak istiyorsak
        //NO_RESET false olmak zorundadir
        //Bir uygulamada uygulamanin on bellegini sifirlamadan gectigimiz adimalarin kaydedilerek
        //sifirdan uygulamanin baslamasini istemiyorsak ==> true olmak zorundadir.


        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


}
