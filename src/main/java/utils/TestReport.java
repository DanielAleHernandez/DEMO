package utils;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestReport
{
    private static final String BASE_SCREENSHOT_PATH = "src/main/screenshots/";
    private static final String PDF_PATH = "src/main/screenshots/";

    private String testName;
    private List<String> screenshotPaths = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    private int cont;
    public TestReport(String testName) {
        this.testName = testName;
        cont = 1;
    }

    /**
     * Toma una captura de pantalla, la guarda y almacena su ruta.
     * @param driver      WebDriver para tomar la captura.
     * @param description Descripción para la captura.
     * @param fileName    Nombre del archivo de la captura.
     */
    public void takeScreenshot(WebDriver driver, String description, String fileName) {
        String screenshotPath = ScreenshotUtil.saveScreenshot(driver, testName,  "_"+PdfUtil.dateTime() + "_"+fileName);
        screenshotPaths.add(screenshotPath);
        descriptions.add(description);
    }

    public void takeScreenshot(WebDriver driver, String description) {
        String screenshotPath = ScreenshotUtil.saveScreenshot(driver,
                testName,  PdfUtil.dateTime() + "_step"+(cont++)+"_"+noSpaces(description)+".png");
        screenshotPaths.add(screenshotPath);
        descriptions.add(description);
    }


    private String noSpaces(String txt){
        String temp = "";
        for (int i = 0; i < txt.length(); i++){
            if(txt.charAt(i) != ' '){
                temp+= txt.charAt(i);
            }
        }
        return temp;
    }


    /**
     * Genera el PDF con las capturas tomadas durante la prueba.
     */

    public void generateTestReport() throws IOException {
        // Generar PDF
        String pdfFilePath = PDF_PATH + testName+ "_"+PdfUtil.dateTime() + "_report.pdf";
        PdfUtil.generatePdfFromImages(screenshotPaths, descriptions, pdfFilePath);
    }

    /**
     * Clase interna que maneja la lógica de las capturas.
     */
    public static class ScreenshotUtil {
        public static String saveScreenshot(WebDriver driver, String testName, String fileName) {
            try {
                // Construir la ruta dinámica: "screenshots/<nombrePrueba>/"
                String testPath = BASE_SCREENSHOT_PATH + testName + "/";
                Files.createDirectories(Paths.get(testPath));

                // Ruta completa del archivo de la captura
                String fullPath = testPath + fileName;

                // Verificar si el archivo ya existe y eliminarlo si es necesario
                if (Files.exists(Paths.get(fullPath))) {
                    Files.delete(Paths.get(fullPath)); // Eliminar el archivo existente
                    System.out.println("Archivo existente eliminado: " + fullPath);
                }

                // Tomar el screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Copiar el archivo a la carpeta correspondiente
                Files.copy(screenshot.toPath(), Paths.get(fullPath));
                System.out.println("Screenshot guardado: " + fullPath);

                // Retornar la ruta del archivo
                return fullPath;
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error al guardar screenshot: " + fileName);
                return null;
            }
        }
    }

    /**
     * Clase interna para generar el PDF a partir de las capturas.
     */
    public static class PdfUtil {
        public static void generatePdfFromImages(List<String> images, List<String> descriptions, String outputPdf)
                throws IOException {
            // Verificar si el archivo PDF ya existe y eliminarlo si es necesario
            if (Files.exists(Paths.get(outputPdf))) {
                Files.delete(Paths.get(outputPdf)); // Eliminar el archivo PDF existente
                System.out.println("El archivo PDF existente ha sido eliminado: " + outputPdf);
            }

            if (images.size() != descriptions.size()) {
                throw new IllegalArgumentException("El número de imágenes debe coincidir con el número de descripciones.");
            }

            // Crear un escritor de PDF
            PdfWriter writer = new PdfWriter(outputPdf);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Agregar imágenes y descripciones al PDF
            for (int i = 0; i < images.size(); i++) {
                // Agregar descripción como un párrafo
                document.add(new Paragraph("Paso " + (i + 1) + ": " + descriptions.get(i)));

                // Agregar imagen
                ImageData imageData = ImageDataFactory.create(images.get(i));
                Image img = new Image(imageData);
                img.scaleToFit(500, 500); // Escalar la imagen para que no supere el tamaño de la página
                document.add(img);

                // Agregar un salto de línea
                document.add(new Paragraph("\n"));
            }

            // Cerrar el documento
            document.close();
            System.out.println("PDF generado en: " + outputPdf);
        }

        public static String dateTime() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
    }
}
