package ua.lviv.testers.webdriver;

import net.lightbody.bmp.proxy.ProxyServer;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.iphone.IPhoneDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * 
 * @author Taras Lytvyn
 */

@SuppressWarnings("deprecation")
public class WebDriverFactory { 
	
	/* Browsers constants */
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String OPERA = "opera";
	public static final String INTERNET_EXPLORER = "ie";
	public static final String HTML_UNIT = "htmlunit";
	public static final String IPHONE = "iphone";
	public static final String ANDROID = "android";
	public static ProxyServer server;
	
	public static WebDriver getInstance(String browser) throws Exception {
		server = new ProxyServer(4444);
		server.start();
		Proxy proxy = server.seleniumProxy();
		WebDriver webDriver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		if (CHROME.equals(browser)) {
			setChromeDriver();
			capabilities.setJavascriptEnabled(true);
			webDriver = new ChromeDriver(capabilities);
		} else if (FIREFOX.equals(browser)) {

			FirefoxProfile ffProfile = new FirefoxProfile();
			webDriver = new FirefoxDriver(ffProfile);

		} else if (INTERNET_EXPLORER.equals(browser)) {
			webDriver = new InternetExplorerDriver();
		}
		else if (IPHONE.equals(browser)) {
			try {
				webDriver = new IPhoneDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ANDROID.equals(browser)) {
			webDriver = new AndroidDriver();

		} else {
				webDriver = new HtmlUnitDriver(true);
			}

		return webDriver;
	}
	
	private static void setChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String chromeBinary = "src/main/resources/drivers/chrome/chromedriver"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}
}