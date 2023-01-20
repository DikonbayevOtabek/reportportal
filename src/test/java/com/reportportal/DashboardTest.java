package com.reportportal;

import com.reportportal.model.User;
import com.reportportal.page.LoginPage;
import com.reportportal.util.StringUtils;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends CommonConditions{

    @Test
    public void addNewDashboard(){
        String actualNameOfDashboard =
                StringUtils.generateRandomNameOfDashboard(LENGTH_OF_DASHBOARD_NAME);
        String actualDescriptionOfDashboard =
                StringUtils.generateRandomDescriptionOfDashboard(LENGTH_OF_DASHBOARD_DESCRIPTION);
        User user = User.createUserWithCorrectValues();
        boolean isDashboardAdded = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .addNewDashboard(actualNameOfDashboard, actualDescriptionOfDashboard)
                .isDashboardAdded();

        Assert.assertTrue(isDashboardAdded);
    }


    @Test
    public void testNameOfCreatedDashboard(){
        String actualNameOfDashboard =
                StringUtils.generateRandomNameOfDashboard(LENGTH_OF_DASHBOARD_NAME);
        String actualDescriptionOfDashboard =
                StringUtils.generateRandomDescriptionOfDashboard(LENGTH_OF_DASHBOARD_DESCRIPTION);
        User user = User.createUserWithCorrectValues();
        boolean isNameMatchesToCreatedOne = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .addNewDashboard(actualNameOfDashboard, actualDescriptionOfDashboard)
                .isNameOfCreatedDashboardCorrect(actualNameOfDashboard);

        Assert.assertTrue(isNameMatchesToCreatedOne);
    }
    @Test
    public void testDescriptionOfCreatedDashboard(){
        String actualNameOfDashboard =
                StringUtils.generateRandomNameOfDashboard(LENGTH_OF_DASHBOARD_NAME);
        String actualDescriptionOfDashboard =
                StringUtils.generateRandomDescriptionOfDashboard(LENGTH_OF_DASHBOARD_DESCRIPTION);
        User user = User.createUserWithCorrectValues();
        boolean isDescriptionMatchesToCreatedOne = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .addNewDashboard(actualNameOfDashboard, actualDescriptionOfDashboard)
                .isDescriptionOfCreatedDashboardCorrect(actualDescriptionOfDashboard);

        Assert.assertTrue(isDescriptionMatchesToCreatedOne);
    }
}
