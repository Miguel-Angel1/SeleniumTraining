package Interacciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Interacciones {
    private WebDriver driver;

    @BeforeTest // TODAS las pruebas se ejecutan antes de cada prueba
    public void Setup() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        //Se crea la instancia del driver
        driver = new ChromeDriver();
        //maximiza la pantalla
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @Test
    public void Interacciones() throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.clear();
        userName.sendKeys("admin");
        Thread.sleep(2000);
        userName.clear();
        Thread.sleep(2000);
        userName.sendKeys("Hola");
        Thread.sleep(2000);
    }

    @AfterTest //Final de la prueba
    public void Teardown() {
        driver.close();
        driver.quit();
    }
}

