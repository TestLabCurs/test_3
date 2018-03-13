package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class FilterPage {
    WebDriver webDriver;

    private String fieldSaved = "alert alert-success";
    private String fieldCategoryName = "categoryFilter_name";
    private String buttonSearch = "submitFilterButtoncategory";

    public FilterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void action() throws InterruptedException {
       
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String adressSaved = "//div[@class=" + "'" + fieldSaved + "'" + "]";
        String adressFieldName = "(//td)[last()-4]";
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        WebElement locatorSaved = webDriver.findElement(By.xpath(adressSaved));

        String str = locatorSaved.getText().substring(locatorSaved.getText().length() - 7, locatorSaved.getText().length());

        if (!str.equals("Создано")) {
            System.out.println("Категория не создана");
        } else {
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight-300)");
            WebElement searchCategory = webDriver.findElement(By.name(fieldCategoryName));
            searchCategory.sendKeys("Новая категория, тест");
            WebElement buttonSearchSavedCategory = webDriver.findElement(By.id(buttonSearch));
            buttonSearchSavedCategory.click();
            WebElement nameCategoryNew = webDriver.findElement(By.xpath(adressFieldName));
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }
    }
}
