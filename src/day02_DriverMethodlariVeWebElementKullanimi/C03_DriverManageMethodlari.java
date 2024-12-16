package day02_DriverMethodlariVeWebElementKullanimi;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.crome.driver","kurulumDosyalari/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        // driver.manage().window().maximize();
        // HTML kodlarin daha erisilebilir olmasi icin
        // her class'in basinda mutlaka maximize yapariz

        driver.get("https://www.testotomasyonu.com");


        // acilista window size ve konumunu yazdirin
        System.out.println("Acilista boyut : " + driver.manage().window().getSize());
        System.out.println("Acilista konum : " + driver.manage().window().getPosition());

        Thread.sleep(2000);
        // window'u maximize yapin
        driver.manage().window().maximize();

        // maximize yaptigimizda size ve konumunu yazdirin
        System.out.println("Maximize boyut : " + driver.manage().window().getSize());
        System.out.println("Maximize konum : " + driver.manage().window().getPosition());


        Thread.sleep(2000);
        // window'u fullscreen yapin
        driver.manage().window().fullscreen();

        // maximize yaptigimizda size ve konumunu yazdirin
        System.out.println("Fullscreen boyut : " + driver.manage().window().getSize());
        System.out.println("Fullscreen konum : " + driver.manage().window().getPosition());

        Thread.sleep(2000);
        // istedigimiz konum ve boyuta getirelim

        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(100,100));

        // istedigimiz boyutta iken size ve konumunu yazdirin
        System.out.println("istedigimiz boyutta boyut : " + driver.manage().window().getSize());
        System.out.println("istedigimiz boyutta konum : " + driver.manage().window().getPosition());


        Thread.sleep(2000);
        driver.quit();

    }

    }

