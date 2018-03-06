package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase_Driver;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.Testutil;

public class ContactsPageTest  extends TestBase_Driver
{
	
	String sheetName = "contacts";


	LoginPage loginPage;
	HomePage homePage;
	Testutil testutil;
	ContactsPage contactsPage;
	public ContactsPageTest()
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
		testutil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts page is missing"); 
		
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] =Testutil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}

	
	
	@Test(priority=2)
	public void validateCreateNewContact()
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Varchas", "S", "Google");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();

}
}
