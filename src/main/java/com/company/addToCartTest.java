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
import java.util.List;

import static org.junit.Assert.assertEquals;

public class addToCartTest extends ExecutionContext implements addToCart{

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
        String title = driver.getTitle();
        String expectedTitle = "Your Store";
        testTitle(expectedTitle, title);
    }
    @Override
    public void e_goLoginPage() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");

        driver.findElement(By.cssSelector(".list-inline .dropdown-toggle")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @Override
    public void v_loginPage() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");

    }
    @Override
    public void e_typeCredentials() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.click();
        emailInput.sendKeys("gencay.polat@boun.edu.tr");
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.click();
        passwordInput.sendKeys("ali1234");
        driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
    }
    @Override
    public void v_openAccount() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");

        String pageTitle = driver.getTitle();
        String expectedTitle = "My Account";
        testTitle(expectedTitle, pageTitle);
    }
    @Override
    public void e_selectCategory() {
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
    }
    @Override
    public void v_selectedCategory() {
        String actualHeader = driver.findElement(By.xpath("//div[contains(@class,'col-sm-9')]/h2")).getText();
        String expectedHeader = "Mac";
        testHeader(expectedHeader, actualHeader);
    }
    @Override
    public void e_selectProduct() {
        driver.findElement(By.cssSelector(".image .img-responsive")).click();
    }
    @Override
    public void v_selectedProduct() {
        String actualHeader = driver.findElement(By.xpath("//div[contains(@class,'col-sm-4')]/h1")).getText();
        String expectedHeader = "iMac";
        testHeader(expectedHeader, actualHeader);
    }
    @Override
    public void e_addProductToCart() {
        driver.findElement(By.id("button-cart")).click();
    }
    @Override
    public void v_cartProducts() {
        alertTest();
    }
    @Override
    public void e_viewCart() {
        driver.findElement(By.cssSelector("a > .fa-shopping-cart")).click();
    }
    @Override
    public void v_cart() {
        testProductInCart();
    }
    @Override
    public void e_removeProduct() {
        driver.findElement(By.cssSelector(".fa-times-circle")).click();
        driver.findElement(By.cssSelector("a > .fa-shopping-cart")).click();
    }

    @Override
    public void v_emptyCart() {
        String actualHeader = driver.findElement(By.xpath("//div[contains(@class,'col-sm-12')]/p")).getText();
        String expectedHeader = "Your shopping cart is empty!";
        testHeader(expectedHeader, actualHeader);
    }

    @Override
    public void e_goBackHomePage() {
        WebElement qafoxLink = driver.findElement(By.xpath("//div[@id='logo']//a[contains(text(),'Qafox.com')]"));
        qafoxLink.click();
    }

    @Override
    public void v_NewVertex() {

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
    @Test
    public void alertTest() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".alert"));
        assert (elements.size() > 0);
    }
    @Test
    public void testProductInCart() {
        List<WebElement> elements = driver.findElements(By.cssSelector("tbody:nth-child(2) .img-thumbnail"));
        assert (elements.size() > 0);
    }

}
