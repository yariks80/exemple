import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;



/**
 * Created by DELL on 7/8/2016.
 */
public class CalculatorTest {
    public AppiumDriver driver;

    DesiredCapabilities capabilities = new DesiredCapabilities();

    @Before
    public void setUp() {
        setCapabilities();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void restartAppium() {
        // TBD
    }

    private void setCapabilities() {
        //capabilities.setCapability("autoLaunch","false");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"300");

        //which mobile OS to use: Android, iOS or FirefoxOS
        capabilities.setCapability("platformName", "Android");

        //Mobile OS version � in this case 4.4 since my device is running Android 4.4.2
        capabilities.setCapability(CapabilityType.VERSION, "5.0.1");

        //device name � since this is an actual device name is found using ADB
        capabilities.setCapability("deviceName", "4d00fffaced1915d");

        //Java package of the tested Android app
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");

        // activity name for the Android activity you want to run from your package. This need to be preceded by a . (example: .MainActivity)
        capabilities.setCapability("appActivity", ".Calculator");

        // constructor to initialize driver object

    }


    @Test
    public void doSomething() throws InterruptedException {
        WebElement clear = driver.findElement(By.id("bt_backspace"));
        WebElement bt2 = driver.findElement(By.id("bt_02"));
        WebElement add = driver.findElement(By.id("bt_add"));
        WebElement bt3 = driver.findElement(By.id("bt_03"));
        WebElement equal = driver.findElement(By.id("bt_equal"));

        clear.click();
        Thread.sleep(1000);
        bt2.click();
        Thread.sleep(1000);
        add.click();
        Thread.sleep(1000);
        bt2.click();
        Thread.sleep(1000);
        equal.click();
        Thread.sleep(1000);
    }

}
