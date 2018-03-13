package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CategoryPage {
    WebDriver webDriver;
    private String buttonAddCategory = "page-header-desc-category-new_category";
    private String fieldAddCategory = "name_1";
    private String saveNewCategory = "category_form_submit_btn";

    public CategoryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void action() throws InterruptedException {
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement locatorButtonAddCategory = webDriver.findElement(By.id(buttonAddCategory));
        locatorButtonAddCategory.click();

        WebElement locatorAddCategory = webDriver.findElement(By.id(fieldAddCategory));
        locatorAddCategory.sendKeys("Новая категория, тест");

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement buttonSaveNewCategory = webDriver.findElement(By.id(saveNewCategory));
        buttonSaveNewCategory.click();
    }
}
