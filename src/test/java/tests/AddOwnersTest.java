package tests;

import org.testng.annotations.Test;

import pages.AddOwnersPage;
import pages.FindOwnersPage;
import pages.HomePage;
import pages.OwnerInformationPage;

public class AddOwnersTest extends TestBase {

	// Validate that user can Add Owner successfully and validate that values
	// entered successfully in right positins
	@Test(priority = 1)
	public void UserCanAddOwnerSuccessfully() {

		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		long executionTime = System.currentTimeMillis();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Hamza", ("Klein" + executionTime), "Nahria", "Tanta", "01272564239");
		OwnerInformationPage ownerInformationObject = new OwnerInformationPage(driver);
		ownerInformationObject.checkOwnerInformation("Hamza", "Klein" + executionTime, "Nahria", "Tanta",
				"01272564239");
		// Search and search result
		homeObject.openFindOwnersPage();
		findOwnerObject.searchForOwner("Klein" + executionTime);
		findOwnerObject.clickFindOwnerButton();
		ownerInformationObject.checkOwnerInformation("Hamza", "Klein" + executionTime, "Nahria", "Tanta",
				"01272564239");
	}

	// Validate that user cannot add owner in case the telephone number contains
	// strings
	@Test
	public void userCannotAddOwnerInCaseTelephoneFieldContainsStrings() {

		HomePage homeObject = new HomePage(driver);
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		AddOwnersPage test = findOwnerObject.openAddOwnerPage();
		test.setOwnerData(null, null, null, null, null);
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "dfwfefwewfwef");
		addOwnerObject.checkErrorMessages(null, null, null, null,
				"numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// Validate that user cannot add owner in case that Telephone field contain more
	// than 10 integers
	@Test
	public void userCannotAddOwnerInCaseTelephoneFieldContainsMoreThan10Intigers() {

		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("Kaln", "Maln", "swrwrwrg", "ffwfeffwe", "01265786543289765");
		addOwnerObject.checkErrorMessages(null, null, null, null,
				"numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// Validate that user cannot add user in case that required fields are blank
	@Test
	public void userCannotAddOwnerInCaseThatRequiredFieldsAreBalnk() {
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("", "", "", "", "");
		addOwnerObject.checkErrorMessages("must not be empty", "must not be empty", "must not be empty",
				"must not be empty", "numeric value out of bounds (<10 digits>.<0 digits> expected)");
	}

	// Validate that Error message displays in cases that first name is blank and no
	// Error messages display in other fields in case they are not blank using
	// throws Exception and reading the description of exception
	@Test
	public void validateThatErrorMesssageDisplayInFirstNameButNotOnOtherFieldsUsingThrowsExceptionAndReadingExceptionName()
			throws Exception {
		HomePage homeObject = new HomePage(driver);
		homeObject.openFindOwnersPage();
		FindOwnersPage findOwnerObject = new FindOwnersPage(driver);
		findOwnerObject.openAddOwnerPage();
		AddOwnersPage addOwnerObject = new AddOwnersPage(driver);
		addOwnerObject.setOwnerData("", "rffr47", "gewrggere", "gwgrgre", "987654");
		addOwnerObject.checkErrorMessages("must not be empty", null, null, null, null);
	}

}
