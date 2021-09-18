package TestRunner;

import Pages.Signup;
import Setup.Setup;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class SignupTestRunner extends Setup {
    Signup objSignup;
    @Test(enabled = true, description = "Signup successful")
    public void doSignup() throws Exception {
        driver.get("http://automationpractice.com");
        objSignup = new Signup(driver);
        objSignup.memberSignUp();
        Allure.description("Signup successful");

    }
}
