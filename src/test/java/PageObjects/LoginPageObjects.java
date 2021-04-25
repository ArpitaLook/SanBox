package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	public WebDriver driver;
	By operatorTypes=By.xpath("//div[@class='suggestion']//ul/li//div//b");
	By operator=By.xpath("(//input[@type='text'])[1]");
	By number=By.xpath("//input[contains(@pattern,'\\d*')]");
	By mobile_opt_amt=By.xpath("(//input[@suggest='mobile-operator_amount'])");
	By amt=By.xpath("//b[contains(text(),'$')]");
	By login_button=By.xpath("(//button[text()='Siguiente'])[1]");
	
	public LoginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public List<WebElement> getOperatorType()
	{
		return driver.findElements(operatorTypes);
	}
	
	public WebElement getOperator()
	{
		return driver.findElement(operator);
	}
	public WebElement getNumber()
	{
		return driver.findElement(number);
	}
	public WebElement getMobileAmt()
	{
		return driver.findElement(mobile_opt_amt);
	}
	public List<WebElement> getAmt()
	{
		return driver.findElements(amt);
	}
	public WebElement getLgnButton()
	{
		return driver.findElement(login_button);
	}
}
