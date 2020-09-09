package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import pages.CreateIssueWindow;
import utils.WebDriverFactory;
import java.io.File;
import java.io.IOException;


public class StepDefinitions {

    @Before
    public void beforeCucumberScenario(Scenario scenario) {
        WebDriverFactory.createInstance("Chrome");
    }

    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.getDriver().close();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }

    @Then("^I navigate to Jira Login Page$")
    public void navigateToLoginPage() {
        new HomePage().navigateToHomePage();
    }

    @Then("^I enter username - \"(.*?)\"$")
    public void enterUserName(String userName) {
        new LoginPage().enterUsername(userName);
    }

    @Then("^I enter password - \"(.*?)\"$")
    public void enterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("^I click on the login button$")
    public void clickLoginButton() {
        new LoginPage().clickLoginButton();
    }

    @When("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @When("^I debug$")
    public void debug() {
        int a = 0;
    }

    //-----------------------------------------------------------------------------------

    @Given("^I proceeded to the Home Page$")
    public void navigateToHomePage() {
        new HomePage().navigateToHomePage();
    }

    @When("^I click on the create button$")
    public void clickCreateIssue() {
        new HomePage().clickCreateIssue();
    }

    @Then("^i fill all manatory fields$")
    public void fillAllMandatoryFields() {
        new CreateIssueWindow().clearProjectField();
        new CreateIssueWindow().enterProjectField("Webinar");
        new CreateIssueWindow().pressTabAfterProjectField();

        new CreateIssueWindow().clearIssueTypeField();
        new CreateIssueWindow().enterIssueTypeField("Task");
        new CreateIssueWindow().pressTabAfterIssueTypeField();

        new CreateIssueWindow().enterSummary("One more test summary");
        new CreateIssueWindow().clearReporterField();
        new CreateIssueWindow().enterReporterField("VyacheslavArtyomenko");

        new CreateIssueWindow().pressCreateIssueButton();
    }

    @Then("^the issue number is shown$")
    public void isIssueCreated() {
        Assert.assertTrue(new HomePage().isIssueCreated());
    }
}