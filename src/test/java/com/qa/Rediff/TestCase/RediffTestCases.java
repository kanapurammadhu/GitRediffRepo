package com.qa.Rediff.TestCase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.qa.Rediff.Base.TestBase;

import com.qa.Rediff.Pages.RediffHomePage;
import com.qa.Rediff.Pages.createAccountpage;



public class RediffTestCases extends TestBase {

	Logger Log=Logger.getLogger(RediffTestCases.class);
	
	RediffHomePage Homepage;
	createAccountpage createAccount;
	
//	public RediffTestCases() {
//	super();
//	}
	
	
	@BeforeClass
	public void bTest() {
		
		Homepage=new RediffHomePage();
		Homepage.waitUntilGetPageTitle();
		createAccount=Homepage.clickOnCreateAccount();
		createAccount=new createAccountpage();
		createAccount.veryfyAccoutPageTitle();
		createAccount.setUsername(readProperties("username1"));
		createAccount.enterEmail(readProperties("email"));
		createAccount.clickfemale();
		createAccount.selectvaluefromdropdown();
		
		
	}
	
	@AfterClass
	public void aTest() {
		
	}
	@Test
	public void testt() {
		
	}
	
	
}
