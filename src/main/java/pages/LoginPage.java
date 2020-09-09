package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class LoginPage {

    private By userNameInput = By.id("login-form-username");
    private By passwordInput = By.id("login-form-password");
    private By loginButton = By.id("login");

    public void enterUsername(String name) {
        WebDriverFactory.getDriver().findElement(userNameInput).clear();
        WebDriverFactory.getDriver().findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        WebDriverFactory.getDriver().findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        WebDriverFactory.getDriver().findElement(loginButton).click();
    }

}