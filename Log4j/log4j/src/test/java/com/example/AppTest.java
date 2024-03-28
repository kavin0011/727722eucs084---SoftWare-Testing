package com.example;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest {
        // public static Logger logger = LogManagero.getLogger(AppTest.class);
        public static Logger logger = LogManager.getLogger(AppTest.class);

        @Test
        public void shouldAnswerWithTrue() throws Exception {
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.moneycontrol.com/");
                Thread.sleep(5000);
                driver.manage().window().maximize();
                Thread.sleep(5000);
                // driver.switchTo().alert().dismiss();
                // Thread.sleep(4000);
                driver.findElement(By.xpath("//*[@id=\"search_str\"]")).sendKeys("Reliance Industry Ltd", Keys.ENTER);
                Actions action = new Actions(driver);
                WebElement hovarable = driver.findElement(By.linkText("Mutual Funds"));
                action.moveToElement(hovarable).perform();
                Thread.sleep(2000);
                logger.warn("Warning");
                driver.navigate().to("https://www.moneycontrol.com/mf/sipcalculator.php");
                Thread.sleep(5000);
                action.sendKeys(Keys.ARROW_DOWN).perform();
                action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
                try {
                        driver.switchTo().alert().dismiss();
                } catch (Exception e) {
                        System.out.print(e);
                }
                driver.findElement(By.className("dropbox_asset")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"ff_id\"]/option[3]")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("im_id")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"im_id\"]/option[2]")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("invamt")).sendKeys("100000");
                Thread.sleep(1000);
                driver.findElement(By.id("stdt")).sendKeys("2021-08-02");
                Thread.sleep(1000);
                driver.findElement(By.id("endt")).sendKeys("2023-08-17");
                Thread.sleep(1000);
                driver.findElement(By
                                .xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input"))
                                .click();
                String a = driver
                                .findElement(
                                                By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[2]"))
                                .getText();
                String b = driver
                                .findElement(
                                                By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[3]/div[2]/div[6]/table/tbody/tr[1]/td[2]"))
                                .getText();
                System.out.println("Investment period " + a);
                System.out.println("Total Amount Invested (Rs) " + b);

                try {
                        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        String filePath = "D:\\SoftWareTesting\\log4j\\image\\test.png";
                        // Files.copy(screenShotFile.toPath(), new File(filePath).toPath());
                        // Files.copy(screenShotFile.toPath(), new File(filePath).toPath());
                        Files.copy(screenShotFile, new File(filePath));
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }
}
