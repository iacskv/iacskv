package Application;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

    public class  t1{
        FirefoxDriver wd;

        @BeforeMethod
        public void setUp() throws Exception {
            FirefoxBinary binary = new FirefoxBinary(new File("C:\\Mozilla Firefox\\firefox.exe"));
            wd = new FirefoxDriver(binary, new FirefoxProfile());
            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

    @Test
    public void yaTest() {
            wd.get("https://yandex.ru/");
            wd.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/span/span/input")).click();
            wd.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/span/span/input")).clear();
            wd.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div[1]/span/span/input")).sendKeys("gjbcr");
            wd.findElement(By.xpath("html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[2]/div/form/div[2]/button")).click();
        }

        @AfterMethod
        public void tearDown() {
            wd.quit();
        }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
