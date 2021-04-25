package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessPageObjects {
	public WebDriver driver;
	

	By username=By.xpath("//input[@id='usrname']");
	By password=By.xpath("//input[@id='psw']");
	By captha=By.xpath("(//div[@class='recaptcha-checkbox-border'])[1]");
	By lgnBtn=By.xpath("//button[text()='Acceso']");
	By frame=By.xpath("(//iframe[@title='reCAPTCHA'])[1]");
	//By msg=By.xpath("//p[@class='message']");
	By confirmBtn=By.xpath("//input[@class='confirmButton']");
	By msg=By.xpath("//div[contains(@class,'successBox')]");
	
	public AccessPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getCaptha()
	{
		return driver.findElement(captha);
	}
	public WebElement getLgnBtn()
	{
		return driver.findElement(lgnBtn);
	}
	public WebElement getFrame()
	{
		return driver.findElement(frame);
	}
	public WebElement getConBtn()
	{
		return driver.findElement(confirmBtn);
	}
	public WebElement getMsg()
	{
		return driver.findElement(msg);
	}
}
