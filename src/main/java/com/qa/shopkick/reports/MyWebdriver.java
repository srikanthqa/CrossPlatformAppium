package com.qa.shopkick.reports;

import com.qa.shopkick.utils.QaConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mmadhusoodan on 10/30/15.
 */
public class MyWebdriver {

    public static Logger log = Logger.getLogger(MyWebdriver.class);
    private static String userName = "manish@shopkick.com";
    private static String password = "shopkick123";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);
        WebDriver driver = new ChromeDriver();
        try {
            // declaration and instantiation of objects/variables


            WebDriverWait wait = new WebDriverWait(driver, 5);
            driver.navigate().to("http://shopkick.testlodge.com/projects/10019/runs/176127");
            driver.manage().window().maximize();

            driver.findElement(By.name("email")).sendKeys(userName);
            driver.findElement(By.name("password")).sendKeys(password);

            driver.findElement(By.className("submit")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("second")));

            assertEquals("Welcome", driver.findElement(By.className("first")).getText().trim());
            log.info(driver.findElement(By.className("first")).getText() + " " + driver.findElement(By.className("second")).getText());
            String a = driver.findElement(By.className("test_run")).getText().trim();

            assertEquals("Report NOT Complete", "Complete", driver.findElement(By.className("details")).getText().trim());

            String notRun = driver.findElements(By.className("count_cont")).get(0).getText().trim();
            String pass = driver.findElements(By.className("count_cont")).get(1).getText().trim();
            String fail = driver.findElements(By.className("count_cont")).get(2).getText().trim();

            log.info(pass);
            // exit the program explicitly
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }
}
