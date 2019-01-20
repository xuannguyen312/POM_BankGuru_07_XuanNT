package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class RegisterAndLogin_Level_02_Abstract_Page_Ke_Thua_Cach_1 extends AbstractPage {
	WebDriver driver;
	private String email, userID, password, loginUrl;
	//Build FrameWork
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		email = "seleniumOnline" + randomNumber() + "@gmail.com";
		System.out.println("Random Email:" + email);
	}

	@Test
	public void TC_01_Register() {
		//Apply Abstract Page
		openUrl(driver, "http://demo.guru99.com/v4/");
		// Step-By-Step (Selenium)
		driver.get("http://demo.guru99.com/v4/");
		
		//Apply Abstract Page
		loginUrl = getCurrentUrl(driver);
		// Step-By-Step (Selenium)
		loginUrl = driver.getCurrentUrl();
		
		//Apply Abstract Page
		clickToElement(driver,"//a[text()='here']");
		// Step-By-Step (Selenium)
		driver.findElement(By.xpath("//a[text()='here']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(.,'Enter your email address to get')]")).isDisplayed());
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//Lưu dữ liệu của UserID/Password
	    userID = driver.findElement(By.xpath("//td[@class='accpage' and contains(text(),'User ID')]//following-sibling::td")).getText();
	    password = driver.findElement(By.xpath("//td[@class='accpage' and contains(text(),'Password')]//following-sibling::td")).getText();
		
	    System.out.println("UserID : " + userID);
	    System.out.println("Password : " + password);
		
	}
	
	@Test
	public void TC_02_LoginwithAboveInformation() {
		 
		//Truyền Dữ Liệu của USerID/pass để đăng nhập
	    driver.get(loginUrl);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
	    driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
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
