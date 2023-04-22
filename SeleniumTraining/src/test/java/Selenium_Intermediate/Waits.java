package Selenium_Intermediate;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

  @Test@Ignore
    public void ExplicitWait() {
        //Dentro de las esperas explicitas al igual que las explicites, el tiempo de espera finaliza hasta que se cumnplan la
        //condicion o el tiempo de espera se agote, cuando esto sucede nos regresa la excepcion "ElementNotVisible"

        //Explicit Wait
        //1.- Thread.seleep (Thread,sleep(3000)) -- no pertence a selenium, pertenece al lenguaje de programacuion Java
        //2.- WebDariverWait
         //Antes de realizar cualqiier operacion,esperar una determiada posocion antes de proceder con el codigo
        // Espere a que webDriver verifique si el elemento existe o pueda operar sobre el, por ejemplo:
            // que sea visible
            // que este habilitado
            // que este desabilitado
            // o que pueda hacer clic

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickMe = driver.findElement(By.className("btn btn-default"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-default")));

        //AlertPresent
        //Espera unicamente cuando la alerta esta presente en la pgina
        wait.until(ExpectedConditions.alertIsPresent());
    }



   @Test@Ignore
    public void alertPresent()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //alertPresent
        //Espera ubicamente cuando la alerta esta presente en la pagina
        //wait.until(ExppectConditions.alertPresent)
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Con este codiugo podemos crear alertas
        js.executeScript("alert('mi alerta');");
        wait.until(ExpectedConditions.alertIsPresent());
        String alerta = driver.switchTo().alert().getText();
        System.out.println("alerta: " + alerta);
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void WaitElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement clickMe = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));

        //elemntTaBeClickCable
        //esta condicion funciona por ejemplo con los siguientes elementos: inputs, botones, etc etc
        //wait.until(ExpectedConditions.elementToBeClickable(clickMe));

        //ElementToBeSelected
        //esta condicion funciona or ejemplo con los siguientes elementos: Radio button, checkbox
       //wait.until(ExpectedConditions.elementToBeSelected(clickMe));

        //precenceofAllEelementsLocatedBy
       // By click = By.xpath("//button[@onclick='myAlertFuncion()']");
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By)click));

        //textToBePresentInElement
       // wait.until(ExpectedConditions.textToBePresentInElement(clickMe, "Click mes"));

    }
    @Test
    public void PageLoadTimeOut(){
        //Determins laa cantidad de tiempo de espera para que la pagoina se complete la carga de la pagina
    }
    @AfterTest
    public void TearDown() {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }
}

