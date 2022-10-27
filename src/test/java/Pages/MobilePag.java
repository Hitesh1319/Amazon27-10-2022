package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Enum.MobilePage;
import Enum.Mobile;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MobilePag {
    WebDriver driver;
    WebDriverWait wait;

    String mobile = "//div[@class='%s']//img[@alt='%s']";
    String mobileDetail = "//a[@id='%s' and @class='%s']";
    String printMobileDetail = "//div[@class='%s']";
    String productColourXpath = "//div[@id='%s']//ul//li";
    String variantDetail = "//div[@class='%s']";
    String questionAndAnswer = "//a[@id='%s']";
    By questionAndAnswerLink= By.xpath("//a[@id='askATFLink']");
    By seeMoreQuestionAndAnswer=By.linkText("See more answered questions (848)");
    By addToCartButton=By.xpath("//input[@id='add-to-cart-button']");
    By clickOnCart =By.xpath("//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce']");

    public MobilePag(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickingOnMobile() {
        driver.findElement(By.xpath(String.format(mobile, MobilePage.samsungGalaxyM32.getTitle(), MobilePage.samsungGalaxyM32.getValue()))).click();
    }

    public void printingMobile() {
        String mainWindow = driver.getWindowHandle();
        ArrayList<String> childTabWindow = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(mainWindow);
        System.out.println(childTabWindow);
        driver.switchTo().window(String.valueOf(childTabWindow.get(1)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(mobileDetail, MobilePage.mobileDetail.getTitle(), MobilePage.mobileDetail.getValue()))));
        driver.findElement(By.xpath(String.format(mobileDetail, MobilePage.mobileDetail.getTitle(), MobilePage.mobileDetail.getValue())));
        List<WebElement> myElements = driver.findElements(By.xpath(String.format(String.format(printMobileDetail, Mobile.productTitle.getTitle()))));
        for (WebElement e : myElements) {
            System.out.println(e.getText());
        }
    }

    public void printingColourAndVariant() {
        List<WebElement> productColour;
        By productColourValueDisplayed = By.xpath("//div[@id='variation_color_name']//label[@class='a-form-label']//following::span[1]");
        productColour = driver.findElements(By.xpath(String.format(productColourXpath, Mobile.productColour.getTitle())));
        int numberOfProductColour = productColour.size();
        System.out.println(numberOfProductColour);
        for (int j = 0; j < numberOfProductColour; j++) {
            Actions action = new Actions(driver);
            action.moveToElement(productColour.get(j)).perform();
            String productColourValue = driver.findElement(productColourValueDisplayed).getText();
            System.out.println(productColourValue);
        }
        List<WebElement> myElement = driver.findElements(By.xpath(String.format(String.format(variantDetail,Mobile.variantDetail.getTitle()))));
        for(WebElement f : myElement) {
            System.out.println(f.getText());
        }
    }

    public void navigateToCustomersQuestionAndAnswer() {
       driver.findElement(questionAndAnswerLink).click();
       wait.until(ExpectedConditions.elementToBeClickable(seeMoreQuestionAndAnswer));
       driver.findElement(seeMoreQuestionAndAnswer).click();
        List<WebElement> myElement = driver.findElements(By.xpath("//div[@class='a-fixed-left-grid-col a-col-right' and @style='padding-left:0%;float:left;']"));
        int count =0;
        for(WebElement g : myElement) {
            System.out.println(g.getText());
            count++;
            if(count==6){
                break;
            }
        }
    }

    public void clickingOnAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCart));
        driver.findElement(clickOnCart).click();
    }
}