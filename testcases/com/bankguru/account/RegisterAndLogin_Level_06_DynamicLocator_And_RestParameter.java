package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
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

public class RegisterAndLogin_Level_06_DynamicLocator_And_RestParameter extends AbstractTest {
	WebDriver driver;
	
	private String email, userID, password, loginUrl;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private DepositPageObject depositPage;
	private NewAccountPageObject newAccountPage;
	private NewCustomerPageObject newCustomerPage;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		email = "seleniumOnline" + randomNumber() + "@gmail.com";
	
		// Mở URL lên thì vào trang LoginPage
		//loginPage = new LoginPageObject(driver);
		
		loginPage = PageFactoryManager.getLoginPage(driver);
	}


	@Test
	public void Account_01_RegisterToSystem() {
		loginUrl = loginPage.getLoginPageURL();
		/*Khi click lên Here_Link ở trang Login thì vào trang Register
		Ta không cần dùng cách khởi tạo trực tiếp này khi chuyển page
		registerPage = new RegisterPageObject(driver);
		Bởi vì ta đã khởi tạo biến RegisterPage ở hàm clickToHereLink ở class LoginPageObject.
		Chúng ta đã thành công che dấu khởi tạo cho biến registerPage ở class này. */
		
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextBox(email);
		registerPage.clickToSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
		
		
	}
		
	@Test
	public void Account_02_LoginwithAboveInformation() {
		//Che giấu khởi tạo cho loginPage cũng tương tự registerPage
		loginPage = registerPage.openLoginPage(loginUrl);
		loginPage.inputToUserIDTextBox(userID);
		loginPage.inputToPasswordTextBox(password);
		//Che giấu khởi tạo cho homePage cũng tương tự registerPage
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed()); 
	}
	
	@Test
	public void Account_03_WebDriverLifeCycle() {
		/*---------------------Áp Dụng Cho Vài Chục Page-----------------------------*/
		//Home Page chuyển đến New Customer Page
		/*newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		//New Customer chuyển đến New Account
		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
				
		//New Account chuyển đến Deposit
		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		Assert.assertTrue(depositPage.isDepositPageDisplayed());
		
		//Deposit chuyển đến Home page
		homePage = (HomePageObject) depositPage.openDynamicPage(driver, "Manager");
		Assert.assertTrue(homePage.isHomePageDisplayed());

		//HomePage chuyển đến New Account
		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());*/
		
		/*-----------------Áp Dụng Cho Trăm Ngàn Page------------------------*/
		homePage.openDynamicPage(driver, "New Customer");
		//Hàm này sẽ thực hiện chuyển trang
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		//Hàm này sẽ khởi tạo biến newCustomer
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		
		
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
