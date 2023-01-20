package com.reportportal;

import com.reportportal.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;
    protected static final int LENGTH_OF_DASHBOARD_NAME = 12;
    protected static final int LENGTH_OF_DASHBOARD_DESCRIPTION = 15;

    @BeforeMethod()
    public void setDriver(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
