import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by DELL on 7/8/2016.
 */
public class AndroidTest {

@Test
    public void testGoogle() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"300");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

    //which mobile OS to use: Android, iOS or FirefoxOS
    capabilities.setCapability("platformName", "Android");


    //Mobile OS version � in this case 4.4 since my device is running Android 4.4.2
    capabilities.setCapability(CapabilityType.VERSION, "5.0.1");

    //device name � since this is an actual device name is found using ADB
    capabilities.setCapability("deviceName", "4d00fffaced1915d");

    WebDriver driver =  new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    
        // откроем страницу Google
        driver.get("http://www.google.com");

        // Найдем поле ввода по атрибуту name
        WebElement element = driver.findElement(By.name("q"));

        // Введем текст для поиска
        element.sendKeys("СЫР!");

        // Отправим форму. WebDriver найдет за нас нужную форму по её элементу.
        element.submit();

        // Проверим заголовок страницы
        System.out.println("Заголовок страницы: " + driver.getTitle());
        driver.quit();
    }
}