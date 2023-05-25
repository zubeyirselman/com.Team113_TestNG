package tests.day15_POM;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_QualitydemyLoginTesti {

    @Test
    public void test01(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethods.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.girisKontrolElementi.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
