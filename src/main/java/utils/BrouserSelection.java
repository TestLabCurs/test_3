package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.applet.Main;

import java.io.File;
import java.util.Scanner;

public class BrouserSelection {
    public WebDriver driver;
    int brouser = 0;
    Scanner in = new Scanner(System.in);

    public WebDriver getDriver() {
        while (brouser < 1 || brouser > 3) {
            System.out.println("Выберите браузер: 1.Firefox, 2.IE, 3.Chrome");
            brouser = in.nextInt();
        }
        switch (brouser) {
            case (1):
                System.setProperty("webdriver.gecko.driver",
                        new File(Main.class.getResource("/geckodriver.exe").getFile()).getPath());
                driver = new FirefoxDriver();
                break;
            case (2):
                System.setProperty("webdriver.ie.driver",
                        new File(Main.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                driver = new InternetExplorerDriver();
                break;
            case (3):
                System.setProperty("webdriver.chrome.driver",
                        new File(Main.class.getResource("/chromedriver.exe").getFile()).getPath());
                driver = new ChromeDriver();
                break;

        }
        return driver;
    }
}
