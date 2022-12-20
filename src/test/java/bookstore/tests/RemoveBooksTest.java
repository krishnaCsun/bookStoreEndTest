package bookstore.tests;

import bookstore.util.LoggerUtil;
import bookstore.util.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class RemoveBooksTest extends BaseTest{


    @Test
    void removeBooks() throws InterruptedException {
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


        // ---------------- Verify Books Added

        Thread.sleep(250);
        //Click Available Books Button
        WebElement availableBooks= driver.findElement(By.xpath("//a[text()=\"Available Books\"]"));
        availableBooks.click();
        LoggerUtil.log("Clicked on Available Books");


        // Main Asserts
        //1
        WebElement bookEle1= driver.findElement(By.xpath(("//td[text()=\""+code+"\"]")));
        Assert.assertTrue(bookEle1.isDisplayed());

        // Main Asserts
        //2
        WebElement bookEle2= driver.findElement(By.xpath("//td[text()=\""+bPrice+"\"]"));
        Assert.assertTrue(bookEle1.isDisplayed());

        // Main Asserts
        //3
        WebElement bookEle3= driver.findElement(By.xpath("//td[text()=\""+bQuantity+"\"]"));
        Assert.assertTrue(bookEle1.isDisplayed());

        // Main Asserts
        //4
        WebElement bookEle4= driver.findElement(By.xpath("//td[text()=\""+bAuthor+"\"]"));
        Assert.assertTrue(bookEle1.isDisplayed());

        // Main Asserts
        //5
        WebElement bookEle5= driver.findElement(By.xpath("//td[text()=\""+bname+"\"]"));
        Assert.assertTrue(bookEle1.isDisplayed());

        LoggerUtil.log("Book Successfully Added");


        //Remove Books

        // Navigate to Home Page
        driver.get("http://localhost:8080/onlinebookstore/AdminLogin.html");
        Thread.sleep(250);
//        //Login as Admin
//
//
//        driver.navigate().refresh();
//
//        try{
//            loginAsAdmin.click();
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Ignore Stale Elements");
//            loginAsAdmin.click();
//        }

//        LoggerUtil.log("Clicked on Login as Admin Button");

        Thread.sleep(250);
        //Enter UserName
        userName.sendKeys(TestProperties.getProperty("adminUsername"));
        LoggerUtil.log("Entered Username");


        //Enter Password
        password.sendKeys(TestProperties.getProperty("adminPassword"));
        LoggerUtil.log("Entered Password");

        Thread.sleep(250);
        //Click on Submit
        adminLoginBtn.click();
        LoggerUtil.log("Clicked on Login as Admin Button");

        Thread.sleep(250);
        //Login Heading Verification
        Assert.assertEquals(loginSuccess.getText(),"Admin login Successful");
        Assert.assertTrue(loginSuccess.isDisplayed());

        //Go to that Page
        WebElement removeBooksLink= driver.findElement(By.xpath("//a[text()=\"REMOVE BOOKS\"]"));
        removeBooksLink.click();


        //Enter Book Code
        WebElement bookCodeRemove= driver.findElement(By.xpath("//input[@id=\"bookCode\"]"));
        bookCodeRemove.sendKeys(code);
        LoggerUtil.log("Entered Code");

        Thread.sleep(250);
        //Click on Submit
        WebElement removeBook= driver.findElement(By.xpath("//input[@value=\"Remove Book\"]"));
        removeBook.click();
        LoggerUtil.log("Clicked on Remove Book");
        Thread.sleep(250);



        // ---------------- Verify BooksRemoved
        Thread.sleep(250);
        //Click Available Books Button
        availableBooks.click();
        LoggerUtil.log("Clicked on Available Books");

        // Main Asserts
        //1
        Assert.assertFalse(bookEle1.isDisplayed());

        // Main Asserts
        //2
        Assert.assertFalse(bookEle1.isDisplayed());

        // Main Asserts
        //3
        Assert.assertFalse(bookEle1.isDisplayed());

        // Main Asserts
        //4
        Assert.assertFalse(bookEle1.isDisplayed());

        // Main Asserts
        //5
        Assert.assertFalse(bookEle1.isDisplayed());

        LoggerUtil.log("Book Successfully Removed");



    }

}
