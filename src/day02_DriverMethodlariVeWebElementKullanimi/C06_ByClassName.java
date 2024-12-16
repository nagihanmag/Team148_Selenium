package day02_DriverMethodlariVeWebElementKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Test otomasyonu ana sayfaya gidin

        driver.get("https://testotomasyonu.com");

        //arama kutusuna phone yazip aratin

        /*
        kodlarimiz ile reel browser deki bir webelementi kullanabilmek icin
        once o webelementi kodlarimizla tanimlayip bir obje olarak kilasda kaydetmeliyiz
      */

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone");
        aramaKutusu.submit();

        // arama sonucunda urun bulundugunu test edin


        // bulunan urunleri class attribute `u sayesinde toplu olarak locate edebiliyoruz

        List <WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi > 0){
            System.out.println("Arama testi PASSED");
        } else  System.out.println("Arama testi FAILED");




        //sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();


    }

}
