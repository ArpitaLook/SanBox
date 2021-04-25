package sanbox.SanBoxAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public WebDriver init() throws IOException
	{
		FileInputStream fis=new FileInputStream("G:\\Assignment2\\SanBoxAutomation\\src\\test\\java\\Files\\Data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		System.setProperty("webdriver.chrome.driver", "G:\\Assignment2\\SanBoxAutomation\\src\\test\\java\\Files\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		return driver;
		
	}



}
