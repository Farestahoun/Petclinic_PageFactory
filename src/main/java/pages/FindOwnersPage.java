package pages;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FindOwnersPage extends PageBase {

	public FindOwnersPage(WebDriver driver) {
		super(driver);
	}

	By addOwnerbutton = By.xpath("//a[contains(text(),'Add Owner')]");
	By searchBox = By.xpath("//input[@name='lastName']");
	By findOwnerButton = By.xpath("//button[@type='submit']");

	private By searchErrorMessage = By.xpath("//span/div/p");

	public AddOwnersPage openAddOwnerPage() {
		clickButton(addOwnerbutton);
		return new AddOwnersPage(driver);
	}

	public void searchForOwner(String ownerName) {
		setTextElementText(searchBox, ownerName);

	}

	public void clickFindOwnerButton()

	{
		clickButton(findOwnerButton);
	}

	public void checkSearchErrorMsg(String ErrorMsg) {
		String actualErrorMsg = driver.findElement(searchErrorMessage).getText();
		Assert.assertTrue(actualErrorMsg.contains(ErrorMsg));
	}
}
