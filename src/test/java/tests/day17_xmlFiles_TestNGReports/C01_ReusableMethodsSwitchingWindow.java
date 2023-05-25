package tests.day17_xmlFiles_TestNGReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;


public class C01_ReusableMethodsSwitchingWindow {
    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        SoftAssert softAssert = new SoftAssert();

        WebElement openingWindowYaziElementi= Driver.getDriver().findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi= openingWindowYaziElementi.getText();
        softAssert.assertEquals(actualYazi,expectedYazi, "ilk sayfa texti 'Opening a new window' degil");
        String ilkSayfaHandle = Driver.getDriver().getWindowHandle();

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle,"2. sayfa title' i 'The Internet' degil");

        // Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//*[text() = 'Click Here']")).click();
        // 43. satir itibariyle yeni window acildi
        // artik 2 window var

        // artik acilan ikinci windowun windowHandleDegerine sahibiz
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ReusableMethods.switchToWindow("New Window");

        expectedTitle= "New Window";
        actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi = Driver.getDriver().findElement(By.tagName("h3"));
        String expectedYaziElementi = "New Window";
        String actualYaziElementi = newWindowYaziElementi.getText();
        softAssert.assertEquals(actualYaziElementi,expectedYaziElementi);

        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        Driver.getDriver().switchTo().window(ilkSayfaHandle);
        String expectedTitle2 = "The Internet";
        String actualTitle2 = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle2,expectedTitle2);

        softAssert.assertAll();// bizim istedigimiz butun raporlari bize veriyor

        Driver.quitDriver();


    }
}
