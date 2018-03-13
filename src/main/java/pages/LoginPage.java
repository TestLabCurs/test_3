package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void login()  {

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        WebElement fieldLogin = webDriver.findElement(By.id("email"));
        WebElement fieldPasswort = webDriver.findElement(By.id("passwd"));
        WebElement buttonEnter = webDriver.findElement(By.name("submitLogin"));

        fieldLogin.sendKeys("webinar.test@gmail.com");
        fieldPasswort.sendKeys("Xcg7299bnSmMuRLp9ITw");
        buttonEnter.click();
    }
}
