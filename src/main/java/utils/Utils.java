package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils
{
    //Aquí se agregan los métodos que sean repetitivos para los test

    /**
     * Resalta un elemento con borde rojo.
     *
     * @param driver  WebDriver para ejecutar el script JavaScript.
     * @param element Elemento a resaltar.
     */
    public void highlightElement(WebDriver driver, WebElement element) {
        String javascript = "arguments[0].style.border='4px solid red'";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, element);
    }

    /**
     * Quita el borde rojo de un elemento (restaura el estilo original).
     *
     * @param driver  WebDriver para ejecutar el script JavaScript.
     * @param element Elemento a quitarle el borde rojo.
     */
    public void unhighlightElement(WebDriver driver, WebElement element) {
        // Restauramos el borde original del elemento
        String javascript = "arguments[0].style.border=''";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(javascript, element);
    }
}
