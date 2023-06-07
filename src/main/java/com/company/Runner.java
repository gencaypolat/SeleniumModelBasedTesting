package com.company;

import com.company.SomeSmallTest;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
    System.setProperty("webdriver.chrome.driver", "/Users/gencaypolat/Documents/selenium libraries/drivers/chromedriver_mac64/chromedriver");
    TestExecutor executor = new TestExecutor(
            //loginFunctionalityTest.class
            //searchProductTest.class
            //addToCartTest.class
            addToWishListTest.class
    );

    Result result = executor.execute(true);
    System.out.println("Done: [" + result.getResults().toString(2) + "]");
  }
}
