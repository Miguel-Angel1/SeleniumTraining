package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox{
    private WebDriver driver;
    @BeforeTest // TODAS las pruebas se ejecutan antes de cada prueba
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //maximiza la pantalla
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }


    @Test
    public void checkBoxTest() throws InterruptedException {
        WebElement radioButtonMale = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));
        //isDisplayed: lo que nos regresa es un valor boolean, si devuelve vedadero entonces dicho botonn esta presente, si es falos entonces el boton no esta ppresente
        //isEnabled: lo que nos regresa es un valor boolean, si devuelve verdadero entonces dicho botonn esta presente, si es f
        //isSelected(): Lo que nos regresaue es un valor boolean, si devuelve verdadero entonces el boton esta seleccionado, si regresa falso

        boolean statusDisplayed = radioButtonMale.isDisplayed();
        boolean statusEnabled = radioButtonMale.isEnabled();
        boolean statusSelected = radioButtonMale.isSelected();

        System.out.println("Status Displayed:" + statusDisplayed);
        Thread.sleep(2000);
        System.out.println("Status Enabled:" + statusEnabled);
        Thread.sleep(2000);
        System.out.println("Status Selected:" + statusSelected);
        Thread.sleep(2000);

        radioButtonMale.click();
        Thread.sleep(1000);

    }

    @AfterTest //Final de la prueba
    public void Teardown() {
        driver.close();
        driver.quit();
    }
}
