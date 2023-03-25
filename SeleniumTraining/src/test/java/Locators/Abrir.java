package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Abrir {
    private WebDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWhitClick() throws InterruptedException {

    }


    @Test
    public void DropDownWithSendKeys() throws InterruptedException {


    }

    @Test
    public void DropDownWithClaseSelect() throws InterruptedException {

    }

    @AfterTest
    public void TearDown() {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }
}