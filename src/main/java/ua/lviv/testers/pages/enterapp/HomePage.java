package ua.lviv.testers.pages.enterapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ua.lviv.testers.pages.Page;


public class HomePage extends Page{

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (how = How.CSS, using = ".site-logo")
	public WebElement siteLogo;
	
	@FindBy (how = How.CSS, using = "span[class='button-icon login']")
	public WebElement signInButton;
	
	@FindBy (how = How.CLASS_NAME, using = "tooltip-text")
	public WebElement signInMenu;
	
	@FindBy (how = How.ID, using = "menu-item-10")
	public WebElement forumButton;
	
	@FindBy (how = How.NAME, using = "user_login")
	public WebElement loginTextBox;
	
	@FindBy (how = How.NAME, using = "user_password")
	public WebElement passwordTextBox;
	
	@FindBy (how = How.CSS, using = "a[class='button submit-button']")
	public WebElement loginButton;
	
	public boolean isSiteLogoDisplayed(){
		return siteLogo.isDisplayed();
	}
	
	public LoginPage loginAdminPage(String loginName, String password){
		signInButton.click();
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(signInMenu));
		passwordTextBox.clear();
		loginTextBox.sendKeys(loginName);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		Reporter.log("Loging to Admin Page with login name " + loginName + " and password " + password);
		return PageFactory.initElements(webDriver, LoginPage.class);
	}
	
	public boolean verifySignInDisapearing() throws InterruptedException{
		Actions seleniumActions = new Actions(webDriver);
		Action mouseOver = seleniumActions.moveToElement(signInButton).clickAndHold().build();
		mouseOver.perform();
		return signInMenu.isDisplayed();
	}

}
