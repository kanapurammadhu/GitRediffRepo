package com.qa.Rediff.Pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.qa.Rediff.Base.TestBase;

public class createAccountpage extends TestBase {
	
	Logger log=Logger.getLogger(createAccountpage.class);
	
	public createAccountpage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	private WebElement username;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")
	private WebElement emailid;
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]")
	private WebElement female;
	
	
	@FindBy(xpath="//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")
	private WebElement selectvalue;
	
	String accountTitle="Rediffmail Free Unlimited Storage";
	
	public void veryfyAccoutPageTitle() {
		log.debug("Veryfy the page title");
		wait.until(ExpectedConditions.titleContains(accountTitle));
		//Assert.assertEquals(actual, expected);
	}
	
	public void setUsername(String un) {
		
		log.debug("enter the user name.....");
		username.sendKeys(un);
		
	}
	public void enterEmail(String email) {
		log.debug("Enter the email....");
		emailid.sendKeys(email);
	}
	
	public void clickfemale() {
		log.debug("Click on the Female");
		female.click();
	}
	public void selectvaluefromdropdown() {
		
		log.debug("Select bengalure city");
		//List<WebElement> opt=driver.findElements(by);
		Select sel=new Select(selectvalue);
		sel.selectByVisibleText("Bangalore");
	}
	
	
	
}
