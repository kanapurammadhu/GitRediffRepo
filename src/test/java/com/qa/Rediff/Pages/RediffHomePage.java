package com.qa.Rediff.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.Rediff.Base.TestBase;

public class RediffHomePage extends TestBase {

	Logger log=Logger.getLogger(RediffHomePage.class);
	
	public RediffHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"signin_info\"]/a[2]")
	private WebElement createaccountlink;
	
	String pageTitle="Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
	
	
	public void waitUntilGetPageTitle() {
		
		log.debug("wait until rediff homepage title found");
		wait.until(ExpectedConditions.titleContains(pageTitle));
		
	}
	
	public createAccountpage clickOnCreateAccount() {
		
		createaccountlink.click();
		return new createAccountpage();
		
	}
}
