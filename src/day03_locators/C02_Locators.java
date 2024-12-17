package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_Locators {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.crome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- http://zero.webappsecurity.com/ adresine gidin
        driver.get(" http://zero.webappsecurity.com/ ");

        //3- "ONLINE BANKING" linkine tiklayin

       // WebElement onlineBankingLinki = driver.findElement(By.id("onlineBankingMenu"));
       // onlineBankingLinki.click();(bunu da yapabiliriz click yerine)

        driver.findElement(By.id("onlineBankingMenu")).click();


        //4- Resim altinda 6 islem basligi oldugunu test  edin

        List<WebElement> baslikElementleriList =driver.findElements(By.className("headers"));

        int expectedBaslikSayisi= 6;
        int actualBaslikSayisi = baslikElementleriList.size();

        if (expectedBaslikSayisi==actualBaslikSayisi){
            System.out.println("Baslik sayisi testi PASSED");
        }else System.out.println("Baslik sayisi testi FAILED");

        //5- Islem basliklarinin icinden "Pay Bills" oldugunu test edin

        List<String> baslikListesiStr = new ArrayList<>();

        for (WebElement eachBaslik :baslikElementleriList){
            baslikListesiStr.add(eachBaslik.getText());

        }

        System.out.println(baslikListesiStr);
        //[Account Summary, Account Activity, Transfer Funds, Pay Bills, My Money Map, Online Statements]

        String expectedBaslikIsmi = "Pay Bills";
        if (baslikListesiStr.contains(expectedBaslikIsmi)){
            System.out.println("PayBills testi PASSED");
        }else System.out.println("PayBills testi FAILES");

        //6- Sayfayi kapatin


        Thread.sleep(3000);
        driver.quit();

    }
}
