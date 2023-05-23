package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class C06_QualitydemyNegatifLoginTesti {

    @Test
    public void test01(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecersiz username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethod.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();


        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.loginEmailKutusuElementi.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }

    @Test(groups = "smoke")
    public void gecersizIsimTesti(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecersiz username ve gecerli sifreyi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethod.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();


        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.loginEmailKutusuElementi.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }

    @Test
    public void gecersizSifreTesti(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecerli username ve gecersiz sifreyi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethod.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();


        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.loginEmailKutusuElementi.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
