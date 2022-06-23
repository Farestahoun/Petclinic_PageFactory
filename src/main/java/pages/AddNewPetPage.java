package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddNewPetPage extends PageBase {

	public WebDriverWait wait;

	// *********Constructor*********
	public AddNewPetPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	private By nameTxtBox = By.id("name");
	private By birthDateTxtBox = By.id("birthDate");
	private By dropDownList = By.id("type");
	private By addPetBtn = By.xpath("//button[@type='submit' and @class='btn btn-default' ]");
	private By nameErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[2]/div/span[@class = 'help-inline']");
	private By bDErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[3]/div/span[@class = 'help-inline']");

	// *********Page Methods*********
	public void addPet(String name, String birthDate, String type) {
		// Enter Username(Email)
		setTextElementText(nameTxtBox, name);
		// Enter BirthDate
		setTextElementText(birthDateTxtBox, birthDate);
		// Select Visible Text from Dropdownlist
		selectDropDownList(dropDownList, type);
		// Click Add Button
		clickButton(addPetBtn);

	}

	// Veriy Name and BirthDate Conditions
	public void checkErrorMsgs(String expectedErrorName, String expectedErrorBD) {
		if (expectedErrorName != null) {
			String actualErrorMsg = driver.findElement(nameErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedErrorName));
		} else {
			List<WebElement> foundElements = driver.findElements(nameErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}
		if (expectedErrorBD != null) {
			String actualErrorMsg = driver.findElement(bDErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedErrorBD));

		} else {
			List<WebElement> foundElements = driver.findElements(bDErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}

		if (jSErrorMsg(birthDateTxtBox)) {
			System.out.println("The entered data are valid");
		} else {
			System.out.println("The entered data are invalid");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println((String) js.executeScript("return arguments[0].validationMessage;",
					(driver.findElement(birthDateTxtBox))));
		}
	}
}
