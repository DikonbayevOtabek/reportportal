package com.reportportal.page;

import com.reportportal.model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    private final String DEMO_PAGE_URL = "https://demo.reportportal.io/ui/";

    @FindBy(xpath = "//input[@name='login']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openReportportal() {
        driver.navigate().to(DEMO_PAGE_URL);
        return this;
    }
    public MainPage login(User user){
        username.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, user.getUsername());
        password.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, user.getPassword());
        password.sendKeys(Keys.ENTER);
        return new MainPage(driver);
    }

}
