package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Project: DEMO
 * Package: page
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 19/2/2025
 * Time: 18:07
 * <p>
 */
public class BasePage {
    private WebDriver driver;
    private final long WAIT = 20;
    public BasePage(WebDriver _driver){
        driver = _driver;
    }
    private void waitForVisibility(WebElement e){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    /**
     * Acción de dar click a un elemnto de la pagina
     * @param e Elemento al que se espera dar click
     */
    public void onClick(WebElement e){
        waitForVisibility(e);
        e.click();
    }

    /**
     * Resalta un elemento con borde rojo.
     *
     * @param driver  WebDriver para ejecutar el script JavaScript.
     * @param element Elemento a resaltar.
     */
    public void highlightElement(WebElement e) {
        waitForVisibility(e);
        String javascript = "arguments[0].style.border='4px solid red'";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, e);
    }

    /**
     * Quita el borde rojo de un elemento (restaura el estilo original).
     *
     * @param driver  WebDriver para ejecutar el script JavaScript.
     * @param element Elemento a quitarle el borde rojo.
     */
    public void unhighlightElement(WebElement e) {
        // Restauramos el borde original del elemento
        waitForVisibility(e);
        String javascript = "arguments[0].style.border=''";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, e);
    }

    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }

    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }
}
