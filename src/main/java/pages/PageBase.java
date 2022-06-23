package pages;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	public static WebDriver driver;

	// Create parametarized Constructor with (WebDriver driver) to avoid repeating
	// instalizing driver in the objects
	// All pages in pages should inherit from PageBase
	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
	}

	// Method for Click. It take WebElemnt. It will be called in the page object in
	// case that i want to click
	// It will better to be public and static
	public static void clickButton(By elementBy) {
		driver.findElement(elementBy).click();
	}

	// Method for Sendkeys. It take WebElement and Value. It will be called in the
	// page object in case that i want to click
	protected static void setTextElementText(By elementBy, String text) {
		driver.findElement(elementBy).sendKeys(text);
	}

	// Clear Msethod
	protected static void clearText(By elementBy) {
		driver.findElement(elementBy).clear();
	}

	// Select Dropdownlist method
	protected static void selectDropDownList(By elementBy, String visibleTxt) {
		Select type = new Select(driver.findElement(elementBy));
		type.selectByVisibleText(visibleTxt);
	}

	// Method to get current Date and increment year.
	public String addMoreYear(int plus) {
		LocalDate localDate = LocalDate.now();
		return LocalDate.parse(localDate.toString()).plusYears(plus).toString();
	}

	// JavaScript code to find validation message that is not found in Dom
	public static boolean jSErrorMsg(By elmentBy) {
		WebElement ele = driver.findElement(elmentBy);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", ele);
		return isValidInput;
	}

}
