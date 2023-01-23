import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import pom.ConstructorTransitionsPage;

public class ConstructorTransitionsTest extends driverConfig {

    @Test
    @DisplayName("Тест перехода к разделу «Булки»")
    public void bunsTransitionTest() {
        ConstructorTransitionsPage constructorTransitionsPage = new ConstructorTransitionsPage(webDriver);
        constructorTransitionsPage.clickSauceSection();
        constructorTransitionsPage.clickBunSection();
        Assert.assertEquals("Булки", constructorTransitionsPage.textFromActiveSection());
    }

    @Test
    @DisplayName("Тест перехода к разделу «Соусы»")
    public void saucesTransitionTest() {
        ConstructorTransitionsPage constructorTransitionsPage = new ConstructorTransitionsPage(webDriver);
        constructorTransitionsPage.clickSauceSection();
        Assert.assertEquals("Соусы", constructorTransitionsPage.textFromActiveSection());
    }

    @Test
    @DisplayName("Тест перехода к разделу «Начинки»")
    public void toppingsTransitionTest() {
        ConstructorTransitionsPage constructorTransitionsPage = new ConstructorTransitionsPage(webDriver);
        constructorTransitionsPage.clickToppingSection();
        Assert.assertEquals("Начинки", constructorTransitionsPage.textFromActiveSection());
    }
}