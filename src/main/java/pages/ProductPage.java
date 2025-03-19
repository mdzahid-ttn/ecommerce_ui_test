package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage {
    private WebDriver driver;

    private final By listItemName = By.xpath("//div[@role = 'listitem'][1]//span[contains(text(),'iPhone 16e')]");
    private final By listItemPrice = By.xpath("//div[@role = 'listitem'][1]//span[@class='a-price-whole']");
    private final By listItemAddToCartButton = By.xpath("//div[@role = 'listitem'][1]//button[@name='submit.addToCart']");

    private final By list2ItemName = By.xpath("//div[@role = 'listitem'][2]//span[contains(text(),'OnePlus 13')]");
    private final By list2ItemPrice = By.xpath("//div[@role = 'listitem'][2]//span[@class='a-price-whole']");
    private final By list2ItemAddToCartButton = By.xpath("//div[@role = 'listitem'][2]//button[@name='submit.addToCart']");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void productDetails(){
        String productName = driver.findElement(listItemName).getText();
        String productPrice = driver.findElement(listItemPrice).getText();
        System.out.println("Product name: "+productName);
        System.out.println("Product price: "+productPrice);

    }

    public void addProductToCart(){
        scrollToElement(driver.findElement(listItemAddToCartButton));

        driver.findElement(listItemAddToCartButton).click();
    }





    public void product2Details(){
        String productName = driver.findElement(list2ItemName).getText();
        String productPrice = driver.findElement(list2ItemPrice).getText();
        System.out.println("Product name: "+productName);
        System.out.println("Product price: "+productPrice);

    }

    public void addProduct2ToCart(){
        scrollToElement(driver.findElement(list2ItemAddToCartButton));

        driver.findElement(list2ItemAddToCartButton).click();
    }
}
