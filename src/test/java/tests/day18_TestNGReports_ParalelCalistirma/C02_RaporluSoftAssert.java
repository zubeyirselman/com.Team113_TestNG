package tests.day18_TestNGReports_ParalelCalistirma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluSoftAssert extends TestBaseRapor {
    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Alert test",
                                             "Kullanici JS alert' leri calistirabilmeli ve kapatabilmeli");

        //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
        extentTest.info("Kullanici herokuapp alerts sayfasina gider.");
        Thread.sleep(3000);

        // 1.alert'e tiklayin
        WebElement ilkAlertElementi = Driver.getDriver().findElement(By.xpath("//*[text()='Click for JS Alert']"));
        ilkAlertElementi.click();
        extentTest.info("Ilk alert butonuna click yapar.");
        Thread.sleep(3000);

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();

        SoftAssert softAssert = new SoftAssert();
        //Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        softAssert.assertEquals(actualAlertYazisi,expectedAlertYazisi, "Alert' deki yazi belirlenenden farkli.");
        extentTest.info("SoftAssert ile alert yazisinin beklenen degere sahip oldugunu test eder");

        // OK tusuna basip alert'i kapatin
        Thread.sleep(1500);
        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("alert' u kapatir.");

        // alert' in kapatildigini test edin
        //Assert.assertTrue(ilkAlertElementi.isEnabled());

        softAssert.assertTrue(ilkAlertElementi.isEnabled(), "alert kapatilamadi.");
        extentTest.info("SoftAssert ile alert' un kapatildigini test eder.");

        softAssert.assertAll();
        extentTest.pass("SoftAssert ile yapilan tum testlerin sonucunu raporlar.");
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir.");
    }
}
