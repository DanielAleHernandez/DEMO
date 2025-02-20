package utils;

import io.qameta.allure.Attachment;
import manager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

/**
 * Project: DEMO
 * Package: utils
 * Company: MTP International
 * <p>
 * User: hector.hernandez
 * Date: 19/2/2025
 * Time: 17:20
 * <p>
 */
public class TestListener implements ITestListener {
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] saveScreenshot(String name, WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result.getName(), DriverManager.getDriver());
    }
}
