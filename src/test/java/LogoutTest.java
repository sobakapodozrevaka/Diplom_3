import api.Credentials;
import api.User;
import api.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProfilePage;
import pages.StartPage;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class LogoutTest {
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

    @After
    public void cleanUp() {
        driver.quit();
        accessToken = userMethods.login(credentials.from(user)).extract().path("accessToken");
        if (accessToken != null) {
            userMethods.delete(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка на выход из личного кабинета")
    public void logoutTest() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        startPage.openStartPage();
        startPage.clickLoginButtonStartPage(driver);
        loginPage.authorizationUser(driver, email, password);
        startPage.clickPersonalAccountButton(driver);
        profilePage.clickLogoutButton(driver);
        loginPage.waitDisplayLoginButton(driver);
        assertTrue("Кнопка «Войти» не отображается",loginPage.isDisplayedLoginButton(driver));
    }

    }