package IBAR;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import IBARPageObjects.MyHomePage;
import MySteps.CrossBrowser;
import IBARPageObjects.LoggerHelper;
public class MySteps {

	public static WebDriver driver;
	Logger log = LoggerHelper.getLogger(IBAR.MySteps.class);

	@Before
	@Parameters("")
	public void StartUp() {
		log.info("before method is started");
		CrossBrowser choosBrowser = new CrossBrowser();
		driver = choosBrowser.setup("chrome");
		log.info("before method is finish");
	}

	@After
	public void tearDown() {

		 driver.close();
		// driver.quit();
	}

	@Given("^Navigate to IBAR webpage$")
	public void navigate_to_IBAR_webpage() throws Throwable {

		log.info("given schenaryo start");
		MyHomePage homePage = new MyHomePage(driver);
		driver.navigate().to("https://www.ibar.az/en/");
		homePage.waitUntil(homePage.popUp);
		if (homePage.popUp.isDisplayed()) {
			homePage.waitUntil(homePage.popUp);
			homePage.popUp.click();
		}
	}

	@Then("^see the page in \"([^\"]*)\" language$")
	public void see_the_page_in_language(String language) throws Throwable {
		MyHomePage homePage = new MyHomePage(driver);

		if (language.contains("AZ")) {
			homePage.azLanguage.click();
			homePage.waitUntil(homePage.azLanguagelogo);
			homePage.popUp.click();
			Assert.assertEquals(true, homePage.azLanguagelogo.isDisplayed());

		}

		else if (language.contains("RU")) {

			homePage.ruLanguage.click();
			homePage.popUp.click();
			homePage.waitUntil(homePage.ruLanguagelogo);
			Assert.assertEquals(true, homePage.ruLanguagelogo.isDisplayed());

		} else if (language.contains("EN")) {

			homePage.enLanguage.click();
			homePage.popUp.click();
			homePage.waitUntil(homePage.enLanguagelogo);
			Assert.assertEquals(true, homePage.enLanguagelogo.isDisplayed());
			System.out.print("44444444");
		}
	}

	@Given("^User types \"([^\"]*)\" to search area$")
	public void user_types_to_search_area(String arg1) throws Throwable {
		MyHomePage homePage = new MyHomePage(driver);
		homePage.searchArea.click();
		homePage.searchArea.sendKeys(arg1);
	}

	@Then("^Verify there are displayed two card options$")
	public void verify_there_are_displayed_two_card_options() throws Throwable {

		MyHomePage homePage = new MyHomePage(driver);
		Thread.sleep(10000);
		int americanExpressCardNumber = homePage.americanExpressCardNumber.size();
		assertEquals(4, americanExpressCardNumber);
	}

	@Given("^User clicks Order credit online button$")
	public void user_clicks_Order_credit_online_button() throws Throwable {
		MyHomePage homePage = new MyHomePage(driver);
		homePage.orderCreditOnline.click();

	}

	@Then("^Verify user is navigated to a new page with the urgent credit order form$")
	public void verify_user_is_navigated_to_a_new_page_with_the_urgent_credit_order_form() throws Throwable {
		MyHomePage homePage = new MyHomePage(driver);
		homePage.waitUntil(homePage.urgentLoanOrderWebPage);
		Assert.assertEquals(true, homePage.urgentLoanOrderWebPage.isDisplayed());

	}

	@Given("^When the user attempts to submit a form which has form fields that have not been completed see form field validation error messages$")
	public void when_the_user_attempts_to_submit_a_form_which_has_form_fields_that_have_not_been_completed_see_form_field_validation_error_messages() throws Throwable {
		
		MyHomePage homePage = new MyHomePage(driver);
		homePage.submitButton.click();
		Assert.assertEquals(true, homePage.validationErroMessageForNameField.isDisplayed());
		Assert.assertEquals(true, homePage.validationErroMessageForSurnameField.isDisplayed());
		Assert.assertEquals(true, homePage.validationErroMessageForPhoneField.isDisplayed());

	}

}
