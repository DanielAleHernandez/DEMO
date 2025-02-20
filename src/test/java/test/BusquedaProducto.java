package test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Project: DEMO
 * Package: test
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 19/2/2025
 * Time: 18:06
 * <p>
 */
public class BusquedaProducto extends BaseTest {

    @Test(description = "Dar click en categorias")
    public void busquedaProducto(){

        dashboardPage.onClickOptCategoria();
        Assert.assertEquals();

    }
}
