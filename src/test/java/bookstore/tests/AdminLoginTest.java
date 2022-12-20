package bookstore.tests;

import bookstore.util.LoggerUtil;
import bookstore.util.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminLoginTest extends BaseTest{


    @Test
    void adminLoginAndBasicView() throws InterruptedException {
        String homePage = TestProperties.getProperty("hostURL")+TestProperties.getProperty("homeURL");

        // Navigate to Home Page
        driver.get(homePage);
        Thread.sleep(250);
        //Verify Heading
        WebElement mainHeading1= driver.findElement(By.xpath("//*[text()=\"Welcome to Online \"]"));
        Assert.assertEquals(mainHeading1.getText(),"Welcome to Online\n" + "Book Store");
        LoggerUtil.log("Main Heading Visible");

        Thread.sleep(250);
        //Click Login Button
        WebElement loginButton= driver.findElement(By.xpath("//a[text()=\"Login\"]"));
        loginButton.click();
        LoggerUtil.log("Clicked on Login Button");

        Thread.sleep(250);
        //Login as Admin
        WebElement loginAsAdmin= driver.findElement(By.xpath("//a[text()=\"Login As Admin\"]"));
        loginAsAdmin.click();
        LoggerUtil.log("Clicked on Login as Admin Button");

        Thread.sleep(250);
        //Enter UserName
        WebElement userName= driver.findElement(By.xpath("//input[@id=\"userName\"]"));
        userName.sendKeys(TestProperties.getProperty("adminUsername"));
        LoggerUtil.log("Entered Username");


        //Enter Password
        WebElement password= driver.findElement(By.xpath("//input[@id=\"Password\"]"));
        password.sendKeys(TestProperties.getProperty("adminPassword"));
        LoggerUtil.log("Entered Password");

        Thread.sleep(250);
        //Click on Submit
        WebElement adminLoginBtn= driver.findElement(By.xpath("//input[@class=\"AdminLogin\"]"));
        adminLoginBtn.click();
        LoggerUtil.log("Clicked on Login as Admin Button");

        Thread.sleep(250);
        //Login Heading Verification
        WebElement loginSuccess= driver.findElement(By.xpath("//div[@class=\"tab\" and text()=\"Admin login Successful\"]"));
        Assert.assertEquals(loginSuccess.getText(),"Admin login Successful");
        Assert.assertTrue(loginSuccess.isDisplayed());
        LoggerUtil.log("Login Successful-------- TC Passed");

    }

}
