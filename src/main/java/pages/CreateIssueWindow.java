package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

public class CreateIssueWindow {

    private By projectField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By createIssueButton = By.id("create-issue-submit");

    private boolean isProjectFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("project-field"))).isDisplayed();
    }

    public void clearProjectField() {
        isProjectFieldDisplayed();
        WebDriverFactory.getDriver().findElement(projectField).clear();
    }

    public void enterProjectField(String text) {
        WebDriverFactory.getDriver().findElement(projectField).sendKeys(text);
    }

    public void pressTabAfterProjectField() {
        WebDriverFactory.getDriver().findElement(projectField).sendKeys(Keys.TAB);
    }

    private boolean isIssueTypeFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("issuetype-field"))).isDisplayed();
    }

    public void clearIssueTypeField() {
        isIssueTypeFieldDisplayed();
        WebDriverFactory.getDriver().findElement(issueTypeField).clear();
    }

    public void enterIssueTypeField(String text) {
        WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(text);
    }

    public void pressTabAfterIssueTypeField() {
        WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(Keys.TAB);
    }

    private boolean isSummaryFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("summary"))).isDisplayed();
    }

    public void enterSummary(String text) {
        isSummaryFieldDisplayed();
        WebDriverFactory.getDriver().findElement(summaryField).sendKeys(text);
    }

    public void clearReporterField() {
        WebDriverFactory.getDriver().findElement(reporterField).clear();
    }

    public void enterReporterField(String text) {
        WebDriverFactory.getDriver().findElement(reporterField).sendKeys(text);
    }

    public void pressCreateIssueButton() {
        WebDriverFactory.getDriver().findElement(createIssueButton).click();
    }

}
