package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private final By registerButtonRegisterPage = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButtonRegisterPage = By.xpath(".//a[text()='Войти']");

    private final By nameRegisterPage = By.xpath(".//fieldset[1]//input");
    private final By emailRegisterPage = By.xpath(".//fieldset[2]//input");
    private final By passwordRegisterPage = By.xpath(".//fieldset[3]//input");

    private final By errorInvalidPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод данных в поле «Имя»")
    public void setNameRegisterPage(WebDriver driver, String name) {
        driver.findElement(nameRegisterPage).click();
        driver.findElement(nameRegisterPage).sendKeys(name);
    }

    @Step("Ввод данных в поле «Email»")
    public void setEmailRegisterPage(WebDriver driver, String email) {
        driver.findElement(emailRegisterPage).click();
        driver.findElement(emailRegisterPage).sendKeys(email);
    }

    @Step("Ввод данных в поле «Пароль»")
    public void setPasswordRegisterPage(WebDriver driver, String password) {
        driver.findElement(passwordRegisterPage).click();
        driver.findElement(passwordRegisterPage).sendKeys(password);
    }

    @Step("Клик по кнопке «Зарегистрироваться»")
    public void clickRegisterButtonRegisterPage(WebDriver driver) {
        driver.findElement(registerButtonRegisterPage).click();
    }

    @Step("Клик по кнопке «Войти»")
    public void clickLoginButtonRegisterPage(WebDriver driver) {
        driver.findElement(loginButtonRegisterPage).click();
    }

    @Step("Регистрации пользователя")
    public void registrationUser(WebDriver driver, String name, String email, String password) {
        setNameRegisterPage(driver, name);
        setEmailRegisterPage(driver, email);
        setPasswordRegisterPage(driver, password);
        clickRegisterButtonRegisterPage(driver);
    }

    @Step("Отображение ошибки при невалидном пароле")
    public boolean isErrorPasswordDisplayed(WebDriver driver) {
       return driver.findElement(errorInvalidPassword).isDisplayed();

    }
}