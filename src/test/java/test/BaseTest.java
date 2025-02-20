package test;

import manager.DriverManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import page.DashboardPage;

/**
 * Project: DEMO
 * Package: test
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 20/2/2025
 * Time: 09:55
 * <p>
 */
public class BaseTest {
    protected DashboardPage dashboardPage;
    private static final String URL_TEST_PAGE = "https://www.mercadolibre.com.mx/";
    private void goToUrl(){
        DriverManager.getDriver().get(URL_TEST_PAGE);
    }
    /**
     * Se ejecuta Antes de cada Test
     */
    @BeforeTest
    public void beforeTest( ){
        DriverManager.initDriver(); // Se crea el driver

        goToUrl(); // Navega hacia la url que definimos en URL_TEST_PAGE
        dashboardPage = new DashboardPage(DriverManager.getDriver());
    }


    /**
     * Se ejecuta despues de cada Test
     */
    @AfterTest
    public void afterTest(){
        DriverManager.getDriver().close();
    }
}
