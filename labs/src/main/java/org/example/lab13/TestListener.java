package org.example.lab13;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.example.lab12.WebDriverSupplier.driver;

public class TestListener implements ITestListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        LOGGER.info(context.getName()+" onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        LOGGER.info(context.getName()+" onFinish");
    }
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        LOGGER.info("Method: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Status: " + result.getStatus());

        captureScreenshot(result.getMethod().getMethodName());
    }

    private void captureScreenshot(String methodName) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshotFile.toPath(), new File("/LOGS/" + methodName + "_screenshot.png").toPath());
            } catch (IOException e) {
                LOGGER.info("Error while saving screenshot: " + e.getMessage());
            }
        } else {
            LOGGER.info("WebDriver does not support screenshot capture.");
        }
    }
}
