package tests.day19_crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void amazontest(){

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim
        // Arama kutusunun locate'i pages sayfasinda
        // POM'de pages sayfasindaki locate'lere erismek icin
        // pages sayfalarindan bir obje olusturulur.
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedIcerik = "Nutella";
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actualAramaSonucYazisi = aramaSonucuElementi.getText();
        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

    }
}
