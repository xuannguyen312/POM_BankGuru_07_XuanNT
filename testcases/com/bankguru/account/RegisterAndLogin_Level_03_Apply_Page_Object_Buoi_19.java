package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

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
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "seleniumOnline" + randomNumber() + "@gmail.com";
	
		// Mở URL lên thì vào trang LoginPage
		loginPage = new LoginPageObject(driver);
		
		
	}


	@Test
	public void Account_01_RegisterToSystem() {
		loginUrl = loginPage.getLoginPageURL();
		
		loginPage.clickToHereLink();
		
		
		//Click Here Link thì vào RegisterPage
		registerPage = new RegisterPageObject(driver);
		
		registerPage.inputToEmailIDTextBox(email);
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
		
		
	}
		
	@Test
	public void Account_02_LoginwithAboveInformation() {
		registerPage.openLoginPage(loginUrl);
		
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToUserIDTextBox(userID);
		loginPage.inputToPasswordTextBox(password);
		loginPage.clickToLoginButton();
		
		//Bấm Login thì chuyển đến trang Home
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isHomePageDisplayed()); 
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
