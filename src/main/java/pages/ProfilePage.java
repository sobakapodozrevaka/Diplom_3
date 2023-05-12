package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By constructorButton = By.xpath("//p[text() = 'Конструктор']");
    private By logoSite = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка отображения кнопки «Выход»")
    public boolean isDisplayedLogoutButton(WebDriver driver) {
        return driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Ожидание отображения кнопки «Выход»")
    public void waitDisplayLogoutButton(WebDriver driver){
        new WebDriverWait(this.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        this.driver.findElement(logoutButton).isDisplayed();
    }

    @Step("Клик по кнопке «Выход»")
    public void clickLogoutButton(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

   @Step("Клик по кнопке «Конструктор»")
        public void clickConstructorButton(WebDriver driver) {

        driver.findElement(constructorButton).click();
        }

    @Step("Клик по кнопке лого сайта")
    public void clickLogoSite(WebDriver driver) {

        driver.findElement(logoSite).click();
    }

    }