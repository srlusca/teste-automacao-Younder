package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebdriverManager {
	public static WebDriver webdriver;

	public WebDriver openChromeURL() {
		System.setProperty("Webdriver Manager", "~\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		webdriver.get("https://www.fakenamegenerator.com/");

		return webdriver;
	}

	public void closeWebdriver() {webdriver.close();}

}
