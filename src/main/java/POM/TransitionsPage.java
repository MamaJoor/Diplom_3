package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransitionsPage extends MainPage {

    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By constructorButton = By.xpath(".//p[(text()='Конструктор')]");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");
    private final By makeYourBurgerHeader = By.xpath("//h1[text()='Соберите бургер']");

    public TransitionsPage(WebDriver driver) {
        super(driver);
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickLogo() {
        driver.findElement(stellarBurgerLogo).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void checkMakeYourBurgerIsDisplayed() {
        Assert.assertTrue(driver.findElement(makeYourBurgerHeader).isDisplayed());
    }

    public void checkLoginButtonIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed());
    }
}