import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pom.RegistrationPage;
import user.AuthUser;
import user.CreateUser;
import api.ApiMethods;

import static user.CreateUser.createUser;
import static user.CreateUser.createUserWithWrongPassword;

public class RegistrationTest extends driverConfig {

    CreateUser createUser = new CreateUser();
    CreateUser createUserWithWrongPassword = new CreateUser();
    ApiMethods user = new ApiMethods();

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
    @DisplayName("Тест регистрации пользователя с корректными данными")
    public void newUserRegistrationTest() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createUser = createUser();
        registrationPage.openRegPage();
        registrationPage.regDataField(createUser.getName(), createUser.getEmail(), createUser.getPassword());
        registrationPage.clickRegAccountButton();
        registrationPage.checkLoginButtonIsDisplayed();
    }

    @Test
    @DisplayName("Тест регистрации пользователя с некорректным паролем")
    public void newUserRegistrationWithIncorrectPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(webDriver);
        createUserWithWrongPassword = createUserWithWrongPassword();
        user.createUser(createUserWithWrongPassword);
        registrationPage.openRegPage();
        registrationPage.regDataField(createUserWithWrongPassword.getName(), createUserWithWrongPassword.getEmail(), createUserWithWrongPassword.getPassword());
        registrationPage.clickRegAccountButton();
        Assert.assertEquals("Некорректный пароль", registrationPage.getTextPasswordError());
    }

}