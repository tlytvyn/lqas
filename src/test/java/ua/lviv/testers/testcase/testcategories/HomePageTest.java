package ua.lviv.testers.testcase.testcategories;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ua.lviv.testers.testcase.TestBase;

public class HomePageTest extends TestBase{
	
	
	@BeforeMethod (groups = {"groupLQAS", "all", "mobile"})
	public void testInit() throws Exception {
		
	}
	
	@AfterMethod(alwaysRun = true, groups = {"groupLQAS", "all", "mobile"})
    public void afterClass() throws Exception {
		
    }
}