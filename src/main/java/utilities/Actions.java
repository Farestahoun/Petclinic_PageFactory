package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Actions {

	static WebDriver driver;

	// *********Send Keys*********
	public static void sendKeys(By elementBy, String text) {
		driver.findElement(elementBy).clear();
		driver.findElement(elementBy).sendKeys(text);
	}

	// *********Click*********
	public static void click(By elementBy) {
		driver.findElement(elementBy).click();
	}
}
