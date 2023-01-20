package com.reportportal.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    public abstract AbstractPage openReportportal();

}
