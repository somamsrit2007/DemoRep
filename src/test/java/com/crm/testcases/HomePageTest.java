package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase_Driver;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.Testutil;

public class HomePageTest extends TestBase_Driver {
	
	LoginPage loginPage;
	HomePage homePage;
	Testutil testutil;
	ContactsPage contactsPage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testutil=new Testutil();
		contactsPage=new ContactsPage();
		 loginPage = new LoginPage();
		homePage= loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page Title is Not Matched");
		
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest()
	{
		
		testutil.switchToFrame();
	   Assert.assertTrue(homePage.verifyCorrectUserName());
	   
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testutil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	   

	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
