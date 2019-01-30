package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class AbstractTest {
    private WebDriver driver;
    
	public WebDriver openMultiBrowser(String browserName) {
		System.out.println("Browser Name" + " " + browserName);
		
		if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} 
		
		else if (browserName.equals("chrome")) 
		    {   System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
		    }
		     	
		else if (browserName.equals("chromeheadless")) 
		{
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("headless");
	    	options.addArguments("window-size=1440x900");
	    	driver = new ChromeDriver(options);
		}
		
		driver.get(Constants.DEV_URL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}

}
