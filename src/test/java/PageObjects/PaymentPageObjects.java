package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPageObjects {
	public WebDriver driver;
	
	By paymentOpt=By.xpath("//div[@class='active']//div//div//a//div//p");
	By subOpt=By.xpath("//div[@class='panel-body']//table//tbody//tr//td//a//span");
	By cardNum=By.xpath("//input[@id='cardnumberunique']");
	By expMonth=By.xpath("(//input[@name='expmonth'])[2]");
	By expYear=By.xpath("(//input[@name='expyear'])[2]");
	By cvv=By.xpath("(//input[@placeholder='CVV'])");
	By mail=By.xpath("(//input[@placeholder='Correo electrónico'])[1]");
	By total=By.xpath("//b[contains(text(),'$')]");
	By submit=By.xpath("//button[@id='paylimit']");
	public PaymentPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public List<WebElement> getPaymentOpt()
	{
		return driver.findElements(paymentOpt);
	}
	
	public List<WebElement> getSubOpt()
	{
		return driver.findElements(subOpt);
	}
	
	public WebElement getCardNum()
	{
		return driver.findElement(cardNum);
	}

	public WebElement getExpM()
	{
		return driver.findElement(expMonth);
	}

	public WebElement getExpY()
	{
		return driver.findElement(expYear);
	}

	public WebElement getCvv()
	{
		return driver.findElement(cvv);
	}
	public WebElement getMail()
	{
		return driver.findElement(mail);
	}
	public WebElement getTotal()
	{
		return driver.findElement(total);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
}
