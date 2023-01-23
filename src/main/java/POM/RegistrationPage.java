package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends MainPage {

    private final By regName = By.xpath("//fieldset[1]//input");
    private final By regEmail = By.xpath("//fieldset[2]//input");
    private final By regPassword = By.xpath("//fieldset[3]//input");
    private final By shortPasswordError = By.xpath("//p[text()='Некорректный пароль']");
    private final By regAccountButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openRegPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    public void clickRegAccountButton() {
        driver.findElement(regAccountButton).click();
    }

    public void regDataField(String name, String email, String password) {
        driver.findElement(regName).sendKeys(name);
        driver.findElement(regEmail).sendKeys(email);
        driver.findElement(regPassword).sendKeys(password);
    }

    public String getTextPasswordError() {
        return driver.findElement(shortPasswordError).getText();
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
    }
}