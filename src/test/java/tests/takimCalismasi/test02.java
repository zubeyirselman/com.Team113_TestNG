package tests.takimCalismasi;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class test02 {
    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click 'Signup / Login' button
        //5. Fill all details in Signup and create account
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //7. Verify ' Logged in as username' at top
        //8. Add products to cart
        //9. Click 'Cart' button
        //10. Verify that cart page is displayed
        //11. Click Proceed To Checkout
        //12. Verify Address Details and Review Your Order
        //13. Enter description in comment text area and click 'Place Order'
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        //3. Verify that home page is visible successfully
        AutomationExercisePage automationExercisePage = new AutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(automationExercisePage.anaSayfaGorunur.isDisplayed());

        //4. Click 'Signup / Login' button
        automationExercisePage.slButonu.click();

        //5. Fill all details in Signup and create account
        automationExercisePage.kaydolIsimElementi.sendKeys("Furkan");
        automationExercisePage.kaydolMailElementi.sendKeys("Furkan");
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //7. Verify ' Logged in as username' at top
        //8. Add products to cart
        //9. Click 'Cart' button
        //10. Verify that cart page is displayed
        //11. Click Proceed To Checkout
        //12. Verify Address Details and Review Your Order
        //13. Enter description in comment text area and click 'Place Order'
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //15. Click 'Pay and Confirm Order' button
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
