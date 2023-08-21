package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class Reusablemethods {
    public static void waitS(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clickCoordinate(int xValue,int yValue,int waitMS) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xValue,yValue)).release().perform();
        try {
            Thread.sleep(waitMS);
        } catch (InterruptedException e) {

        }

    }

    public static void passThroughFirstPagesAtKiwiApp() throws InterruptedException {
        for (int i = 0; i < 3 ; i++) {
            Reusablemethods.clickCoordinate(538,1689,1000);
        }
    }
    public static void screenScroll(int xPress,int yPress,int wait,int moveX,int moveY){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(moveX,moveY))
                .release()
                .perform();
    }
    public static void screenScrollDown(int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,1371))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,186))
                .release()
                .perform();
    }
    public static void screenScrollUp(int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(471,186))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(471,1371))
                .release()
                .perform();
    }
    // 1052,1016 31,1016
    public static void screenScrollRight(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(1052, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(31, 1016))
                .release()
                .perform();
    }
    public static void screenScrollLeft(int wait) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(31, 1016))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(1052, 1016))
                .release()
                .perform();
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text('" + elementText + "'))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }

    public static String getScreenShot(String name) {
       String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir")+"/target/Screenshots/"+ name + date + ".png";
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source,finalDestination);
        } catch (IOException e) {

        }


        return target;
    }

}

