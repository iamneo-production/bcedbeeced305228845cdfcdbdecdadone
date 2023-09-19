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
import java.util.logging.Level;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
// import utils.base64;
import utils.Screenshot;
import uistore.Locators1;
import utils.excelReadFile;
import utils.Reporter;
public class homepage  {

    private Map<String, String> testData; 

    java.util.logging.Logger log = LoggerHandler.getLogger();
    // base64 screenshotHandler = new base64();
    ExtentReports reporter = Reporter.generateExtentReport();
    excelReadFile file = new excelReadFile();

    
    
    public void Valid_Login_TC(WebDriver driver) throws IOException {
        Map<String, String> testData = excelReadFile.readTestData("/home/coder/project/workspace/Project/testdata/Testdata.xlsx", "Sheet1");
        String username = testData.get("userame");
        String password = testData.get("password");
        ExtentTest test = reporter.createTest("Deposit_Amount Test", "Execution for Deposit_Amount Function");
    
        try {   
            test.log(Status.PASS, " Browser opened");
            try {
                driver.findElement(Locators1.username).sendKeys(username);
                test.log(Status.PASS, "Enter Username");
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "UsernameEntryError");
                test.fail("Failed to Enter Username", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        
            }
    
            try {
                driver.findElement(Locators1.password).sendKeys(password); 
                test.log(Status.PASS, "Enter Password");
            } catch (Exception ex) {
                ex.printStackTrace();
                test.log(Status.FAIL, "Enter Password");
            }
    
            try {
                driver.findElement(Locators1.submit).click();
                test.log(Status.PASS, "Click on submit");
            } catch (Exception ex) {
                ex.printStackTrace();
                test.log(Status.FAIL, "Click on submit");
            }
    
            test.log(Status.PASS, " Browser closed");
    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
} 



