package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.*;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import utils.base64;
import utils.Screenshot;
import uistore.Locators2;
import utils.excelReadFile;
import utils.Reporter;
public class Deposit  {

    private Map<String, String> testData; 

    java.util.logging.Logger log = LoggerHandler.getLogger();
    base64 screenshotHandler = new base64();
    ExtentReports reporter = Reporter.generateExtentReport();
    excelReadFile file = new excelReadFile();

public void Deposit_Amount(WebDriver driver)throws IOException {
            
            Map<String, String> testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
            String depositAmount = testData.get("depositAmount");

            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            WebElement depositLink = wait.until(ExpectedConditions.elementToBeClickable(Locators2.depositLink));
            depositLink.click();
            Select accType=new Select(driver.findElement(Locators2.accType));
            log.info("Account Type has been selected");
            accType.selectByVisibleText("Individual Checking (Standard Checking)");
            driver.findElement(Locators2.amount).sendKeys(depositAmount);
            log.info("Amount has been sent");
            driver.findElement(By.xpath(Locators2.submitAcc)).click();

        
    }
}