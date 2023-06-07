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

public class loginFunctionalityTest extends ExecutionContext implements loginFunctionality {
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
        //WebElement myAccount = driver.findElement(By.cssSelector("a[class=\"dropdown-toggle\"][data-bs-toggle=\"dropdown\"][aria-expanded=\"false\"] > span[class=\"d-none d-md-inline\"]"));
        //action.moveToElement(profileIcon).build().perform();
        //myAccount.click();
        //WebElement loginButton = driver.findElement(By.cssSelector("a[href=\"https://demo.opencart.com/index.php?route=account/login&language=en-gb\"]"));
        //action.moveToElement(loginButton).build().perform();
        //loginButton.click();

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
        //WebElement login = driver.findElement(By.xpath("//button[@type='submit' and text()='Login']"));
        //login.click();
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
    public void e_logout() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        WebElement dropdownToggle = driver.findElement(By.cssSelector(".list-inline .dropdown-toggle"));
        dropdownToggle.click();
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
    }
    @Override
    public void v_closeAccount() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        String pageTitle = driver.getTitle();
        String expectedTitle = "Account Logout";
        testTitle(expectedTitle, pageTitle);
    }

    @Override
    public void e_clickContinue() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        WebElement continueButton = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        continueButton.click();
    }
    @Override
    public void e_reLogin() {
        System.out.println("\033[0;107m" + "\033[1;95m" + "----------RUNNING " + Thread.currentThread().getStackTrace()[1].getMethodName().toUpperCase() + "----------" + "\033[1;95m" + "\033[0;107m");
        driver.findElement(By.cssSelector(".list-inline .dropdown-toggle")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @Test
    public void testTitle(String expectedTitle, String actualTitle) {
        System.out.println(expectedTitle);
        System.out.println(actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }

}
