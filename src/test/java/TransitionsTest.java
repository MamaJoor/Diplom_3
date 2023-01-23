import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pom.TransitionsPage;

public class TransitionsTest extends driverConfig {

    @Test
    @DisplayName("Тест перехода из личного кабинета в конструктор по надписи конструктор")
    public void transitionPersonalAccountToConstructorTest() {
        TransitionsPage transitionsPage = new TransitionsPage(webDriver);
        transitionsPage.clickPersonalAccountButton();
        transitionsPage.clickConstructorButton();
        transitionsPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест перехода из личного кабинета в конструктор по лого")
    public void transitionLogoToConstructorTest() {
        TransitionsPage transitionsPage = new TransitionsPage(webDriver);
        transitionsPage.clickPersonalAccountButton();
        transitionsPage.clickLogo();
        transitionsPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест перехода в личный кабинет")
    public void transitionToPersonalAccountTest() {
        TransitionsPage transitionsPage = new TransitionsPage(webDriver);
        transitionsPage.clickPersonalAccountButton();
        transitionsPage.checkLoginButtonIsDisplayed();
    }
}