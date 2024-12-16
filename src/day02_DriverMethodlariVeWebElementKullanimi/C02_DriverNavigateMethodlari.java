package day02_DriverMethodlariVeWebElementKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

         /*
            Bir test otomasyonu icin
            ilk yapmamiz gereken sey bir WebDriver objesi edinmektir.

            Selenium 4.12 surumu ile kendi WebDriver objesini olusturdu
            Boylece disardan bir WebDriver tanimlamamiza gerek kalmadan
            Selenium WebDriver objesini kullanabilir ve
            testlerimizi yapabiliriz.

            Bazi sirketler acik kaynakli oldugu icin
            Selenium WebDriver kullanmamizi istemeyebilirler
            ve bize kullanmamiz icin bir WebDriver dosyasi verebilirler

            Eger sirkete ozel bir WebDriver objesi kullanilacaksa
            O WebDriver'i test class'imiza tanitmak icin
            System.setProperty() gereklidir

            AMMMAAAA Selenium WebDriver kullanacaksak
            System.setProperty()'e ihtiyac yoktur.
         */

        //System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();


        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        //   ve url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        }else System.out.println("Youtube url testi FAILED");

        //3. Testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //   Title'in "Test Otomasyonu" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();


        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Test otomasyonu title testi PASSED");
        }else System.out.println("Test otomasyonu title testi FAILED");

        //4. Tekrar YouTube’sayfasina donelim
        //    driver.navigate().to();   driver.get() ile ayni islevi yerine getirir
        driver.navigate().back();


        //5. Yeniden testotomasyonu sayfasina gidelim
        driver.navigate().forward();


        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //7. Sayfayi kapatalim / Tum sayfalari kapatalim


        driver.quit();
    }
    }

