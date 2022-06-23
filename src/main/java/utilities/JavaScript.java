package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {

	static WebDriver driver;

	// **Java Script Method for Checking Validation Msg that is not present in Dom**
	public static boolean javaScript_ValidatMsg(By elmentBy) {
		WebElement ele = driver.findElement(elmentBy);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", ele);
		return isValidInput;
	}
}
