package com.cucmber.pratice.com.cucumber;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.PageObject.BaseClass;
import com.cucumber.PageObject.LandingPage.CartPage;
import com.cucumber.PageObject.LandingPage.LandingPage;
import com.cucumber.PageObject.LandingPage.PamentPage;
import com.cucumber.PageObject.LandingPage.ProductCatalog;

public class RunnerClass extends BaseClass {


	@Test	
	public void SubmitOrder() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		LandingPage login=setdriver();
		ProductCatalog products=login.loginApplication(BaseClass.propertiesReader("email"),BaseClass.propertiesReader("password"));
		//ProductCatalog products= new ProductCatalog(driver); creating the object in landing page and returning the product as a object
		products.addProductToCart(BaseClass.propertiesReader("ProductName"));
		CartPage cartpage = BaseClass.goToCart();
		//CartPage cartpage= new CartPage(driver);
		Boolean booleanvalue=cartpage.verifyProductDisplayed(BaseClass.propertiesReader("ProductName"));
		Assert.assertTrue(booleanvalue);
		cartpage.clickOnTotal();
		PamentPage pmntpage = new PamentPage(driver);
		pmntpage.choiceCountry(BaseClass.propertiesReader("CountryName"));
		Assert.assertTrue(pmntpage.ThankyouMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
	@Test	
	public void SubmitOrderforedge() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stub
		
		LandingPage login=setdriver();
		ProductCatalog products=login.loginApplication(BaseClass.propertiesReader("email"),BaseClass.propertiesReader("password"));
		//ProductCatalog products= new ProductCatalog(driver); creating the object in landing page and returning the product as a object
		products.addProductToCart(BaseClass.propertiesReader("ProductName"));
		CartPage cartpage = BaseClass.goToCart();
		//CartPage cartpage= new CartPage(driver);
//		Boolean booleanvalue=cartpage.verifyProductDisplayed(BaseClass.propertiesReader("ProductName"));
//		Assert.assertTrue(booleanvalue);
//		cartpage.clickOnTotal();
//		PamentPage pmntpage = new PamentPage(driver);
//		pmntpage.choiceCountry(BaseClass.propertiesReader("CountryName"));
//		Assert.assertTrue(pmntpage.ThankyouMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	}
}
