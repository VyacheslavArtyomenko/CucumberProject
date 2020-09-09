package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {

    private By createIssueButton = By.id("create_link");
    private By tempWindowIssueCreated = By.xpath("//*[contains(@class,'aui-will-close')]");

    public void navigateToHomePage() {
        WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public boolean onPage(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(By.id("browse_link"))).isDisplayed();
    }

    public void clickCreateIssue(){
       WebDriverFactory.getDriver().findElement(createIssueButton).click();
    }

    public boolean isIssueCreated() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tempWindowIssueCreated)).isDisplayed()
                && WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(@class,'aui-will-close')]")).getText().contains("WEBINAR");
    }
}