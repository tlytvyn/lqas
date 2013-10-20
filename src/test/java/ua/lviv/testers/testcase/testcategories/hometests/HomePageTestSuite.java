package ua.lviv.testers.testcase.testcategories.hometests;

import java.io.File;
import java.io.IOException;

import net.lightbody.bmp.core.har.Har;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import ua.lviv.testers.testcase.testcategories.LoginPageTest;
import ua.lviv.testers.webdriver.WebDriverFactory;

public class HomePageTestSuite extends LoginPageTest{
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 1.1
	public void enterAdminPageView(){
		Assert.assertTrue(home.isSiteLogoDisplayed());
	}
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 1.2
	public void signInDisapearing() throws InterruptedException{
		Assert.assertFalse(home.verifySignInDisapearing());
	}
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 1.3
	public void checkElementClassAttribute(){
		JavascriptExecutor jsEcecution = (JavascriptExecutor)webDriver;
		String result = (String) jsEcecution.executeScript("return document.getElementById('menu-item-10').getAttribute('class')");
		Assert.assertTrue(result.contains("menu-item menu-item-type"));
	}
	
	@Test (groups = {"groupLQAS", "all", "mobile"})
	//TS 1.4
	public void gatherHARfromTestWebSite() throws IOException{
		Har har = WebDriverFactory.server.getHar();
		File harFile = new File("target/harfile.har");
		har.writeTo(harFile);
		Assert.assertTrue(harFile.length() != 0);
	}
	
	
}
