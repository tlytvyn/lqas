package ua.lviv.testers.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import ua.lviv.testers.pages.enterapp.HomePage;
import ua.lviv.testers.util.Browser;
import ua.lviv.testers.util.PropertyLoader;
import ua.lviv.testers.webdriver.WebDriverFactory;


/*
 * Base class for all the test classes
 * 
 * @author Taras Lytvyn
 */

public class TestBase {
	
	/*private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";*/

	protected WebDriver webDriver;
	protected String websiteUrl;
	protected Browser browser;
	
	protected static String testUrl;
	protected static String username;
	protected static String password;
	
	public static String getUsermail() {
		return username;
	}

	public static String getPassword() {
		return password;
	}
	
	public static String getUrl() {
		return testUrl;
	}
	
	protected HomePage home;

	@Parameters({"browserName"})
	@BeforeMethod (groups = {"groupLQAS", "all", "mobile"})
	public void init(String browserName) throws Exception {
		
		browser = new Browser();
		browser.setName(browserName);
		
		testUrl = PropertyLoader.loadProperty("test.url");
		username = PropertyLoader.loadProperty("user.username");
		password = PropertyLoader.loadProperty("user.password");
		
		webDriver = WebDriverFactory.getInstance(browser.getName());
		
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		webDriver.get(testUrl);
		home = PageFactory.initElements(webDriver, HomePage.class);
	
	}
	
	@AfterMethod (groups = {"groupLQAS", "all", "mobile"})
	public void reopenApp(){
		if (webDriver != null) {
			webDriver.quit();
		}
	}
	
	
}
