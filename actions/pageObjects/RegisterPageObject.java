package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	public RegisterPageObject (WebDriver driverMapping)
	{
		driver = driverMapping;
	}
	
	public void inputToEmailIDTextBox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver,RegisterPageUI.SUBMIT_BUTTON);
	}
	
	public String getUserIDText() {
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getText(driver,RegisterPageUI.USER_ID_TEXT);
		
	}
	
	public String getPasswordText() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getText(driver,RegisterPageUI.PASSWORD_TEXT);
	}
	
	public void openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
	}

}
