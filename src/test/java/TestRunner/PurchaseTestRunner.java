package TestRunner;

import Pages.Login;
import Pages.PurchaseItem;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseTestRunner extends Setup {
    PurchaseItem objPurchase;
    Login objLogin;
    Utils utils;
    @BeforeTest(groups = "purchase_product")
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com");
        utils=new Utils(driver);
        utils.readJSONFile();
        String email=utils.getEmail();
        String password=utils.getPassword();

        objLogin=new Login(driver);
        objLogin.doLogin(email,password);

    }

    @Test(enabled = true, description = "Check cart")
    public void checkHasCart() throws Exception {
        objPurchase = new PurchaseItem(driver);
        boolean status= objPurchase.checkHasCart();
        Assert.assertEquals(status,true);
        utils.addDescription("User can view cart");

    }
    @Test(enabled = true, description = "Check order history")
    public void checkOrderHistory() throws Exception {
        objPurchase = new PurchaseItem(driver);
        String headerText= objPurchase.orderHistory();
        Assert.assertEquals(headerText,"ORDER HISTORY");
        utils.addDescription("User can view his/her order history");
    }


    @Test(enabled = true, description = "Search products", groups = "purchase_product")
    public void checkSearchTextBox() throws Exception {
        objPurchase = new PurchaseItem(driver);
        String result= objPurchase.checkSearch();
        Assert.assertTrue(result.contains("results have been found"));
        utils.addDescription("User can search by product in search box");

    }
    @Test(enabled = true, description = "Purchase product", groups = "purchase_product")
    public void doPurchage() throws Exception {

        objPurchase = new PurchaseItem(driver);
        String successMessage= objPurchase.purchaseItem();
        Assert.assertEquals(successMessage,"Your order on My Store is complete.");
        utils.addDescription("User can purchase a product successfully");

    }
}
