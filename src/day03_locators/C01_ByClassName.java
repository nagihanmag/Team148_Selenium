package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {


        //1- Bir test class’i olusturun ilgili ayarlari yapin

        System.setProperty("webdriver.choreme.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
        bu sure tum islemler icin ayri ayri gecerlidir
        sayfanin bulunmasi ve her bir webelementin locate etmesi icin buraya yazilan
        10 saniye boyunca bekler
         */

        //2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        //3- arama kutusuna phone yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        //aramaKutusu.submit();(enter tusuna basmak icin bunu da yazabiliriz )

        //4- Category bolumunde 8 element oldugunu test edin

        List<WebElement> catagoryElemetleriList =driver.findElements(By.className("panel-list"));
        int expectedCatagorySayisi = 8 ;
        int actualCatagorySayisi =catagoryElemetleriList.size();

        if (expectedCatagorySayisi == actualCatagorySayisi){
            System.out.println("Catagory Sayisi Testi PASSED");
        }else System.out.println("Catagory Sayisi Testi FAILED");


        //5- Category isimlerini yazdirin

       // System.out.println(catagoryElemetleriList); // bize referans degerlerini yazdirir
        /*
        Listede Webelement`ler oldugu icin direk yazdiramiyoruz
        eger Listedeki herbir elementi ele alirsak , uzerindeki texi yazdirabiliriz
         */

        for (WebElement eachElement :catagoryElemetleriList){
            System.out.println(eachElement.getText());

        }


        //6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();





    }
}
