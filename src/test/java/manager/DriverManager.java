package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Project: DEMO
 * Package: manager
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 20/2/2025
 * Time: 09:48
 * <p>
 */
public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Inicializamos el web driver de Google Chrome
     */
    public static void initDriver(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
}
