package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    private WebDriver driver;


    private final By naviagteToCartButton = By.xpath("//a[@id = 'nav-cart']");
    private final By proceedToBuyButton = By.xpath("//input[@name='proceedToRetailCheckout']");
    private final By deleteProductButton = By.xpath("//button[@class='a-declarative'][1]");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCart(){
        driver.findElement(naviagteToCartButton).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(){
        driver.findElement(deleteProductButton).click();
    }

    public boolean isProceedToBuyBtnDisplayed(){

        return driver.findElement(proceedToBuyButton).isDisplayed();

    }

    public boolean productDeletedMessageDisplayed(){
        return  driver.findElement(By.xpath("//div[@class='sc-list-item-removed-msg']")).isDisplayed();
    }
}
