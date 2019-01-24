package pageUIs;

public class LoginPageUI {
	// Get hết tất cả các locator trong trang Login
	public static final String USERID_TEXTBOX = "//input[@name='uid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String LOGIN_BUTTON = "//input[@name='btnLogin']";
	public static final String HERE_LINK = "//a[text()='here']";
	// biến thông thường : phải khởi tạo class lên rồi mới truy cập vào đc biến này
  	// => Ví Dụ: khởi tạo abstractPage = new AbstractPage();	
    // static: biến tĩnh (ko cần khởi tạo mà vẫn có thể truy cập được)
    // final: nếu đã gán giá trị cho biến rồi thì ko cho phép gán lại giá trị mới cho biến này ở class kế thừa khác nữa
	
}
