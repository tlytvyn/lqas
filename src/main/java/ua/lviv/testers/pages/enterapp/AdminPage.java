package ua.lviv.testers.pages.enterapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ua.lviv.testers.pages.Page;


public class AdminPage extends Page{

	public AdminPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (how = How.ID, using = "minwidth-body")
	public WebElement adminPageBody;
	
	public boolean isAdminPageDisplayed(){
		return adminPageBody.isDisplayed();
	}

}
