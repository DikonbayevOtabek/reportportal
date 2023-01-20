package com.reportportal.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a[@href='#default_personal/dashboard']")
    private WebElement dashboardButton;
    @FindBy(xpath = "//span[@class='ghostButton__text--eUa9T']")
    private WebElement addNewDashboard;
    @FindBy(xpath = "//input[@class='input__input--3DC8i type-text variant-standard input__error--3ZvLE']")
    private WebElement nameOfNewDashboard;
    @FindBy(xpath = "//textarea[@class='inputTextArea__input-text-area--71Pxq']")
    private WebElement descriptionOfNewDashboard;
    @FindBy(xpath = "//button[@class='bigButton__big-button--ivY7j bigButton__color-booger--2IfQT']")
    private WebElement addButton;
    @FindBy(xpath = "//div[@class='inputBigSwitcher__off--2aXGi']")
    private WebElement shareOption;
    @FindBy(xpath = "//div[@class='emptyWidgetGrid__empty-widget--1fGBx']")
    private WebElement addNewWidget;
    private final By nameOfCreatedDashboardLocator =
            By.xpath("//a[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__name--1sWJs']");
    private final By descriptionOfCreatedDashboardLocator =
            By.xpath("//div[@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__description--2TbtF']");



    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public boolean isDashboardButtonVisible(){
        try{
            wait.until(ExpectedConditions.visibilityOf(dashboardButton));
            return dashboardButton.isDisplayed();
        }catch (Exception exception){
            return false;
        }
    }

    public MainPage addNewDashboard(String nameOfCreatingDashboard, String descriptionOfCreatingDashboard){
        wait.until(ExpectedConditions.visibilityOf(dashboardButton));
        dashboardButton.click();
        wait.until(ExpectedConditions.visibilityOf(addNewDashboard));
        addNewDashboard.click();
        wait.until(ExpectedConditions.visibilityOf(nameOfNewDashboard));
        nameOfNewDashboard.sendKeys(nameOfCreatingDashboard);
        descriptionOfNewDashboard.sendKeys(descriptionOfCreatingDashboard);
        shareOption.click();
        addButton.click();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
        return this;
    }
    public boolean isDashboardAdded(){
        wait.until(ExpectedConditions.visibilityOf(addNewWidget));
        return addNewWidget.isDisplayed();
    }



    private boolean isInsideOfList(List<WebElement> listOfDashboardNames, String nameOfDashboard){
        for(int i = 0; i < listOfDashboardNames.toArray().length; ++i){
            System.out.println(listOfDashboardNames.get(i).getText());
            if(listOfDashboardNames.get(i).getText().equals(nameOfDashboard)){
                return true;
            }
        }
        return false;
    }
    public boolean isNameOfCreatedDashboardCorrect(String nameOfDashboard){
        wait.until(ExpectedConditions.visibilityOf(dashboardButton));
        dashboardButton.click();
        List<WebElement> listOfDashboardNames = driver.findElements(nameOfCreatedDashboardLocator);
        return isInsideOfList(listOfDashboardNames, nameOfDashboard);
    }
    public boolean isDescriptionOfCreatedDashboardCorrect(String descriptionOfDashboard){
        wait.until(ExpectedConditions.visibilityOf(dashboardButton));
        dashboardButton.click();
        List<WebElement> listOfDashboardDescriptions = driver.findElements(descriptionOfCreatedDashboardLocator);
        return isInsideOfList(listOfDashboardDescriptions, descriptionOfDashboard);
    }


    @Override
    public MainPage openReportportal() {
        return null;
    }
}
