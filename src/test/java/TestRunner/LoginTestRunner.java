package TestRunner;

import Pages.Login;
import Setup.Setup;
import Utils.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    Login objLogin;
    Utils utils;

    @Test(enabled = true, groups = "login", description = "Login with valid email and password")
    public void doLogin() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        utils =new Utils(driver);
        utils.readJSONArray(0);
        String email=utils.getEmail();
        String password=utils.getPassword();

        String user = objLogin.doLogin(email, password);
        Assert.assertEquals(user, "Test User");
        driver.findElement(By.xpath("//a[@class='logout']")).click();
        utils.addDescription("User can logged in successfully with valid user and password");

    }
    @Test(enabled = true, description = "Login with wrong password", groups = "login")
    public void doLoginForWrongPassword() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);

        utils =new Utils(driver);
        utils.readJSONArray(1);
        String email=utils.getEmail();
        String password=utils.getPassword();

        String authError = objLogin.doLoginForWrongPassword(email, password);
        Assert.assertEquals(authError, "Authentication failed.");
        utils.addDescription("Authentication error shows when user provides wrong Password");

    }
    @Test(enabled = true, description = "Login with invalid email", groups = "login")
    public void doLoginForInvalidEmail() throws Exception {
        driver.get("http://automationpractice.com");
        objLogin = new Login(driver);
        utils =new Utils(driver);
        utils.readJSONArray(2);
        String email=utils.getEmail();
        String password=utils.getPassword();

        String error = objLogin.doLoginForInvalidEmail(email, password);
        Assert.assertEquals(error, "Invalid email address.");
        utils.addDescription("Error message shows when user provides invalid email");

    }


}
