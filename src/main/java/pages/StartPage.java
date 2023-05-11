package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class StartPage {
        private final WebDriver driver;
        private final static String START_PAGE = "https://stellarburgers.nomoreparties.site";
        private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
        private final By loginButtonStartPage = By.xpath(".//button[text()='Войти в аккаунт']");

        private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
        private final By bunsButton = By.xpath(".//span[text() = 'Булки']");
        private final By saucesButton = By.xpath(".//span[text() = 'Соусы']");
        private final By fillingsButton = By.xpath(".//h2[text() = 'Начинки']");

        private final By bunsHeading = By.xpath(".//h2[text()='Булки']");
        private final By saucesHeading = By.xpath(".//h2[text()='Соусы']");
        private final By fillingsHeading = By.xpath(".//h2[text()='Начинки']");

        public StartPage(WebDriver driver) {
            this.driver = driver;
        }

        public StartPage openStartPage() {
            driver.get(START_PAGE);
            return this;
        }

        @Step("Клик по кнопке «Войти в аккаунт»")
        public void clickLoginButtonStartPage(WebDriver driver) {
            driver.findElement(loginButtonStartPage).click();
        }

        @Step("Клик по кнопке «Личный кабинет»")
        public void clickPersonalAccountButton(WebDriver driver) {
            driver.findElement(personalAccountButton).click();
        }

        @Step("Ожидание отображения кнопки «Оформить заказ»")
        public void waitDisplayCreateOrderButton(WebDriver driver) {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        }

        @Step("Проверка отображения кнопки «Оформить заказ»")
        public boolean isDisplayedOrderButton(WebDriver driver) {
            return driver.findElement(createOrderButton).isDisplayed();
        }

        @Step("Клик по кнопке «Соусы»")
        public void saucesButtonClick(WebDriver driver) {
            driver.findElement(saucesButton).click();
        }

        @Step("Клик по кнопке «Булки»")
        public void bunsButtonClick(WebDriver driver) {
            driver.findElement(bunsButton).click();
        }

        @Step("Клик по кнопке «Начинки»")
        public void fillingsButtonClick(WebDriver driver) {
            driver.findElement(fillingsButton).click();
        }

        @Step("Ожидание отображения кнопки «Булки»")
        public void waitDisplayBunsButton() {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(bunsHeading));
        }

        @Step("Проверка отображения кнопки «Булки»")
        public boolean isDisplayedBunsButton() {
            return driver.findElement(bunsHeading).isDisplayed();
        }

        @Step("Ожидание отображения кнопки «Соусы»")
        public void waitDisplaySaucesButton() {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(saucesHeading));
        }

        @Step("Проверка отображения кнопки «Соусы»")
        public boolean isDisplayedSaucesButton() {
            return driver.findElement(saucesHeading).isDisplayed();
        }

        @Step("Ожидание отображения кнопки «Начинки»")
        public void waitDisplayFillingsButton() {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(fillingsHeading));
        }

        @Step("Проверка отображения кнопки «Начинки»")
        public boolean isDisplayedFillingsButton() {
            return driver.findElement(fillingsHeading).isDisplayed();
        }
    }