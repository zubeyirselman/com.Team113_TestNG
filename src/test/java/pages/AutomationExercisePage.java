package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@aria-hidden='false']")
    public WebElement anaSayfaGorunur;

    @FindBy(xpath = "//a[@style='color: brown;']")
    public WebElement rastgeleUrun;

    @FindBy(xpath = "//div[@class='product-information']")
    public WebElement urunDetayi;

    @FindBy(id = "quantity")
    public WebElement urunAdedi;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement addCartButonu;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCartButonu;

    @FindBy(xpath ="//div[@class='table-responsive cart_info']")
    public WebElement sepetKontrol;

    @FindBy(xpath = "//button[text()='4']")
    public WebElement sepettekiMiktar;
}
