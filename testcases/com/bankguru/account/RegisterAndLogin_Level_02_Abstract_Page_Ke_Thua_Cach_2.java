package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class RegisterAndLogin_Level_02_Abstract_Page_Ke_Thua_Cach_2 {
	WebDriver driver;
	
	//Khai Báo AbstractPage
	private AbstractPage abstractPage;
	
	private String email, userID, password, loginUrl;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
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
		
		//driver = new FirefoxDriver();
		
		//Khởi Tạo AbstractPage
		abstractPage = new AbstractPage();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		email = "seleniumOnline" + randomNumber() + "@gmail.com";
		System.out.println("Random Email:" + email);
	}

	@Test
	public void TC_01_Register() {
		//Apply Abstract Page
		abstractPage.openUrl(driver, "http://demo.guru99.com/v4/");
		// Step-By-Step (Selenium)
		// driver.get("http://demo.guru99.com/v4/");
		
		//Apply Abstract Page
		loginUrl = abstractPage.getCurrentUrl(driver);
		// Step-By-Step (Selenium)
		// loginUrl = driver.getCurrentUrl();
		
		//Apply Abstract Page
		abstractPage.clickToElement(driver,"//a[text()='here']");
		// Step-By-Step (Selenium)
		// driver.findElement(By.xpath("//a[text()='here']")).click();
		
		//Apply Abstract Page
		Assert.assertTrue(abstractPage.isControlDisplayed(driver,"//h2[contains(.,'Enter your email address to get')]"));
		// Step-By-Step (Selenium)
		// Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Enter your email address to get')]")).isDisplayed());
		
		//Apply Abstract Page
		abstractPage.sendKeyToElement(driver, "//input[@name='emailid']", email);
		// Step-By-Step (Selenium)
		//driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		//driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//Lưu dữ liệu của UserID/Password
		userID = abstractPage.getText(driver, "//td[@class='accpage' and contains(text(),'User ID')]//following-sibling::td");
	    //userID = driver.findElement(By.xpath("//td[@class='accpage' and contains(text(),'User ID')]//following-sibling::td")).getText();
	    password = abstractPage.getText(driver, "//td[@class='accpage' and contains(text(),'Password')]//following-sibling::td");
		//password = driver.findElement(By.xpath("//td[@class='accpage' and contains(text(),'Password')]//following-sibling::td")).getText();
		
	    System.out.println("UserID : " + userID);
	    System.out.println("Password : " + password);
		
	}
	
	@Test
	public void TC_02_LoginwithAboveInformation() {
		 
		//Truyền Dữ Liệu của USerID/pass để đăng nhập
	    abstractPage.openUrl(driver, loginUrl);
		//driver.get(loginUrl);
	    abstractPage.sendKeyToElement(driver, "//input[@name='password']", password);
	    //driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    abstractPage.sendKeyToElement(driver, "//input[@name='uid']", userID);
	    //driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	    abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	    //driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	   // Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + userID + "']")).isDisplayed());
	}
	
	
	
	
	@AfterClass
	public void afterClass() {

		driver.quit();
	}
	
	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}

}
