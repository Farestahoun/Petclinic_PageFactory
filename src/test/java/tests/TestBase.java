package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Screenshot;

// in TestBase we initialize the driver, opening an closing the driver and handling more than drivers  
// All clases in tests should inherit from TestBase

public class TestBase {

	public static WebDriver driver;

	// initialize the driver
	@BeforeSuite
	public void startDriver() {

		// System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.navigate().to("http://localhost:9099/");
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

	// Take screenshot when test case fail and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot......");
			Screenshot.captureSrennshot(driver, result.getName());
		}
	}
}
