package test;

import io.qameta.allure.Step;
import manager.DriverManager;
import org.testng.annotations.Test;
import utils.TestReport;

public class BusquedaDeProducto extends BaseTest {


    @Test(description = "Busqueda produto")
    public void searchProduct()  throws InterruptedException{
        report = new TestReport("Busqueda produto");
        darClickenCategorias();
        seleccionarCategoria();
        realizarBusqueda();
        seleccionarProducto();
        visualizarCaracteristicasDelProducto();
    }

    @Test(description = "Seleccionar categoria Vehiculos")
    public void selectVehiculos()  throws InterruptedException{
        report = new TestReport("Seleccionar categoria Vehiculos");
        darClickenCategorias();
        //seleccionarCategoria();
        seleccionaVeiculo();
        Thread.sleep(8000);
    }
    @Step("onClick categorias")
    public void darClickenCategorias() throws InterruptedException  {

        dashboardPage.highlightOptCategoria();
        report.takeScreenshot(DriverManager.getDriver(),
                "Dar click en la opción de categorias para visualizar las categorias existentes");

//        report.takeScreenshot(DriverManager.getDriver(),
//                "Dar click en la opción de categorias para visualizar las categorias existentes",
//                "step1_darClickEnLaOpciónDeCategoriasParaVisualizarLasCategoriasExistentes.png");
        dashboardPage.unHighlightOptCategoria();
        dashboardPage.onClickOptCategoria();
        Thread.sleep(2000);
    }

    @Step("select Categoria")
    public void seleccionarCategoria() throws InterruptedException {
        dashboardPage.highlighSelectDeportFitness();
        report.takeScreenshot(DriverManager.getDriver(),
                "Seleccionar y dar click en la opcion -Deportes y Fitness-");
        dashboardPage.unHighlightSelectDeportFitness();
        dashboardPage.onClickselectDeportesYFitness();
        Thread.sleep(2000);
    }

    @Step("select Vehiculo")
    public void seleccionaVeiculo() throws InterruptedException {
        dashboardPage.highlighVehiculo();
        report.takeScreenshot(DriverManager.getDriver(), "Seleccionar y dar click en la opcion Vehiculos");
        dashboardPage.unHighlightVehiculo();
        dashboardPage.onClickSelectVehiculos();
        Thread.sleep(2000);
    }

    @Step("realizarBusqueda")
    public void realizarBusqueda() throws InterruptedException {
        dashboardPage.highlighBarraBusqueda();
        report.takeScreenshot(DriverManager.getDriver(), "Dar Click en la barra de busqueda, para buscar el producto deseado");
        dashboardPage.unHighlightBarraBusqueda();
        dashboardPage.onClickBarraBusqueda();

        Thread.sleep(2000);
        dashboardPage.highlighBarraBusqueda();

        dashboardPage.sendKetBarraBusqueda("Balón Molten Basketball");
        report.takeScreenshot(DriverManager.getDriver(), "Ingresar el producto a buscar");
        dashboardPage.unHighlightBarraBusqueda();
        Thread.sleep(2000);

        dashboardPage.highlighBtnBuscar();
        report.takeScreenshot(DriverManager.getDriver(), "Dar click en el botón con el icono de lupa para realizar la búsqueda");
        dashboardPage.unHighlightBtnBuscar();
        dashboardPage.onClickBtnBuscar();

        Thread.sleep(2000);
    }
    @Step("select Producto")
    public void seleccionarProducto() throws InterruptedException {
        dashboardPage.highlighSelectProduct();
        report.takeScreenshot(DriverManager.getDriver(), "Seleccionar producto buscado");
        dashboardPage.unHighlightSelectProduct();
        dashboardPage.onClickSelectProduct();
        Thread.sleep(2000);
    }

    @Step("visualizarCaracteristicasDelProducto")
    public void visualizarCaracteristicasDelProducto() throws InterruptedException  {
        dashboardPage.highlighCaracteristicasProduct();
        report.takeScreenshot(DriverManager.getDriver(), "Visualizar Caracteristicas del producto");
        Thread.sleep(2000);
    }



}
