package tests.day14_TestNGFrameworkOlusturma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DriverIlkTest {
    @Test
    public void test01(){

        /*
        POM'de driver olusturmak icin
        inheritance ile kullandigimiz TestBase class'i yerine
        static yollarla ulasabilecegimiz bir method kullanilmasi tercih edilmistir

        Driver bizim icin cok onemli oldugundan
        Driver icin bagimsiz bir class olusturacagiz
     */



        // amazon ana sayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonuclarinin Nutella kelimesi icerdigini test edin
        WebElement sonucElementi = Driver.getDriver().findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String expectedIcerik = "Nutella";
        String actualSonuc = sonucElementi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
}
