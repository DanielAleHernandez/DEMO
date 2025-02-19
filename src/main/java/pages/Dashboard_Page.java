package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page
{
    WebDriver driver ;

    //Mapeo de Elementos

    //Dar clic en la opcion categorias
    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]")
    public WebElement optionCategorias;

    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[7]")
    public WebElement selectDeportesYFitness;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/input")
    public WebElement barraBusqueda;

    @FindBy(xpath = "/html/body/header/div/div[2]/form/button")
    public WebElement btnRealizarBusqueda;

    @FindBy(xpath = "/html/body/main/div/div[2]/section/ol/li[1]/div")
    public WebElement seleccionarProductoBuscado;

    @FindBy(xpath = "/html/body/main/div[2]/div[4]/div[2]/div[1]/div/div[2]")
    public WebElement caracteristicasDelProducto;

    @FindBy(xpath = "")
    public WebElement c;

    public Dashboard_Page (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
