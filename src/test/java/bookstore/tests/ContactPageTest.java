package bookstore.tests;

import bookstore.util.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactPageTest extends BaseTest{
    @Test
    void visitCOntactPageAndVerifyDetails() throws InterruptedException {
        String homePage = TestProperties.getProperty("hostURL")+TestProperties.getProperty("homeURL");

        // Navigate to Home Page
        driver.get(homePage);

        Thread.sleep(250);
        //Find element Contact Button
        WebElement contactPageButton=driver.findElement(By.xpath("//a[@class=\"button\" and text()=\"Contact\"]"));
        //CLick on Contact Page
        contactPageButton.click();

        Thread.sleep(250);
        //Verify Heading
        WebElement contactHeading= driver.findElement(By.xpath("//*[text()=\"Contact Info\"]"));
        Assert.assertEquals(contactHeading.getText(),"Contact Info");

        Thread.sleep(250);
        //Verify ContactInfos
        WebElement contactInfo= driver.findElement(By.xpath("//*[text()=\"Call : 747-366-XXXX\"]"));
        Assert.assertEquals(contactInfo.getText(),"Call : 747-366-XXXX");

    }
}
