import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.StartPage;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;


public class ConstructorTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        driver = createWebDriver();
    }
    @After
    public void cleanUp() {
        driver.quit();
        }

    @Test
    @DisplayName("Проверка выбора раздела «Начинки»")
    public void chooseFillingsTest() {
        StartPage startPage = new StartPage(driver);
        startPage.openStartPage();
        startPage.fillingsButtonClick(driver);
        startPage.waitDisplayFillingsButton();
        assertTrue("Кнопка выбора раздела «Начинки» не работает", startPage.isDisplayedFillingsButton());

    }
    @Test
    @DisplayName("Проверка выбора раздела «Соусы»")
    public void chooseSaucesTest() {
        StartPage startPage = new StartPage(driver);
        startPage.openStartPage();
        startPage.saucesButtonClick(driver);
        startPage.waitDisplaySaucesButton();
        assertTrue("Кнопка выбора раздела «Соусы» не работает",  startPage.isDisplayedSaucesButton());
    }


    @Test
    @DisplayName("Проверка выбора раздела «Булки»")
    public void chooseBunsTest() {
        StartPage startPage = new StartPage(driver);
        startPage.openStartPage();
        startPage.saucesButtonClick(driver);
        startPage.waitDisplaySaucesButton();
        startPage.bunsButtonClick(driver);
        startPage.waitDisplayBunsButton();
        assertTrue("Кнопка выбора раздела «Булки» не работает", startPage.isDisplayedBunsButton());
    }

}
