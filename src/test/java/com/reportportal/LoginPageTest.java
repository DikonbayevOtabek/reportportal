package com.reportportal;

import com.reportportal.model.User;
import com.reportportal.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends CommonConditions{

    @Test
    public void loginWithCorrectUsernamePassword(){
        User user = User.createUserWithCorrectValues();
        boolean isLoggedIn = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .isDashboardButtonVisible();

        Assert.assertTrue(isLoggedIn);
    }

    @Test
    public void loginWithIncorrectUsername(){
        User user = User.createUserWithIncorrectUsername();
        boolean isLoggedIn = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .isDashboardButtonVisible();

        Assert.assertFalse(isLoggedIn);
    }

    @Test
    public void loginWithIncorrectPassword(){
        User user = User.createUserWithIncorrectPassword();
        boolean isLoggedIn = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .isDashboardButtonVisible();

        Assert.assertFalse(isLoggedIn);
    }

    @Test
    public void loginWithEmptyUsername(){
        User user = User.createUserWithEmptyUsername();
        boolean isLoggedIn = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .isDashboardButtonVisible();

        Assert.assertFalse(isLoggedIn);
    }

    @Test
    public void loginWithEmptyPassword(){
        User user = User.createUserWithEmptyPassword();
        boolean isLoggedIn = new LoginPage(driver)
                .openReportportal()
                .login(user)
                .isDashboardButtonVisible();

        Assert.assertFalse(isLoggedIn);
    }

}
