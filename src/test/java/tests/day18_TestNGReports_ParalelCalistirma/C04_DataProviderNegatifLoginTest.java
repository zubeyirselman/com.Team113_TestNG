package tests.day18_TestNGReports_ParalelCalistirma;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_DataProviderNegatifLoginTest {
    @DataProvider
    public static Object[][] YanlisKullaniciAdlariListesi() {
        String[][] kullaniciBilgileriArrayi = {{"Memre","12345"},{"Mustafa","23456"},
                                               {"Burcu","32456"},{"Cigdem","867453"},
                                               {"Ahmet","32567"},{"Kemal","87654"},
                                               {"Melike","65747"},{"Cinar","645353"},
                                               {"Muleyke","6312"},{"Kadir","19870"}};
        return kullaniciBilgileriArrayi;
    }

    // verilen 10 kullanici bilgisi ile sisteme giris yapilamadigini test edin

    @Test(dataProvider = "YanlisKullaniciAdlariListesi")
    public void gecersizIsimSifreTesti(String kullaniciAdi , String password){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // gecersiz username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.loginEmailKutusuElementi.sendKeys(kullaniciAdi);
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys(password);

        // login butonuna basin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethods.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();


        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.loginEmailKutusuElementi.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
