package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    String expectedResult="Samsung Galaxy M13 (Midnight Blue, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus";
    By productVerify = By.xpath("//span[@class='a-truncate-cut']");
    By quantity = By.xpath("//span[@class='a-button-text a-declarative']");
    By quantityDrop = By.xpath("//li[@aria-labelledby='quantity_4']");
    By subTotal = By.xpath("//div[@data-name='Subtotals' and @class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']");
    By checkBoxInput = By.xpath("//input[@id='sc-buy-box-gift-checkbox']");
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyProductAdded() {
        String VerifingProduct = driver.findElement(productVerify).getText();
        Assert.assertEquals(VerifingProduct,expectedResult);
    }

    public void increasingQuantity() {
        driver.findElement(quantity).click();
        wait.until(ExpectedConditions.elementToBeClickable(quantityDrop));
        driver.findElement(quantityDrop).click();
    }

    public void verifyTheItemQuantityAndListTheTotal() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBoxInput));
        driver.findElement(checkBoxInput).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(subTotal));
        String subtotalPrint = driver.findElement(subTotal).getText();
        System.out.println(subtotalPrint);
    }
}