package pages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import resources.Base;
import resources.DataDriven;
import util.Common;
import util.Log;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class Auth {
    WebDriver driver;
    WebDriverWait wait;
    Base base;
    Common common;
    String twoFactorCode;


    public Auth(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        base = new Base();
        common = new Common(driver);
    }

    @FindBy(id = "identifierId") WebElement emailInputBox;
    @FindBy(xpath = "//button[.//span[text()='Next']]") WebElement nextButton;
    @FindBy(name = "Passwd") WebElement passwordInputBox;
    @FindBy(id = "countryList")  WebElement phoneCountryDropdown;
    @FindBy(css = "ul[aria-label='Select a country']") WebElement countryList;
    @FindBy(id = "phoneNumberId") WebElement phoneNumberInputBox;
    @FindBy(xpath = "//li[@role='option']//span[@jsname='K4r5Ff' and contains(text(), 'India (+91)')]") WebElement indiaCountryOption;
    @FindBy(xpath = "//span[text()='Send']") WebElement sendButton;
    @FindBy(id = "idvPin") WebElement codeInputBox;

    @FindBy(xpath = "//button[span[text()='Try another way']]") WebElement tryAnotherWayButton;
    @FindBy(xpath = "//li[contains(div, 'Google Authenticator')]") WebElement googleAuthenticatorOption;
    @FindBy(id = "totpPin") WebElement otpPinInputBox;
    @FindBy(xpath = "//button[contains(., 'Sign in with') and contains(., 'Google')]")
    WebElement signInWithGoogleButton;


    public void signIn(String credentialData) throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(emailInputBox));
        emailInputBox.sendKeys(DataDriven.getTestData("Accounts", credentialData).get(1));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys(DataDriven.getTestData("Accounts", credentialData).get(2));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

////     Optional: Wait for the verification code to arrive
//       common.setImplicitWait(120);
////      By using of phone number verification
//        enterPhoneNumberAndVerify(credentialData);

//      By using googleAuthenticatorOption
        wait.until(ExpectedConditions.elementToBeClickable(tryAnotherWayButton));
        tryAnotherWayButton.click();
        common.setImplicitWait(30);
        wait.until(ExpectedConditions.elementToBeClickable(googleAuthenticatorOption));
        googleAuthenticatorOption.click();
        wait.until(ExpectedConditions.visibilityOf(otpPinInputBox));

//      Fetch the 2FA code
        twoFactorCode = twoFAKey();
        otpPinInputBox.sendKeys(twoFactorCode);

        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        common.setImplicitWait(60);
        handleGoogleSignIn();
    }

    public String twoFAKey() throws IOException {
        String otpKeyStr = base.loadProperties("2FA_Key");  // Load the 2FA secret key
        Totp totp = new Totp(otpKeyStr);
        String twoFactorCode = totp.now();
        Log.info("twoFactorCode : " + twoFactorCode);
        return twoFactorCode;
    }

    public void enterPhoneNumberAndVerify(String credentialData) throws IOException {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInputBox));
        wait.until(ExpectedConditions.elementToBeClickable(phoneCountryDropdown));
        phoneCountryDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(countryList));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", indiaCountryOption);

        wait.until(ExpectedConditions.elementToBeClickable(indiaCountryOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", indiaCountryOption);

        wait.until(ExpectedConditions.visibilityOf(phoneNumberInputBox));
        phoneNumberInputBox.sendKeys(DataDriven.getTestData("Accounts", credentialData).get(3));

        wait.until(ExpectedConditions.elementToBeClickable(sendButton));
        sendButton.click();

        wait.until(ExpectedConditions.visibilityOf(codeInputBox));
    }

    public void handleGoogleSignIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signInWithGoogleButton));
            wait.until(ExpectedConditions.elementToBeClickable(signInWithGoogleButton));
            signInWithGoogleButton.click();
        } catch (Exception e) {
            System.out.println("Google sign-in button not available; assuming default Google sign-in.");
        }
    }



}
