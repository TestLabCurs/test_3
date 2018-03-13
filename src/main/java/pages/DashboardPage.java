package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DashboardPage {
    WebDriver webDriver;
    private String fieldCatalog = "9";
    private String fieldCategory = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCategories&token=795a6350b3a0f87af2a165b4c1a34372";

    public DashboardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void action() throws InterruptedException {
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String adressCatalog = "li[data-submenu=" + "'" + fieldCatalog + "'" + "]";
        String adressCategory = "a[href=" + "'" + fieldCategory + "'" + "]";

        WebElement locatorCatalog = webDriver.findElement(By.cssSelector(adressCatalog));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(locatorCatalog).build().perform();

        WebElement locatorCategory = webDriver.findElement(By.cssSelector(adressCategory));
        locatorCategory.click();
        }
    }




