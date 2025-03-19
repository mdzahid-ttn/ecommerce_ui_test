package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class HomePage {
    private WebDriver driver;

    private final By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchButton = By.xpath("//input[@id = 'nav-search-submit-button']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void searchBar(){


        try {
            if (Objects.requireNonNull(driver.getPageSource()).contains("Enter the characters you see below")){
            Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(searchBox)));

        driver.findElement(searchBox).click();


    }


    public void searchProduct(){

        driver.findElement(searchBox).sendKeys("iPhone 16e");
        driver.findElement(searchButton).click();
    }

    public void searchProduct2(){
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys("Oneplus 13");
        driver.findElement(searchButton).click();
    }
}
