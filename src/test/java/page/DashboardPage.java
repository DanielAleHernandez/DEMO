package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Project: DEMO
 * Package: page
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 20/2/2025
 * Time: 10:26
 * <p>
 */
public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //Mapeo de Elementos

    //Dar clic en la opcion categorias
    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]")
    WebElement optionCategorias;

//Dar clic en la opcion Vehiculos
    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[1]/a")
    //@FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[1]/as")
    WebElement selectVehiculos;

    //@FindBy(xpath = "/html/body/header/diiv/div[5]/div/ul/li[1]/div/ul/li[7]")
    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[7]/a")
    WebElement selectDeportesYFitness;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/input")
    WebElement barraBusqueda;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/button")
    WebElement btnRealizarBusqueda;

    @FindBy(xpath = "/html/body/main/div/div[2]/section/ol/li[1]/div")
    WebElement seleccionarProductoBuscado;

    @FindBy(xpath = "/html/body/main/div[2]/div[4]/div[2]/div[1]/div/div[2]")
    WebElement caracteristicasDelProducto;

    /*@FindBy(xpath = "")
    public WebElement c;]]
    */
    public void highlightOptCategoria(){
        highlightElement(optionCategorias);
    }

    public void unHighlightOptCategoria(){
        unhighlightElement(optionCategorias);
    }

    public void onClickOptCategoria(){
        onClick(optionCategorias);
    }

    public void highlighSelectDeportFitness(){
        highlightElement(selectDeportesYFitness);
    }

    public void unHighlightSelectDeportFitness(){
        unhighlightElement(selectDeportesYFitness);
    }

    public void onClickselectDeportesYFitness(){
        onClick(selectDeportesYFitness);
    }

    public void highlighBarraBusqueda(){
        highlightElement(barraBusqueda);
    }

    public void unHighlightBarraBusqueda(){
        unhighlightElement(barraBusqueda);
    }

    public void onClickBarraBusqueda(){
        onClick(barraBusqueda);
    }

    public void sendKetBarraBusqueda(String txt){
        clear(barraBusqueda);
        sendKeys(barraBusqueda,txt);
    }

    public void highlighBtnBuscar(){
        highlightElement(btnRealizarBusqueda);
    }

    public void unHighlightBtnBuscar(){
        unhighlightElement(btnRealizarBusqueda);
    }

    public void onClickBtnBuscar(){
        onClick(btnRealizarBusqueda);
    }

    public void highlighSelectProduct(){
        highlightElement(seleccionarProductoBuscado);
    }

    public void unHighlightSelectProduct(){
        unhighlightElement(seleccionarProductoBuscado);
    }

    public void onClickSelectProduct(){
        onClick(seleccionarProductoBuscado);
    }

 public void highlighCaracteristicasProduct(){
        highlightElement(caracteristicasDelProducto);
    }

    public void unHighlightCaracteristicasProduct(){
        unhighlightElement(caracteristicasDelProducto);
    }

    public void onClickCaracteristicasProduct(){
        onClick(caracteristicasDelProducto);
    }

    public void onClickSelectVehiculos(){
        onClick(selectVehiculos);
    }

    public void highlighVehiculo(){
        highlightElement(selectVehiculos);
    }

    public void unHighlightVehiculo(){
        unhighlightElement(selectVehiculos);
    }

}
