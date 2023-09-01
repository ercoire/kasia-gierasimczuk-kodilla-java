package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static void main(String[] args) throws InterruptedException {

        final String XPATH_COOKIES = "//button[contains(text(), 'Zezwól na wszystkie')]";
        final String XPATH_NEW_ACCOUNT = "//a[@ajaxify=\"/reg/spotlight/\"]";
        final String XPATH_FORM_FIRSTNAME = "//input[@name='firstname']";
        final String XPATH_FORM_LASTNAME = "//input[@name='lastname']";
        final String XPATH_FORM_EMAIL = "//input[@name='reg_email__']";
        final String XPATH_FORM_REPEAT_EMAIL = "//input[@name='reg_email_confirmation__']";
        final String XPATH_FORM_PASSWORD = "//input[@name='reg_passwd__']";
        final String XPATH_FORM_BIRTHDATE_DAY = "//select[@id='day']";
        final String XPATH_FORM_BIRTHDATE_MONTH = "//select[@id='month']";
        final String XPATH_FORM_BIRTHDATE_YEAR = "//select[@id='year']";
        final String XPATH_FORM_GENDER = "//input[@value='1']";
        final String XPATH_FORM_SUBMISSION = "//button[@name='websubmit']";

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();

        //fill the form
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPATH_FORM_FIRSTNAME)).sendKeys("DummyFirst");
        Thread.sleep(1000);
        driver.findElement(By.xpath(XPATH_FORM_LASTNAME)).sendKeys("DummyLast");
        Thread.sleep(1000);
        driver.findElement(By.xpath(XPATH_FORM_EMAIL)).sendKeys("dummy@test.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPATH_FORM_REPEAT_EMAIL)).sendKeys("dummy@test.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPATH_FORM_PASSWORD)).sendKeys("dummy_pass111");
        Thread.sleep(2000);
        Select selectDay = new Select(driver.findElement(By.xpath(XPATH_FORM_BIRTHDATE_DAY)));
        selectDay.selectByValue("19");
        driver.findElement(By.xpath(XPATH_FORM_BIRTHDATE_DAY)).sendKeys("19");
        Thread.sleep(2000);
        Select selectMonth = new Select(driver.findElement(By.xpath(XPATH_FORM_BIRTHDATE_MONTH)));
        selectMonth.selectByValue("11");
        Thread.sleep(2000);
        Select selectYear = new Select(driver.findElement(By.xpath(XPATH_FORM_BIRTHDATE_YEAR)));
        selectYear.selectByValue("1968");
        Thread.sleep(2000);
        driver.findElement(By.xpath(XPATH_FORM_GENDER)).click();
        //  driver.findElement(By.xpath(XPATH_FORM_SUBMISSION)).click();
    }
}
