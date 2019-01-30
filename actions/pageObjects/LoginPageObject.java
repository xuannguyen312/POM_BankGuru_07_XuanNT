package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	
	public LoginPageObject (WebDriver driverMapping)
	{
		driver = driverMapping;
	}
	
	public String getLoginPageURL() {
		return getCurrentUrl(driver);
	}
	
	public void inputToUserIDTextBox(String userID) {
		waitToElementVisible(driver,LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}
	
	public void inputToPasswordTextBox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
	}
	
	public void clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver,LoginPageUI.HERE_LINK);
	}
	
	
}
