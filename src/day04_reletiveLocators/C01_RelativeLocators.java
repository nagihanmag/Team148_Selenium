package day04_reletiveLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.awt.*;
import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin

        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative
        //locator ile locate edip tiklayin
        Thread.sleep(5000);
        /*
        Relative locaror'u kullanmak icin
         hedef webelemente aitbir ozelligi bulmamiz gerekir
         bunun icin locate edecek gibi webelementi inceleyelim
         cikan sonuc
          id="pictext7" class="overlay" href="http://testotomasyonu.com/product/32">
      <img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
      <span>DSLR Camera</span></a>

      2. ise hedef webelementin etrafinda kullanabildigimiz bir webelementi
      locate edip kaydederiz


       */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


        WebElement motorTelefon = driver.findElement(By.id("pic8_thumb"));

        /*
        artik Relative Locator ile hedef elementi locate edip kaydedebiliriz

         */
       WebElement dslrCamera =  driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon));
       dslrCamera.click();
       //driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon)).click ;de yapabiliriz

         //3 ) Acilan urunun DSLR Camera oldugunu test edin.

WebElement urunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "DSLR Camera";
        String actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 1. test PASSED");
        }else System.out.println("Dslr camera 1. test FAILED");

        /*
        2. olarak AppleKulakligin saginda diye RelativeLOcator kullanalim
         */

        driver.get("https://testotomasyonu.com/relativeLocators");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement appleKulaklik = driver.findElement(By.id("pic6_thumb"));

        driver.findElement(RelativeLocator.with(By.className("overlay")).toRightOf(appleKulaklik))
                .click();

         expectedUrunIsmi = "DSLR Camera";

        urunIsimElementi =driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

         actualUrunIsmi = urunIsimElementi.getText(); //StaleElementReferenceException ( bundan dolayi calismadi )

        // Bir web sayfasindaki elementi locate ettikten sonnra baska sayfalara gidilirse
        //yeniden locate ettigimiz web elementin oldugu sayfaya donersek driver daha onceden locate ettigi
        // elementlerin ayni kaldigindan emin iolamk ister ve bize NoSuchElementException demiyor
        // onun yerine StaleElementReferenceException (bu webelenti locate etmistik ama ustunden cok zaman gecti diyor
        // daha once kaydettigimiz webelemente yeniden deger atamasi yapmamiz gerekir

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 2. test PASSED");
        }else System.out.println("Dslr camera 2. test FAILED");

        //3. olarak kulakligin altinda

        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement batKulaklik = driver.findElement(By.id("pic2_thumb"));

        Thread.sleep(3000);

        Actions actions2 =new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();


        driver.findElement(RelativeLocator.with(By.id("pictext7")).below(batKulaklik))
                .click();

        Thread.sleep(3000);






        expectedUrunIsmi = "DSLR Camera";

        urunIsimElementi =driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        actualUrunIsmi = urunIsimElementi.getText();

        if (expectedUrunIsmi.equals(actualUrunIsmi)){
            System.out.println("Dslr camera 3. test PASSED");
        }else System.out.println("Dslr camera 3. test FAILED");




        Thread.sleep(3000);
        driver.quit();
    }
}
