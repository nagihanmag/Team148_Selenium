package day02_DriverMethodlariVeWebElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        //1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");
        Thread.sleep(2000);
        //2. Sayfa basligini(title) yazdirin
        String actualTitle = driver.getTitle();
        System.out.println("Sayfa title : " + actualTitle);

        //3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin

        String expectedTitleIcerik = "Test Otomasyonu";

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        } else System.out.println("Title testi FAILED");


        //4. Sayfa adresini(url) yazdirin
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Gidilen Url : " + actualUrl);
        // Gidilen Url : https://www.testotomasyonu.com/

        //5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        String expectedUrl = "https://testotomasyonu.com/";

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAILED");

        //6. Sayfa handle degerini yazdirin

        System.out.println("Acilan window'un window handle degeri : "+ driver.getWindowHandle() );

        //7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin

        String expectedSayfaKaynagiIcerik = "otomasyon";

        String  actualSayfaKaynagi = driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfaKaynagiIcerik)){
            System.out.println("Sayfa kaynagi testi PASSED");
        } else  System.out.println("Sayfa kaynagi testi FAILED");

        //8. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.quit();
    }
}
