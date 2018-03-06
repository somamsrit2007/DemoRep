package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase_Driver;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest  extends TestBase_Driver{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void vaildateTitleTest()
	{
		
		String title=loginPage.validateLoginPage();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
		
	}
	@Test(priority=2)
	public void cmrLogoTest()
	{
		boolean flag=loginPage.validatecrmImgLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginTest()
	{
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
