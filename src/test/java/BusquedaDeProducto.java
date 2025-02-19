import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;
import pages.Dashboard_Page;
import utils.TestReport;
import utils.Utils;

import java.io.IOException;

public class BusquedaDeProducto
{
    WebDriver driver;
    TestReport report = new TestReport("BusquedaDeProducto");
    Utils utils = new Utils();


    public void setup () throws InterruptedException
    {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();


    }

    public void paginaInicial() throws InterruptedException
    {
        driver.get("https://www.mercadolibre.com.mx/");
    }

    public void darClickenCategorias() throws InterruptedException
    {
        Dashboard_Page dashboard_page = new Dashboard_Page(driver);
        utils.highlightElement(driver, dashboard_page.optionCategorias);
        report.takeScreenshot(driver,"Dar click en la opción de categorias para visualizar las categorias existentes", "step1_darClickEnLaOpciónDeCategoriasParaVisualizarLasCategoriasExistentes.png");
        utils.unhighlightElement(driver, dashboard_page.optionCategorias);
        dashboard_page.optionCategorias.click();
        Thread.sleep(2000);
    }

    public void seleccionarCategoria() throws InterruptedException
    {
        Dashboard_Page dashboard_page = new Dashboard_Page(driver);
        utils.highlightElement(driver, dashboard_page.selectDeportesYFitness);
        report.takeScreenshot(driver, "Seleccionar y dar click en la opcion -Deportes y Fitness-", "step2_seleccionarYDarClickEnLaOpcionDeportesYFitness.png" );
        utils.unhighlightElement(driver, dashboard_page.selectDeportesYFitness);
        dashboard_page.selectDeportesYFitness.click();
        Thread.sleep(2000);
    }

    public void realizarBusqueda() throws InterruptedException
    {
        Dashboard_Page dashboard_page = new Dashboard_Page(driver);
        utils.highlightElement(driver, dashboard_page.barraBusqueda);
        report.takeScreenshot(driver, "Dar Click en la barra de busqueda, para buscar el producto deseado", "step3_darClickEnLaBarraDeBusquedaParaBuscarElProductoDeseado.png");
        utils.unhighlightElement(driver, dashboard_page.barraBusqueda);
        dashboard_page.barraBusqueda.click();
        Thread.sleep(2000);
        utils.highlightElement(driver, dashboard_page.barraBusqueda);
        dashboard_page.barraBusqueda.sendKeys("Balón Molten Basketball");
        report.takeScreenshot(driver, "Ingresar el producto a buscar","step4_ingresarElProductoABuscar.png");
        utils.unhighlightElement(driver, dashboard_page.barraBusqueda);
        Thread.sleep(2000);
        utils.highlightElement(driver, dashboard_page.btnRealizarBusqueda);
        report.takeScreenshot(driver, "Dar click en el botón con el icono de lupa para realizar la búsqueda","step5_darClickEnElBotónConElIconoDeLupaParaRealizarLaBúsqueda.png");
        utils.unhighlightElement(driver, dashboard_page.btnRealizarBusqueda);
        dashboard_page.btnRealizarBusqueda.click();
        Thread.sleep(2000);
    }

    public void seleccionarProducto() throws InterruptedException
    {
        Dashboard_Page dashboard_page = new Dashboard_Page(driver);
        utils.highlightElement(driver, dashboard_page.seleccionarProductoBuscado);
        report.takeScreenshot(driver, "Seleccionar producto buscado","step6_seleccionarProductoBuscado.png");
        utils.unhighlightElement(driver, dashboard_page.seleccionarProductoBuscado);
        dashboard_page.seleccionarProductoBuscado.click();
        Thread.sleep(2000);
    }

    public void visualizarCaracteristicasDelProducto() throws InterruptedException
    {
        Dashboard_Page dashboard_page = new Dashboard_Page(driver);
        utils.highlightElement(driver, dashboard_page.caracteristicasDelProducto);
        report.takeScreenshot(driver, "Visualizar Caracteristicas del producto","step7_visualizarCaracteristicasDelProducto.png");
        Thread.sleep(2000);
    }


    //Metodo para cerrar la prueba
    public void tearDown()
    {
        try {
            report.generateTestReport();
        }catch (IOException e){
            System.err.println("Error al generar el PDF: " + e.getMessage());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        BusquedaDeProducto test = new BusquedaDeProducto();
        test.setup();
        test.paginaInicial();
        test.darClickenCategorias();
        test.seleccionarCategoria();
        test.realizarBusqueda();
        test.seleccionarProducto();
        test.visualizarCaracteristicasDelProducto();
        test.tearDown();
    }

}
