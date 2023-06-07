package com.company;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class searchProductTest extends ExecutionContext implements searchProduct{

    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options.addArguments("--remote-allow" + "-origins=*", "--start" + "-maximized"));
    Actions action = new Actions(driver);

    String homeURL = "http://tutorialsninja.com/demo/";

    @Override
    public void v_StartVertex() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Override
    public void e_goHomePage() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");

        driver.get(homeURL);
    }
    @Override
    public void v_homePage() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        String pageTitle = driver.getTitle();
        String expectedTitle = "Your Store";
        testHeader(expectedTitle, pageTitle);
    }
    @Override
    public void e_goSelectedCategory() {
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
    }

    @Override
    public void v_selectedCategoryPage() {
        String actualHeader = driver.findElement(By.xpath("//div[contains(@class,'col-sm-9')]/h2")).getText();
        String expectedHeader = "Mac";
        testHeader(expectedHeader, actualHeader);
    }

    @Override
    public void e_goBackHomePage() {
        WebElement qafoxLink = driver.findElement(By.xpath("//div[@id='logo']//a[contains(text(),'Qafox.com')]"));
        qafoxLink.click();
    }
    @Override
    public void e_goSelectedProduct() {
        driver.findElement(By.cssSelector(".image .img-responsive")).click();
    }
    @Override
    public void v_selectedProduct() {
        String actualHeader = driver.findElement(By.xpath("//div[contains(@class,'col-sm-4')]/h1")).getText();
        String expectedHeader = "iMac";
        testHeader(expectedHeader, actualHeader);
    }
    @Override
    public void e_goBackSelectedCategory() {
        driver.findElement(By.linkText("Mac")).click();
        driver.findElement(By.linkText("Desktops")).click();
    }

    @Test
    public void testTitle(String expectedTitle, String actualTitle) {
        System.out.println(expectedTitle);
        System.out.println(actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void testHeader(String expectedHeader, String actualHeader) {
        System.out.println(expectedHeader);
        System.out.println(actualHeader);
        assertEquals(expectedHeader, actualHeader);
    }


}
