package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPage {

    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By loginAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginInRegButton = By.xpath("//a[text()='Войти']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By logoutButton = By.xpath(".//button[(text()='Выход')]");
    private final By regButton = By.xpath("//a[text()='Зарегистрироваться']");
    private final By forgotPasswordButton = By.xpath("//a[text()='Восстановить пароль']");
    private final By regLoginButton = By.xpath("//button[text()='Войти']");
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLoginInRegButton() {
        driver.findElement(loginInRegButton).click();
    }

    public void clickRegButton() {
        driver.findElement(regButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickForgotPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(driver.findElement(regLoginButton).isDisplayed());
    }

    public void checkMakeYourBurgerIsDisplayed() {
        Assert.assertTrue(driver.findElement(makeYourBurgerHeader).isDisplayed());
    }
}