package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class amazon {
	AndroidDriver<WebElement> driver=null;
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities capability=new DesiredCapabilities();
		//capabilities to launch amazon native application
		capability.setCapability("deviceName", "Redmi Note 5 Pro");
		capability.setCapability("platformVersion", "8.1.0");
		capability.setCapability("PlatformName", "Android");
		capability.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver=new AndroidDriver<WebElement>(new URL("http://192.168.43.147:4723/wd/hub"), capability);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElementById("com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon").click();
	    driver.findElement(By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/anp_drawer_item'][12]")).click();
	    driver.findElement(By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/anp_drawer_item'][1]")).click();
	    //country options are loading slowly sometimes
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[contains(@text,'Country/Region:')][1]")).click();
	    driver.findElement(By.xpath("//*[contains(@text,'Australia')]")).click();
	    driver.findElement(By.xpath("//*[contains(@text,'Done')]")).click();
	    
}
	@AfterTest
	public void after() throws InterruptedException {
		driver.quit();
}
}
