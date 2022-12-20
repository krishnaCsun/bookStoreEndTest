package bookstore.tests;

import bookstore.util.LoggerUtil;
import bookstore.util.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddBooksTest extends BaseTest{


    @Test
    void loginAsAdminAndAddBooksTest() throws InterruptedException {
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


        //--------------------------------------- Add Books Scenario

        Thread.sleep(250);
        //Click on Add Books
        WebElement addBooksBtn= driver.findElement(By.linkText("ADD BOOKS"));
        addBooksBtn.click();
        LoggerUtil.log("Clicked on Add Books");

//        driver.findElement(By.id("bookCode")).click();

        Random random = new Random();

        //Enter Book Code
        WebElement bookCode= driver.findElement(By.id("bookCode"));
        String code="Code "+random.nextInt(300);
        bookCode.sendKeys(code);

        //Enter Book Name
        WebElement bookName= driver.findElement(By.id("bookName"));
        String bname="Name "+random.nextInt(300);
        bookName.sendKeys(bname);

        //Enter Book Author
        WebElement bookAuthor= driver.findElement(By.id("bookAuthor"));
        String bAuthor="Author "+random.nextInt(300);
        bookAuthor.sendKeys(bAuthor);


        //Enter Book Author
        WebElement bookQuantity= driver.findElement(By.id("bookQuantity"));
        String bQuantity=""+random.nextInt(300);
        bookQuantity.sendKeys(bQuantity);


        //Enter Book Author
        WebElement price= driver.findElement((By.name("price")));
        String bPrice= ""+random.nextInt();
        price.sendKeys(bPrice);

        //Click on Add Book
        driver.findElement(By.cssSelector(".AddBooks")).click();

        //Book Added Succesfully
        WebElement bookAdded= driver.findElement(By.xpath("//div[contains(text(),\"Updated Successfully\")]"));
        Assert.assertEquals(bookAdded.getText(),"Book Detail Updated Successfully!\n" +
                "Add More Books");
        Assert.assertTrue(bookAdded.isDisplayed());
        LoggerUtil.log("Book Added Successful-------- TC Passed");


    }

}
