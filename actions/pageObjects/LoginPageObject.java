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
	
	public HomePageObject clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
		// Cách 2: Thay vì phải khởi tạo biến ở mỗi hàm thì ta gom các khởi tạo này
		// vào trong class PageFactoryManager để dễ quản lý, rồi từ đó khi muốn dùng hàm khởi tạo 
		// nào thì ta return về hàm khởi tạo đó trong class PageFactoryManager
		return PageFactoryManager.getHomePage(driver);
		
		//Cách 1: return new HomePageObject(driver);
		/*Return về class HomePageObject cũng tương tự ý nghĩa như return về RegisterPageObject ở 
		 * hàm clickToHereLink
		 */
		
	}
	
	public RegisterPageObject clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver,LoginPageUI.HERE_LINK);
		// Cách 2: Thay vì phải khởi tạo biến ở mỗi hàm thì ta gom các khởi tạo này
		// vào trong class PageFactoryManager để dễ quản lý, rồi từ đó khi muốn dùng hàm khởi tạo 
		// nào thì ta return về hàm khởi tạo đó trong class PageFactoryManager
		return PageFactoryManager.getRegisterPage(driver);
		
		//Cách 1:return new RegisterPageObject(driver);
		/*  Ở hàm clickToHereLink() ta return về class RegisterPageObject ở Package PageObject
		 *  bởi vì điều này tương ứng với hành động khi Click lên Here_Link ở trang Login thì sẽ 
		 *  navigate đến trang Register. Hành động "return" cũng đồng nghĩa với việc ta đã khởi tạo 
		biến registerPage ở Source folder "testcases".*/
	}
	
	
}
