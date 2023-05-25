package tests.takimCalismasi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Test01 {

    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    // 3. Verify that home page is visible successfully
    // 4. Click 'View Product' for any product on home page
    // 5. Verify product detail is opened
    // 6. Increase quantity to 4
    // 7. Click 'Add to cart' button
    // 8. Click 'View Cart' button
    // 9. Verify that product is displayed in cart page with exact quantity


    @Test
    public void test01(){

        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        // 3. Verify that home page is visible successfully
        AutomationExercisePage automationExercisePage = new AutomationExercisePage();
        automationExercisePage.anaSayfaGorunur.isDisplayed();

        // 4. Click 'View Product' for any product on home page
        automationExercisePage.rastgeleUrun.click();


        // 5. Verify product detail is opened
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(automationExercisePage.urunDetayi.isDisplayed());

        // 6. Increase quantity to 4
        automationExercisePage.urunAdedi.clear();
        automationExercisePage.urunAdedi.sendKeys("4");
        //ReusableMethod.bekle(7);

        // 7. Click 'Add to cart' button
        automationExercisePage.addCartButonu.click();

        // 8. Click 'View Cart' button
        automationExercisePage.viewCartButonu.click();

        // 9. Verify that product is displayed in cart page with exact quantity
        String expectedIcerik ="4";
        softAssert.assertEquals(automationExercisePage.sepettekiMiktar,expectedIcerik);


        Driver.closeDriver();
    }
}
