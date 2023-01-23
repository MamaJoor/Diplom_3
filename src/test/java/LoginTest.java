import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pom.LoginPage;
import user.AuthUser;
import user.CreateUser;
import api.ApiMethods;

import java.time.Duration;

import static user.CreateUser.createUser;

public class LoginTest extends driverConfig {
    CreateUser createUser = new CreateUser();
    ApiMethods user = new ApiMethods();
    LoginPage loginPage;

    @Before
    public void setUp() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(webDriver);
        createUser = createUser();
        user.createUser(createUser);
    }

    @After
    public void removeUser() {
        ApiMethods user = new ApiMethods();
        AuthUser authUser = new AuthUser();
        Response response = user.authUser(authUser);
        String accessToken = response
                .then()
                .extract()
                .path("accessToken");

        if (accessToken != null) {
            user.removeUser(accessToken);
        }
    }

    @Test
    @DisplayName("Тест входа по кнопке «Войти в аккаунт» на главной")
    public void loginWithMainButtonTest() {
        loginPage.clickLoginAccountButton();
        loginPage.setEmailField(createUser.getEmail());
        loginPage.setPasswordField(createUser.getPassword());
        loginPage.clickLoginButton();
        loginPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест входа через кнопку «Личный кабинет»")
    public void loginWithPersonalAccountButtonTest() {
        loginPage.clickPersonalAccountButton();
        loginPage.setEmailField(createUser.getEmail());
        loginPage.setPasswordField(createUser.getPassword());
        loginPage.clickLoginButton();
        loginPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест входа через кнопку в форме регистрации")
    public void loginWithRegistrationFormTest() {
        loginPage.clickPersonalAccountButton();
        loginPage.clickRegButton();
        loginPage.clickLoginInRegButton();
        loginPage.setEmailField(createUser.getEmail());
        loginPage.setPasswordField(createUser.getPassword());
        loginPage.clickLoginButton();
        loginPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест входа через кнопку в форме восстановления пароля")
    public void loginWithRecoverPasswordPageTest() {
        loginPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordButton();
        loginPage.clickLoginInRegButton();
        loginPage.setEmailField(createUser.getEmail());
        loginPage.setPasswordField(createUser.getPassword());
        loginPage.clickLoginButton();
        loginPage.checkMakeYourBurgerIsDisplayed();
    }

    @Test
    @DisplayName("Тест входа и выхода через личный кабинет")
    public void loginAndLogoutTest() {
        loginPage.clickPersonalAccountButton();
        loginPage.setEmailField(createUser.getEmail());
        loginPage.setPasswordField(createUser.getPassword());
        loginPage.clickLoginButton();
        loginPage.clickPersonalAccountButton();
        webDriver.get("http://stellarburgers.nomoreparties.site/");
        loginPage.clickPersonalAccountButton();
        loginPage.clickLogoutButton();
        loginPage.checkLoginButtonIsDisplayed();
    }
}