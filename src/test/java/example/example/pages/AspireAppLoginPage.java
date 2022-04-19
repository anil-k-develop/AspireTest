package example.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The Class represents AspireAppLoginPage.
 *
 * @author Anil
 */
public class AspireAppLoginPage extends BasePage {

	/** The email input. */
	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailInput;

	/** The password. */
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement pass;


	/**
	 * Instantiates a new aspire app login page.
	 *
	 * @param driver the driver
	 */
	public AspireAppLoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Enter email.
	 *
	 * @param email the email
	 * @return the aspire login page
	 */
	public AspireAppLoginPage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	/**
	 * Enter password.
	 *
	 * @param password the password
	 * @return the facebook login page
	 */
	public AspireAppLoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	/**
	 * Click sign in.
	 */
	public void clickSignIn() {
		pass.submit();
	}
}
