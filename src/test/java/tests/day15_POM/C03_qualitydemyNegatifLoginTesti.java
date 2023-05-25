package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_qualitydemyNegatifLoginTesti {

    @Test

    public void test01(){

        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com");

        // ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginButonuElementi.click();

        // kullanici adi olarak selenium
        qualitydemyPage.loginEmailKutusuElementi.sendKeys("selenium");

        // password olarak heyecandir yazin
        qualitydemyPage.loginPasswordKutusuElementi.sendKeys("heyecandir");

        // login butonuna tiklayin
        qualitydemyPage.cookiesAcceptElementi.click();
        ReusableMethods.bekle(4);
        qualitydemyPage.sonLoginButonuElementi.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.loginEmailKutusuElementi.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();
    }
}
