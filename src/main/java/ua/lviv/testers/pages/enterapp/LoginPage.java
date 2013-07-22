package ua.lviv.testers.pages.enterapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ua.lviv.testers.pages.Page;


public class LoginPage extends Page{
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	@FindBy (how = How.ID, using = "modlgn_username")
	public WebElement loginTextBox;
	
	@FindBy (how = How.ID, using = "modlgn_passwd")
	public WebElement passwordTextBox;
	
	@FindBy (how = How.CSS, using = ".button1")
	public WebElement loginButton;
	
	public AdminPage loginAdminPage(String loginName, String password){
		loginTextBox.clear();
		passwordTextBox.clear();
		loginTextBox.sendKeys(loginName);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		return PageFactory.initElements(webDriver, AdminPage.class);
	}

	

	
}