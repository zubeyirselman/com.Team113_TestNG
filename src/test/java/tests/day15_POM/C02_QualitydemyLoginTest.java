package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class C02_QualitydemyLoginTest {

    @Test
    public void test01(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get("https://www.qualitydemy.com");

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage(); // once bu objeyi olusturmaliyim.
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys("Nevzat152032");

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethod.bekle(3);
        qualitydemyPage.sonLoginButonuElementi.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.girisKontrolElementi.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
