package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private final By loginButtonForgotPassPage = By.xpath(".//a[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке «Войти»")
    public void clickLoginButtonForgotPassPage(WebDriver driver){
        driver.findElement(loginButtonForgotPassPage).click();
    }
}
