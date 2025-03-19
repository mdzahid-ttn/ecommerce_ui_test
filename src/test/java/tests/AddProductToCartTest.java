package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class AddProductToCartTest extends BaseClass {
private HomePage homePage;
private ProductPage productPage;
private ShoppingCartPage shoppingCartPage;

    @BeforeMethod
    public void start() {

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

        System.out.println("Test called");
    }

    @Test(priority = 1, description = "Verify user can add product to the cart successfully")
    public void verifyAddProductToCart() {

        homePage.searchBar();
        homePage.searchProduct();
        productPage.productDetails();
        productPage.addProductToCart();
        shoppingCartPage.navigateToCart();

        Assert.assertTrue(shoppingCartPage.isProceedToBuyBtnDisplayed(),"'Proceed To Buy' button is not visible");

    }


    @Test(priority = 2, description = "Try deleting item")
    public void testRemovalProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        homePage.searchBar();
        homePage.searchProduct();
        productPage.productDetails();
        productPage.addProductToCart();
        shoppingCartPage.navigateToCart();
        shoppingCartPage.deleteProduct();

        Assert.assertTrue(shoppingCartPage.productDeletedMessageDisplayed(),"Product not deleted");
    }


    @Test(priority = 3, description = "Add multiple product to the cart and remove product")
    public void addTwoProductAndDelete() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);


        homePage.searchBar();
        homePage.searchProduct();
        productPage.productDetails();
        productPage.addProductToCart();

        homePage.searchBar();
        homePage.searchProduct2();
        productPage.product2Details();
        productPage.addProduct2ToCart();

        shoppingCartPage.navigateToCart();
        shoppingCartPage.deleteProduct();


        Assert.assertTrue(shoppingCartPage.productDeletedMessageDisplayed(),"Product 1 deleted");
    }

}
