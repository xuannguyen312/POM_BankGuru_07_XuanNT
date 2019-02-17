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
	
	public LoginPageObject openLoginPage(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		// Cách 2: Thay vì phải khởi tạo biến ở mỗi hàm thì ta gom các khởi tạo này
		// vào trong class PageFactoryManager để dễ quản lý, rồi từ đó khi muốn dùng hàm khởi tạo nào
		// thì ta return về hàm khởi tạo đó trong class PageFactoryManager
		
		return PageFactoryManager.getLoginPage(driver);
		
		//Cách 1: return new LoginPageObject(driver);
		/*  Ở hàm openLoginPage() ta return về class LoginPageObject ở Package PageObject
		*  bởi vì điều này tương ứng với hành động khi user open lại link http://demo.guru99.com/v4/  
		*  ở trang Register thì sẽ navigate đến trang Login. Hành động "return" cũng đồng nghĩa 
		*  với việc ta đã khởi tạo biến loginPage ở Source folder "testcases".*/
	}

}
