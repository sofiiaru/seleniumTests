package tests;

import drivers.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.Iterator;
import java.util.Set;

public class TestingIframes {
    @Test
    public void testIframe1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.toolsqa.com/iframe-practice-page/");

        driver.switchTo().frame("IF1");

        WebElement link = driver.findElement(By.partialLinkText("ISTQB Exam Sample Question"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", link);

        WebElement errorMessageToVerify = driver.findElement(By.xpath("//ol/li[text()='Error 404']"));
        Assert.assertTrue(errorMessageToVerify.isDisplayed());

        driver.switchTo().parentFrame();
        //ol/li[text()='Error 404']

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("devxschool@gmail.com"+ Keys.ENTER);
        //driver.findElement(By.xpath("//input[@value='Subscribe']")).click();
        String parentWindow = driver.getWindowHandle();
        Set<String> openWindows = driver.getWindowHandles();

        Iterator<String> iter = openWindows.iterator();
        while(iter.hasNext()){
            String childWindow = iter.next();
            if(!childWindow.equals(parentWindow))
                driver.switchTo().window(childWindow);
        }

        String email = driver.findElement(By.xpath("//div[@class='error message']/following-sibling::p/strong")).getText();
        Assert.assertEquals("Email displayed is not the same as input", "devxschool@gmail.com", email);

        driver.close();
        driver.quit();
    }
}
