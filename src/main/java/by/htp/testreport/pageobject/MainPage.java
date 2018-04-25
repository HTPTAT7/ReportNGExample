package by.htp.testreport.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

	public static final String URL = "https://mail.ru/";

	// Error with id!
	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passField;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/form/div[2]/div[2]/label/input")
	private WebElement submit;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MailBoxPage login(String login, String pass) {
		loginField.sendKeys(login);
		passField.sendKeys(pass);
		submit.click();
		return new MailBoxPage(driver);
	}

}
