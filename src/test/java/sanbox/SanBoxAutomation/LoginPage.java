package sanbox.SanBoxAutomation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AccessPageObjects;
import PageObjects.LoginPageObjects;
import PageObjects.PaymentPageObjects;
import junit.framework.Assert;

public class LoginPage extends Base {
	public WebDriver driver;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver= init();
		  
	}
  @Test
  public void login() throws IOException {
	  	//Get the data from properties file
	    FileInputStream fis=new FileInputStream("G:\\Assignment2\\SanBoxAutomation\\src\\test\\java\\Files\\Data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String optType1=prop.getProperty("optType");
		String number=prop.getProperty("number");
		String rate=prop.getProperty("rate");
		String subType=prop.getProperty("subType");
		String payOpt1=prop.getProperty("payOpt");
		String cardNum=prop.getProperty("cardNum");
		String month=prop.getProperty("month");
		String year=prop.getProperty("year");
		String cvv=prop.getProperty("cvv");
		String mail=prop.getProperty("mail");
		String username=prop.getProperty("username");
		String pwd=prop.getProperty("pwd");
		String actualMsg=prop.getProperty("actualMsg");
		
	  LoginPageObjects lpo=new LoginPageObjects(driver);
	  lpo.getOperator().click();
	  List<WebElement> optType=lpo.getOperatorType();
	  for(int i=0;i<optType.size();i++)
	  {
		  if(lpo.getOperatorType().get(i).getText().equals(optType1))//Operador  field
		  {
			  lpo.getOperatorType().get(i).click();
			  break;
		  }
	  }
	  lpo.getNumber().sendKeys(number); //Numero de celular field 
	  lpo.getMobileAmt().click(); //Monto de Recarga
	  List<WebElement> amt=lpo.getAmt();
	  for(int k=0;k<amt.size();k++)
	  {
		  //System.out.println(amt.get(k).getText());
		 if(lpo.getAmt().get(k).getText().equals(rate)) //$0
		 {
			 amt.get(k).click();
			 break;
		 }
	  }
	  lpo.getLgnButton().click();//click on siguiente
	  
	  PaymentPageObjects ppo=new PaymentPageObjects(driver);
	  List<WebElement> payopt=ppo.getPaymentOpt();
	  List<WebElement> subOpt=ppo.getSubOpt();
	  for(int j=0;j<payopt.size();j++)
	  {
		 // System.out.println(payopt.get(j).getText());
		  if(payopt.get(j).getText().equalsIgnoreCase(subType)) 
		  {
			  payopt.get(j).click();//click on tarjeta
			  for(int l=0;l<subOpt.size();l++)
			  {
				  //System.out.println(subOpt.get(l).getText());
				  if(subOpt.get(l).getText().equalsIgnoreCase(payOpt1)) 
				  {
					  System.out.println(subOpt.get(l).getText());
					  subOpt.get(l).click(); // click on Usar nueva tarjeta
					  
					  ppo.getCardNum().sendKeys(cardNum); //add card num
					  ppo.getExpM().sendKeys(month); // expire month
					  ppo.getExpY().sendKeys(year);// expire year
					  ppo.getCvv().sendKeys(cvv);// add cvv
					  ppo.getMail().sendKeys(mail);// add test@test.com
					  String Total= ppo.getTotal().getText();
					  Assert.assertEquals(Total, rate); //verified the total with Monto de Recarga 10 dollar
					  ppo.getSubmit().click(); //Click on Pagar con Tarjeta
					  
					  AccessPageObjects apo=new AccessPageObjects(driver);
					  apo.getUsername().sendKeys(username); // enter the email
					  apo.getPassword().sendKeys(pwd); // enter the password
					  driver.switchTo().frame(0);
					  apo.getCaptha().click(); // click on captcha
					  driver.switchTo().defaultContent();
					  apo.getLgnBtn().click(); // click on acceso button 
					  
					  apo.getConBtn().click(); // click on confirm button 
					 // System.out.println(apo.getMsg().getText());
					  
					  Assert.assertEquals(apo.getMsg().getText(),actualMsg);//Verified successful logged in message
					 
					 break; 
				  }
			  }
			  break;
		  }
		  
	  }
	  
	  
	  //driver.close();
	 
  }
  @AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
