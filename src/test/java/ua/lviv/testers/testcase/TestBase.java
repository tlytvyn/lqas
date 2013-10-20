package ua.lviv.testers.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
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
	
	private static final String SCREENSHOT_FOLDER = "target/screenshots/";
	private static final String SCREENSHOT_FORMAT = ".png";

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
		Reporter.log("opening the webpage " + testUrl);
		webDriver = WebDriverFactory.getInstance(browser.getName());
		WebDriverFactory.server.newHar(testUrl);
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		webDriver.get(testUrl);
		home = PageFactory.initElements(webDriver, HomePage.class);
	
	}
	
	@AfterMethod(groups = {"groupLQAS", "all", "mobile"}, alwaysRun = true)
	public void reopenApp(ITestResult result) throws Exception{
		try{
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
					File f = ((TakesScreenshot) webDriver)
							.getScreenshotAs(OutputType.FILE);
					String fileName = result.getName() + "_" + formater.format(Calendar.getInstance().getTime()) + SCREENSHOT_FORMAT;
					try {
                         FileUtils.copyFile(f, new File(SCREENSHOT_FOLDER + fileName));
                         File directory = new File(".");
                 		 String newFileNamePath = directory.getCanonicalPath();
                         Reporter.log("<a href=" + newFileNamePath + "/" +SCREENSHOT_FOLDER + fileName + " target='_blank' >" + fileName + "</a>");
						} catch (IOException e) {
								e.printStackTrace();
						}
          	} catch (ScreenshotException se) {
               se.printStackTrace();
        }
		
		Reporter.log("closing the browser: " + browser.getName());
		
		if (webDriver != null) {
			webDriver.quit();
		}
		WebDriverFactory.server.stop();
	}
	
}
