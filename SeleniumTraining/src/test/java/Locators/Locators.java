package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators {

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
    public void Test() throws InterruptedException {

        /* Por id
            WebElement demoSite = driver.findElement(By.id("site-name"));
            demoSite.click();
            Thread.sleep(2000);
            */

            /* Por Name
            WebElement userName = driver.findElement(By.name("userName"));
            userName.sendKeys("Miguel");
            Thread.sleep(6000);*/

            /* Por Clase
            WebElement logo = driver.findElement(By.className("logo"));
            logo.click();
            Thread.sleep(6000);*/
        /*
        WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep();*/

        /*
        WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(6000);
        */

        /* Por cssLocatro
        WebElement userName = driver.findElement(By.cssSelector("input[name='userName']"));
        WebElement userName1 = driver.findElement(By.cssSelector("div#site-name"));
        WebElement userName2 = driver.findElement(By.cssSelector("#site-name"));

        WebElement userName = driver.findElement(By.cssSelector("input[type='Text'][name='userName']"));
        */
        //**************************XPATh********************
        //Existen tipos de xpaths: absolutas y relativo
        //El xpath absoluto es toda la ruta del elemenyo, es decir la ubicacion del mismo, solo usarlo cuando algo bno cambiara

        




    }

    @AfterTest //Final de la prueba
    public void Teardown() {
        driver.close();
        driver.quit();
    }
}


