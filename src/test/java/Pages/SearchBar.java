package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Enum.Mobile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class SearchBar {
    WebDriver driver;
    WebDriverWait wait;
    public static String path;

    String searchInput = "//input[@id='%s']";

    public SearchBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchMobile() throws IOException {
        path = System.getProperty("user.dir") + "//src//test//java//TestData//Credential.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String samsungMobile = sheet.getRow(1).getCell(0).getStringCellValue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))));
        driver.findElement(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))).sendKeys(samsungMobile);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(searchInput, Mobile.searchInput.getTitle()))));
        driver.findElement(By.xpath(String.format(searchInput,Mobile.searchButton.getTitle()))).click();
    }
}