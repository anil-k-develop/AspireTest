package example.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * The Class represents ProductsPage.
 *
 * @author Anil
 */
public class ManufacturingOrdersPage extends BasePage {

	/** The Products feature */
	@FindBy(xpath = "(//span[contains(text(), 'Manufacturing Orders')])[1]")
	public WebElement manufacturingOrdersText;

	@FindBy(xpath = "//button[@data-original-title='Create record']")
	public WebElement manufacturingOrdersCreateButton;

	@FindBy(xpath = "//button[@title='Save record']")
	public WebElement manufacturingOrdersSaveRecordButton;

	@FindBy(xpath = "(//div[@class='o_input_dropdown'])[1]//input")
	public WebElement newOrderProductName;

	@FindBy(xpath = "(//div[@class='o_input_dropdown'])[1]")
	public WebElement newOrderProductNameDropDown;

	@FindBy(xpath = "//button[@name='action_confirm']")
	public WebElement confirmOrder;

	@FindBy(xpath = "(//button//span[contains(text(), 'Mark as Done')])[2]")
	public WebElement markAsDone;

	@FindBy(xpath = "//button//span[contains(text(), 'Apply')]")
	public WebElement confirmationApply;

	@FindBy(xpath = "//button//span[contains(text(), 'Ok')]")
	public WebElement confirmationOk;

	@FindBy(xpath = "//button[@title='Current state' and contains(text(), 'Done')]")
	public WebElement currentStatusDone;

	@FindBy(xpath = "//a[@name='product_id']")
	public WebElement createdProductName;


	/**
	 * Instantiates a new aspire app login page.
	 *
	 * @param driver the driver
	 */
	public ManufacturingOrdersPage(WebDriver driver) {
		super(driver);
	}

	public void setProductName(String productName) throws InterruptedException {
		newOrderProductNameDropDown.click();
		Thread.sleep(1000);
		newOrderProductName.sendKeys(productName);
		Thread.sleep(1000);
		newOrderProductName.sendKeys(Keys.TAB);
	}

}
