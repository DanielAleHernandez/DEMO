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

    private WebElement optionCategorias;

    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[7]")
    private WebElement selectDeportesYFitness;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/input")
    private WebElement barraBusqueda;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/button")
    private WebElement btnRealizarBusqueda;

    @FindBy(xpath = "/html/body/main/div/div[2]/section/ol/li[1]/div")
    private WebElement seleccionarProductoBuscado;

    @FindBy(xpath = "/html/body/main/div[2]/div[4]/div[2]/div[1]/div/div[2]")
    private WebElement caracteristicasDelProducto;

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

    public void sendKetBarraBusqueda(){
        clear(barraBusqueda);

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

}
