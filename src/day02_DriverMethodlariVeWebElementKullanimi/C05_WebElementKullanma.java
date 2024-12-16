package day02_DriverMethodlariVeWebElementKullanimi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_WebElementKullanma {

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

        //arama sonucunda urun bulunabildigini test edin

        // arama sonuc yazisini locate edip
        // oradaki yazinin icinde bulunan sayinin
        // 0'dan buyuk oldugunu test edelim

        WebElement aramaSonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(aramaSonucYaziElementi);
        //[[ChromeDriver: chrome on windows (9721cb511b88ce58a046c1c833ad8285)] -> class name: product-count-text]

        System.out.println(aramaSonucYaziElementi.getText()); //4 Products Found

        String sonucSayisiStr = aramaSonucYaziElementi.getText().replaceAll("\\D","");

        System.out.println(sonucSayisiStr); // 4
        int sonucSayisi = Integer.parseInt(sonucSayisiStr); //4

        if (sonucSayisi>0){

            System.out.println("Arama testi PASSED");
        }else System.out.println("Arama testi FAILED");




        //sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();


    }


}
