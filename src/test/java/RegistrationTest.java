import api.Credentials;
import api.User;
import api.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.StartPage;
import pages.RegisterPage;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private WebDriver driver;
    private User user;
    private UserMethods userMethods;
    private Credentials credentials;
    private String accessToken;


    private String name = "Klaasje";
    private String email = "MissOrania@ya.ru";
    private String password = "DiscoDancer";

    @Before
    public void setUp() {
        driver = createWebDriver();
        userMethods = new UserMethods();
        user = new User(name, email, password);
    }

    @After
    public void cleanUp() {
        driver.quit();
        accessToken = userMethods.login(credentials.from(user)).extract().path("accessToken");
        if (accessToken != null) {
            userMethods.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка регистрации с корректными данными")
    public void registrationUserTest() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        startPage.openStartPage();
        startPage.clickPersonalAccountButton(driver);
        loginPage.clickRegisterButtonLoginPage(driver);
        registerPage.registrationUser(driver, name, email, password);
        loginPage.waitDisplayLoginButton(driver);
        loginPage.authorizationUser(driver, email, password);
        startPage.waitDisplayCreateOrderButton(driver);
        assertTrue("Кнопка «Оформить заказ» не отображается", startPage.isDisplayedOrderButton(driver));
    }

    @Test
    @DisplayName("Проверка регистрации с некорректным паролем")
    public void registrationIncorrectPasswordUserTest() {
        String password = "123";
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        startPage.openStartPage();
        startPage.clickPersonalAccountButton(driver);
        loginPage.clickRegisterButtonLoginPage(driver);
        registerPage.registrationUser(driver, name, email, password);
        assertTrue("Ошибка «Некорректный пароль не отображается»", registerPage.isErrorPasswordDisplayed(driver));
    }

}
