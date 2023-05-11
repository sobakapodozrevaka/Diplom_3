import api.Credentials;
import api.User;
import api.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.StartPage;
import pages.RegisterPage;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest {

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
        accessToken = userMethods.create(user).extract().path("accessToken");
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку «Личный кабинет»")
    public void loginPersonalAccountButtonTest() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        startPage.openStartPage();
        startPage.clickPersonalAccountButton(driver);
        loginPage.authorizationUser(driver, email, password);
        startPage.waitDisplayCreateOrderButton(driver);
        assertTrue("Кнопка «Оформить заказ» не отображается", startPage.isDisplayedOrderButton(driver));
    }
        @Test
        @DisplayName("Проверка авторизации через кнопку «Войти» на стартовой страницы")
        public void loginOnStartPageTest(){
            StartPage startPage = new StartPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            startPage.openStartPage();
            startPage.clickLoginButtonStartPage(driver);
            loginPage.authorizationUser(driver, email, password);
            startPage.waitDisplayCreateOrderButton(driver);
            assertTrue("Кнопка «Оформить заказ» не отображается", startPage.isDisplayedOrderButton(driver));
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку «Войти» в странице регистрации")
    public void loginOnRegisterPageTest(){
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        startPage.openStartPage();
        startPage.clickPersonalAccountButton(driver);
        loginPage.clickRegisterButtonLoginPage(driver);
        registerPage.clickLoginButtonRegisterPage(driver);
        loginPage.authorizationUser(driver, email, password);
        startPage.waitDisplayCreateOrderButton(driver);
        assertTrue("Кнопка «Оформить заказ» не отображается", startPage.isDisplayedOrderButton(driver));
    }

    @Test
    @DisplayName("Проверка авторизации через кнопку «Войти» на странице восстановления пароля")
    public void loginOnRestoreForgPagTest(){
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        startPage.openStartPage();
        startPage.clickPersonalAccountButton(driver);
        loginPage.clickRecoverButtonLoginPage(driver);
        forgotPasswordPage.clickLoginButtonForgotPassPage(driver);
        loginPage.authorizationUser(driver, email, password);
        startPage.waitDisplayCreateOrderButton(driver);
        assertTrue("Кнопка «Оформить заказ» не отображается", startPage.isDisplayedOrderButton(driver));
    }

    @After
    public void cleanUp() {
        driver.quit();
        accessToken = userMethods.login(credentials.from(user)).extract().path("accessToken");
        if (accessToken != null) {
            userMethods.delete(accessToken);
        }
    }
}