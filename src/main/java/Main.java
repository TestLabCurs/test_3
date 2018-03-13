import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.*;
import utils.BrouserSelection;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BrouserSelection brouserSelection = new BrouserSelection();
        EventFiringWebDriver webDriver = new EventFiringWebDriver(brouserSelection.getDriver());
        webDriver.manage().window().maximize();
        webDriver.register(new EventHandler());

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.action();

        CategoryPage categoryPage = new CategoryPage(webDriver);
        categoryPage.action();

        FilterPage filterPage = new FilterPage(webDriver);
        filterPage.action();


        webDriver.quit();
    }
}

