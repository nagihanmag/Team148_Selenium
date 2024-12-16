package day01_WebDriverKullanma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {
    public static void main(String[] args) throws InterruptedException {

        // bir teste balamadan önce mutlaka bir webdriver edinmeliyiz
        //en ilkel hali ile webdriver edinmek için java dan yardım alacağız

        System.setProperty("webdriver.chrom.driver","kurulumDosyalari/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://testotomasyonu.com");

        Thread.sleep(3000);

        driver.quit();





    }
}
