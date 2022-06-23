package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewVisitPage extends PageBase {

	public NewVisitPage(WebDriver driver) {
		super(driver);
	}

	// Elements
	private By dateTxtBox = By.id("date");
	private By descriptionTxtBox = By.id("description");
	private By addVisitBtN = By.xpath("//button[@type='submit' ]");

	// Error messages
	private By dateErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[1]/div/span[@class = 'help-inline']");
	private By dCErrorMsg = By
			.xpath("//div[@class='container-fluid']/div/form/div/div[2]/div/span[@class = 'help-inline']");

	// Add visit with valid data while date is dynamic and incremented automatically
	public void addVisit(String expectedDescription) {
		clearText(dateTxtBox);
		setTextElementText(dateTxtBox, addMoreYear(1));
		setTextElementText(descriptionTxtBox, expectedDescription);
		clickButton(addVisitBtN);
	}

	// Cannot Add visit while Date Format isnot correct
	public void addVisitDFNotCorrect(String expectedDate, String expectedDescription) {
		clearText(dateTxtBox);
		setTextElementText(dateTxtBox, expectedDate);
		setTextElementText(descriptionTxtBox, expectedDescription);
		clickButton(addVisitBtN);
	}

	public void checkErrorMSgs(String expectedDateError, String expectedCsErrorMsg) {
		if (expectedDateError != null) {
			String actualErrorMsg = driver.findElement(dateErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedDateError));
		} else {
			List<WebElement> foundElements = driver.findElements(dateErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}
		if (expectedCsErrorMsg != null) {
			String actualErrorMsg = driver.findElement(dCErrorMsg).getText();
			Assert.assertTrue(actualErrorMsg.contains(expectedCsErrorMsg));
		} else {
			List<WebElement> foundElements = driver.findElements(dCErrorMsg);
			Assert.assertEquals(foundElements.size(), 0);
		}
		if (jSErrorMsg(dateTxtBox)) {
			System.out.println("The entered data are valid");
		} else {
			System.out.println("The entered data are invalid");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println((String) js.executeScript("return arguments[0].validationMessage;",
					(driver.findElement(dateTxtBox))));
		}
	}

}
