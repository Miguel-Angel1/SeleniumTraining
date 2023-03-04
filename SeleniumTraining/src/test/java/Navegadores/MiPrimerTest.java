package Navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MiPrimerTest {
    private WebDriver driver;

    @BeforeTest // TODAS las pruebas se ejecutan antes de cada prueba
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        //Se crea la instancia del driver
        driver = new ChromeDriver();

        //maximiza la pantalla
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");

    }

    @Test /// Durante cada prueba se ejecuta una prueba
    public void PrimerTest() throws InterruptedException {
        WebElement sigOn = driver.findElement(By.id("mouseOut"));
        Thread.sleep(2000);
        sigOn.click();
    }


    @AfterTest //Final de la prueba
    public void Teardown() {
        driver.close();
        driver.quit();
    }
}
