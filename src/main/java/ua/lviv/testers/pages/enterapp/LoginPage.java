package ua.lviv.testers.pages.enterapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import ua.lviv.testers.pages.Page;


public class LoginPage extends Page{
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.CLASS_NAME, using = "avatar")
	public WebElement avatarImage;
	
	public boolean isAvatarDisplayed(){
		Reporter.log("checking the avatar image presence on screen");
		return avatarImage.isDisplayed();
	}

	

	
}