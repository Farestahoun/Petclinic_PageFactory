package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitTestBase {

	public static WebDriver driver;
	public WebDriverWait wait;

	public void fsagg(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	public static String dynamicTableHandle(String key) {
		String xpath = "//table[@id='myTable']/tbody/tr[5]/td[count(//table[@id='myTable']/tbody/tr/th[text()='" + key
				+ "']/preceding-sibling::th)+1]";
		return xpath;
	}

	@Test(enabled = false)
	public void testFares() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/howto/howto_js_filter_table.asp");
		if (driver.findElement(By.id("accept-choices")).isDisplayed()) {
			driver.findElement(By.id("accept-choices")).click();
		}
		driver.findElement(By.id("myInput")).sendKeys("koniglich");
		assertTrue(driver.findElement(By.xpath(dynamicTableHandle("Name"))).getText().equals("Koniglich Essen"));
		driver.quit();

	}

	public static void selectDropDownList2(String condition, String value, int index) {

		Select options = new Select(driver.findElement(By.id("dropdown")));
		if (condition == "text") {
			options.selectByVisibleText(value);
		} else if (condition == "index") {
			options.selectByIndex(index);
		} else if (condition == "value") {
			options.selectByValue(value);
		} else {
			Assert.fail("ya a7a The entered option for choosing in DropDown menu is false");
		}

	}

	@Test
	public void testx() throws InterruptedException {

		selectDropDownList2("value", "2", 0);

	}

}
