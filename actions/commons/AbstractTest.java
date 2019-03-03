package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AbstractTest {
    private WebDriver driver;
    
    protected final Log log;
    
    protected AbstractTest() {
    	log = LogFactory.getLog(getClass());
    }
    
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
	
	private boolean checkPassed(boolean condition) {
    	boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
    	boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				System.out.println("Actual = " + actual);
				expected = expected.toString().trim();
				System.out.println("Expected = " + expected);
				status = (actual.equals(expected));
			} else {
				// Array A [5] = |5 |1 |7 |8 |10 |
				// Array B [5] = |5 |1 |7 |8 |10 |
				status = (actual == expected);
			}

			System.out.println("Compare value = " + status);
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
