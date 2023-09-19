package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pages.Deposit;
import pages.Withdraw;
import pages.homepage;
import utils.base64;
import utils.Screenshot;
import utils.Base;
import utils.EventHandler;
import utils.Reporter;
// import utils.Screenshot;
public class Testcase1 extends Base {

    java.util.logging.Logger log =  LoggerHandler.getLogger();
    base64 screenshotHandler = new base64();
    ExtentReports extent = new ExtentReports();
    homepage Homepage = new homepage();
    Deposit deposit = new Deposit();
    Withdraw withdraw = new Withdraw(); 
    
    @Test(priority = 1)
    public void TC_001() throws IOException {  
        ExtentTest test = extent.createTest("Your Test Case");
            driver.get(prop.getProperty("url"));
            Homepage.Valid_Login_TC(driver,test);      
    }    

@BeforeMethod
public void beforeMethod() throws MalformedURLException {
    openBrowser();
    extent = Reporter.generateExtentReport();


}

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        extent.flush();
        log.info("Browser closed");
        LoggerHandler.closeHandler();
    }
}

