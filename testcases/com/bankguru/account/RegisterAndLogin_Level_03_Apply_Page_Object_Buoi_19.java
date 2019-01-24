package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractTest;

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

public class RegisterAndLogin_Level_03_Apply_Page_Object_Buoi_19 extends AbstractTest {
	WebDriver driver;
	
	private String email, userID, password, loginUrl;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "seleniumOnline" + randomNumber() + "@gmail.com";
		
	}


	@Test
	public void TC_01_Register() {
		
	}
		
	@Test
	public void TC_02_LoginwithAboveInformation() {
		 
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
