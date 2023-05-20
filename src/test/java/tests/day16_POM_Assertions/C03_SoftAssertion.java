package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {
    @Test
    public void hardAssertion(){ //soft olmadigi icin 'hard' deniyor, yoksa baska bir numarasi yok.

        /*
            Assert islemi ilk failed oldugunda
            Selenium calismayi durdurur
            ve java.lang.AssertionError: verir

            Eger bir test method'u icinde birden fazla assertion varsa
            ilk failed olanda calisma durur
            sonraki assertion'lar calismamis olur.

            TestNG bu konuda da bize daha fazla kontrol yetkisi vermistir.
            Istersek TestNG assertion failed olsa bile
            bizim istedigimiz satira kadar
            kodlarin calismaya devam etmesini saglar.

            "artik rapor ver" dedigimizde
            failed olan tum assertion' lari raporlar
            ve failed olan varsa calismayi durdurur.
         */

        int sayi = 36;

        Assert.assertTrue(sayi%2==0); // sayi cift mi?

        Assert.assertTrue(sayi>100); // sayi 100' den buyuk mu?

        Assert.assertTrue(sayi<1000); // sayi 1000' den kucuk mu?

        Assert.assertFalse(sayi%3==0); // sayinin 3 ile bolunmedigini test edin.

    }


    @Test
    public void softAssertionTesti(){

        /*
            SoftAssert class' i sayesinde
            assertAll()' un calisacagi satira kadar
            failed olan olsa bile, tum assertion'lar calismaya devam eder.

            assertAll() calistiginda
            failed olan assertion' lara ait raporu verir.
            ANCAK hangi satirda olduklarini vermez.

            Selenium hata mesaji da assertAll()' un bulundugu satiri isaret eder.

            Failed olan assertion' lari kolaylikla bulabilmemiz icin
         */

        int sayi = 36;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(sayi%2==0, "sayi cift olmali"); // sayi cift mi?

        softAssert.assertTrue(sayi>100, "sayi 100' den buyuk olmali"); // sayi 100' den buyuk mu?

        softAssert.assertTrue(sayi<1000, "sayi 1000' den kucuk olmali"); // sayi 1000' den kucuk mu?

        softAssert.assertFalse(sayi%3==0, "sayi 3' e bolunememeli"); // sayinin 3 ile bolunmedigini test edin.

        softAssert.assertAll();

        // softAssert objesi ile assertion' lari yaptiktan sonra
        // assertAll() kullanmazsak; test direk PASSED olur.
        // Failed olan assertion' lar raporlanmaz.

    }
}
