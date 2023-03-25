package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
    private WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
    }

   /* @Test
    public void DrangAndDrop() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//span[contains(text(), 'Draggable 1')]")); //Seleccionar drag
        WebElement drop = driver.findElement(By.id("mydropzone"));
       /* actions.dragAndDrop(drag, drop).build().perform(); //Hacer drag y drop con los valores de la posicion
        Thread.sleep(6000);*/

       /* //Segunda funcion
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .build()
                .perform();
        Thread.sleep(6000);
    }*/

    @Test//Dentro de un frame
    public void DrangAndDropIFrame() throws InterruptedException {
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .build()
                .perform();
        Thread.sleep(6000);
    }


    @AfterTest
    public void TearDown() {
        //Cierra el navegador
        driver.close();
        driver.quit();
    }

}
