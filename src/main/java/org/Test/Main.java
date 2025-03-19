package org.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductPage;
import pages.HomePage;
import pages.ShoppingCartPage;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        ProductPage productPage = new ProductPage(driver);
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        homePage.searchBar();
        homePage.searchProduct();
        productPage.productDetails();
        productPage.addProductToCart();
        shoppingCartPage.navigateToCart();
        shoppingCartPage.deleteProduct();

        WebElement cartPageHeader = driver.findElement(By.xpath("//h2[contains(text(),'Shopping')]"));
        WebElement proceedToBuyButton = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));


         By deleteProductButton = By.xpath("//button[@class='a-declarative'][1]");
         driver.findElement(deleteProductButton).getText();


//        System.out.println(text);
    }
}