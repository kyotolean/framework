package org.example.lab13;

import org.apache.log4j.Logger;
import org.example.lab12.WebDriverSupplier;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    private final Logger LOGGER = Logger.getLogger(this.getClass());


    @Override
    public void onStart(ISuite suite){
        ISuiteListener.super.onStart(suite);
        LOGGER.info("start " + suite.getName());
    }
    @Override
    public void onFinish(ISuite suite){
        ISuiteListener.super.onFinish(suite);
        LOGGER.info("finish " + suite.getName());
    }


    public void onExecutionFinish() {
        LOGGER.info("Execution Finished");
    }


    public void afterInvocation(ISuite suite) {
        LOGGER.info("Test Invocation Finished: " + suite.getName());

        closeBrowser();
    }

    private void closeBrowser() {
        WebDriverSupplier.close();
    }
}
