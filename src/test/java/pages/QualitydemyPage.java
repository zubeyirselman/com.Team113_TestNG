package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginButonuElementi;

    @FindBy(id = "login-email")
    public WebElement loginEmailKutusuElementi;

    @FindBy(id = "login-password")
    public WebElement loginPasswordKutusuElementi;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement sonLoginButonuElementi;

    @FindBy(xpath = "//*[text()='Accept']")
    public WebElement cookiesAcceptElementi;

    @FindBy(xpath = "//*[text()='Instructor']")
    public WebElement girisKontrolElementi;
}
