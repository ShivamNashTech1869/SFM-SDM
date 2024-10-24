package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Deal {

    WebDriver driver;
    Random random;
    WebDriverWait wait;
    String randomCode;
    String dealTitle;
    int dollarSpendValue;
    int pointsOfferValue;
    int priorityPoints;
    String storeIdValue;

    public Deal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        random = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //Home Page
    @FindBy(xpath = "//li/a[text()='Promotions']")
    WebElement promotionsLink;
    @FindBy(xpath = "//li/a[text()='Deal']")
    WebElement dealOffersLink;

    //Home >> Promotions >> Deal
    @FindBy(css = "button.flex.items-center.align-middle.button-rounded")
    List<WebElement> storeChangeButtons;
    @FindBy(xpath = "//div/span[text()='Shoppers Drug Mart']")
    WebElement shoppersDrugMartButton;
    @FindBy(xpath = "//button[contains(@class, 'bg-black') and @type='button']")
    WebElement createDealButton;

    // Deal types
    @FindBy(xpath = "//div[text()='Price discounts']")
    WebElement priceDiscounts;
    @FindBy(xpath = "//div[contains(@class, 'flex-grow') and .//div[contains(text(), 'Gift with purchase')]]")
    WebElement giftWithPurchase;
    @FindBy(xpath = "//div[contains(@class, 'flex-grow') and .//div[contains(text(), 'Purchase with purchase')]]")
    WebElement purchaseWithPurchase;
    @FindBy(xpath = "//div[contains(@class, 'flex-grow') and .//div[contains(text(), 'Free shipping')]]")
    WebElement freeShipping;
    @FindBy(xpath = "//div[contains(@class, 'flex-grow') and .//div[contains(text(), 'Free product list')]]")
    WebElement freeProductList;


    //Create deal
    @FindBy(css = "input#deal_title")
    WebElement dealTitleInput;
    @FindBy(css = "textarea#deal_description")
    WebElement dealDescriptionInput;



    //Deal applies
    @FindBy(css = "input[type='radio'][value='PRODUCT']")
    WebElement productDealLevelRadioButton;
    @FindBy(css = "input[type='radio'][value='MINIMUM_QUANTITY_REQUIRED']")
    WebElement minimumQuantityRequiredRadioButton;
    @FindBy(css = "input#deal_level_product_code")
    WebElement dealLevelProductCodeInput;

    @FindBy(css = "input[type='radio'][value='MINIMUM_SPEND']")
    WebElement minimumSpendRadioButton;
    @FindBy(css = "input#spend_amount")
    WebElement spendAmountInput;


    @FindBy(css = "input[type='radio'][value='BASKET']")
    WebElement basketDealLevelRadioButton;



    //Product inclusions
    @FindBy(xpath = "//button[text()='Add Manually']")
    WebElement addManuallyButton;
    @FindBy(css = "input#product_code")
    WebElement productCodeInput;
    @FindBy(xpath = "//button[text()='Include']")
    WebElement includeButton;

    @FindBy(xpath = "//button[contains(text(), 'Import by CSV')]")
    WebElement productInclusionsImportButton;
    @FindBy(xpath = "//button[contains(text(), 'Attach file')]")
    WebElement attachFileButton;
    @FindBy(css = "input[type='file']")
    WebElement fileInput;
    @FindBy(xpath = "//button[contains(text(), 'Upload')]")
    WebElement uploadButton;

    @FindBy(css = "input[name='always_badge'][type='checkbox']")
    WebElement alwaysBadgeCheckbox;

    //Additional configurations
    @FindBy(xpath = "//label[text()='Limit number of applications']/preceding-sibling::input[@type='radio']")
    WebElement limitNumberOfApplicationsRadioButton;
    @FindBy(css = "input#purchase_limit")
    WebElement purchaseLimitInput;

    @FindBy(xpath = "//label[text()='No limit']/preceding-sibling::input[@type='radio']")
    WebElement noLimitRadioButton;



    //Customer eligibility
    @FindBy(css = "input#allCustomers[type='radio']")
    WebElement allCustomersRadioButton;
    @FindBy(css = "input#specificCustomerSegments[type='radio']")
    WebElement specificCustomerSegmentsRadioButton;
    @FindBy(css = "input#segment-1[type='checkbox']")
    WebElement employeeCheckbox;
    @FindBy(css = "input#segment-2[type='checkbox']")
    WebElement assistedCustomersCheckbox;
    @FindBy(css = "input#exclusions[type='radio']")
    WebElement exclusionsRadioButton;

   //Store eligibility
    @FindBy(css = "input[type='radio'][value='All stores']")
    WebElement allStoresRadioButton;
    @FindBy(css = "input[type='radio'][value='Specific stores ID(s)']")
    WebElement specificStoresRadioButton;
    @FindBy(css = "input[name='store_id']")
    WebElement storeIdInput;

    //Date In Effect
    @FindBy(css = "button[id=':r6:']")
    WebElement calendarButton;
    By dateButtonsLocator = By.cssSelector("button[name='day']");
    @FindBy(css = "select[id=':r8:']")
    WebElement timeBox;
    By timeOptionsLocator = By.cssSelector("select[id=':r8:'] option");

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement createButton;

    @FindBy(css = "button[role='combobox'][aria-controls='radix-:r0:']")
    WebElement downloadButton;



    // This method is to click on "Promotions" and then "Deal"
    public void clickPromotionsThenDeal() {
        wait.until(ExpectedConditions.elementToBeClickable(promotionsLink));
        promotionsLink.click();

        wait.until(ExpectedConditions.elementToBeClickable(dealOffersLink));
        dealOffersLink.click();
    }

    public WebElement getFirstStoreChangeButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(storeChangeButtons));
        return storeChangeButtons.get(0);
    }
    public void selectShoppersDrugMartAsStore() {
        getFirstStoreChangeButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(shoppersDrugMartButton));
        shoppersDrugMartButton.click();
    }

    /**
     * This method is to create a Deal and select a specific deal type.
     * @param dealType The type of deal to select: "priceDiscounts", "giftWithPurchase", "purchaseWithPurchase", "freeShipping", or "freeProductList".
     */
    public void createLoyaltyOffer(String dealType) {
        wait.until(ExpectedConditions.elementToBeClickable(createDealButton));
        createDealButton.click();

        // Select deal type
        switch (dealType.toLowerCase()) {
            case "pricediscounts":
                wait.until(ExpectedConditions.elementToBeClickable(priceDiscounts));
                priceDiscounts.click();
                break;
            case "giftwithpurchase":
                wait.until(ExpectedConditions.elementToBeClickable(giftWithPurchase));
                giftWithPurchase.click();
                break;
            case "purchasewithpurchase":
                wait.until(ExpectedConditions.elementToBeClickable(purchaseWithPurchase));
                purchaseWithPurchase.click();
                break;
            case "freeshipping":
                wait.until(ExpectedConditions.elementToBeClickable(freeShipping));
                freeShipping.click();
                break;
            case "freeproductlist":
                wait.until(ExpectedConditions.elementToBeClickable(freeProductList));
                freeProductList.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid deal type: " + dealType);
        }
    }

    /**
     * This method is to fill the input boxes for Deal Title and Deal Description.
     */
    public void fillDealFields() {
        dealTitle = generateRandomAlphanumeric(6);
        wait.until(ExpectedConditions.visibilityOf(dealTitleInput));
        dealTitleInput.sendKeys(dealTitle);

        wait.until(ExpectedConditions.visibilityOf(dealDescriptionInput));
        dealDescriptionInput.sendKeys(String.format("Creating a deal with title: %s", dealTitle));
    }


    /**This method generates a random alphanumeric string of specified length.
     * @param length Length of the desired random string.
     * @return A random alphanumeric string.
     */
    String generateRandomAlphanumeric(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomStringBuilder = new StringBuilder(length);

        for (int index = 0; index < length; index++) {
            int charIndex = random.nextInt(characters.length());
            randomStringBuilder.append(characters.charAt(charIndex));
        }
        return randomStringBuilder.toString();
    }

    /**
     * This method selects the 'Product Deal Level' radio button,
     * then selects the 'Minimum Quantity Required' radio button,
     * and sets the product code in the input field.
     */
    public void selectProductDealLevelAndSetMinimumQuantityRequired() {
        wait.until(ExpectedConditions.elementToBeClickable(productDealLevelRadioButton));
        if (!productDealLevelRadioButton.isSelected()) {
            productDealLevelRadioButton.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(minimumQuantityRequiredRadioButton));
        if (!minimumQuantityRequiredRadioButton.isSelected()) {
            minimumQuantityRequiredRadioButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(dealLevelProductCodeInput));
        dealLevelProductCodeInput.sendKeys("l1");
    }

    /**
     * This method selects the 'Product Deal Level' radio button,
     * then selects the 'Minimum Spend' radio button,
     * sets a random spend amount and product code
     */
    public void selectProductDealLevelAndSetMinimumSpend() {
        wait.until(ExpectedConditions.elementToBeClickable(productDealLevelRadioButton));
        if (!productDealLevelRadioButton.isSelected()) {
            productDealLevelRadioButton.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(minimumSpendRadioButton));
        if (!minimumSpendRadioButton.isSelected()) {
            minimumSpendRadioButton.click();
        }

        wait.until(ExpectedConditions.visibilityOf(spendAmountInput));
        dollarSpendValue = random.nextInt(50) + 1;
        spendAmountInput.sendKeys(String.valueOf(dollarSpendValue));

        wait.until(ExpectedConditions.visibilityOf(dealLevelProductCodeInput));
        dealLevelProductCodeInput.sendKeys("l1");
    }

    /**
     * This method selects the 'Basket Deal Level' radio button,
     * sets a random spend amount and sets the product code.
     */
    public void selectBasketDealLevelAndSetSpendAndProductCode() {
       wait.until(ExpectedConditions.elementToBeClickable(basketDealLevelRadioButton));
        if (!basketDealLevelRadioButton.isSelected()) {
            basketDealLevelRadioButton.click();
        }

        wait.until(ExpectedConditions.visibilityOf(spendAmountInput));
        dollarSpendValue = random.nextInt(50) + 1;
        spendAmountInput.sendKeys(String.valueOf(dollarSpendValue));

        wait.until(ExpectedConditions.visibilityOf(dealLevelProductCodeInput));
        dealLevelProductCodeInput.sendKeys("l1");
    }


    /**
     * This method imports product inclusions from a CSV file.
     */
    public void importProductInclusionsFromCSV() {
        wait.until(ExpectedConditions.elementToBeClickable(productInclusionsImportButton));
        productInclusionsImportButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(attachFileButton));
        attachFileButton.click();

        String filePath = System.getProperty("user.dir") + "/src/main/java/resources/externalData/exclusions.csv";

        wait.until(ExpectedConditions.visibilityOf(fileInput));
        fileInput.sendKeys(filePath);
        wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
        uploadButton.click();
    }

    /**
     * This method adds a product manually and includes it in the process.
     */
    public void addProductManuallyAndInclude() {
        wait.until(ExpectedConditions.elementToBeClickable(addManuallyButton));
        addManuallyButton.click();
        wait.until(ExpectedConditions.visibilityOf(productCodeInput));
        productCodeInput.sendKeys("l1");
        wait.until(ExpectedConditions.elementToBeClickable(includeButton));
        includeButton.click();
    }

    /**
     * This method toggles the 'Always Badge' checkbox.
     */
    public void toggleAlwaysBadgeCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(alwaysBadgeCheckbox));
        if (!alwaysBadgeCheckbox.isSelected()) {
            alwaysBadgeCheckbox.click();
        }
    }

    /**
     * This method is to select the "Limit number of applications" option
     * and set the purchase limit 1-50
     */
    public void selectLimitNumberOfApplicationsAndSetPurchaseLimit() {
        wait.until(ExpectedConditions.elementToBeClickable(limitNumberOfApplicationsRadioButton));
        if (!limitNumberOfApplicationsRadioButton.isSelected()) {
            limitNumberOfApplicationsRadioButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(purchaseLimitInput));

        int purchaseLimit = random.nextInt(50) + 1;
        purchaseLimitInput.sendKeys(String.valueOf(purchaseLimit));
    }

    /**
     * This method is to select the "No limit" option for Additional configurations
     */
    public void selectNoLimitForPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(noLimitRadioButton));
        if (!noLimitRadioButton.isSelected()) {
            noLimitRadioButton.click();
        }
    }

    public void selectAllCustomers() {
        wait.until(ExpectedConditions.elementToBeClickable(allCustomersRadioButton));
        if (!allCustomersRadioButton.isSelected()) {
            allCustomersRadioButton.click();
        }
    }

    public void selectSpecificCustomerSegmentsAndAtLeastOneCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(specificCustomerSegmentsRadioButton));
        if (!specificCustomerSegmentsRadioButton.isSelected()) {
            specificCustomerSegmentsRadioButton.click();
        }
        selectRandomCustomerSegmentCheckbox();
    }

    public void selectExclusionsAndAtLeastOneCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(exclusionsRadioButton));
        if (!exclusionsRadioButton.isSelected()) {
            exclusionsRadioButton.click();
        }
        selectRandomCustomerSegmentCheckbox();
    }

    private void selectRandomCustomerSegmentCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(employeeCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(assistedCustomersCheckbox));

        // Randomly decide to click each checkbox
        boolean selectEmployee = random.nextBoolean();
        boolean selectAssistedCustomers = random.nextBoolean();
        // Check at least one checkbox
        if (selectEmployee) {
            if (!employeeCheckbox.isSelected()) {
                employeeCheckbox.click();
            }
        }
        if (selectAssistedCustomers) {
            if (!assistedCustomersCheckbox.isSelected()) {
                assistedCustomersCheckbox.click();
            }
        }
        // If neither checkbox was selected, select the first one (Employees) by default
        if (!employeeCheckbox.isSelected() && !assistedCustomersCheckbox.isSelected()) {
            employeeCheckbox.click();
        }
    }

    public void selectAllStoresOption() {
        wait.until(ExpectedConditions.elementToBeClickable(allStoresRadioButton));
        if (!allStoresRadioButton.isSelected()) {
            allStoresRadioButton.click();
        }
    }

    public void selectSpecificStoreAndInclude() {
        storeIdValue = "4099s";
        wait.until(ExpectedConditions.elementToBeClickable(specificStoresRadioButton));
        if (!specificStoresRadioButton.isSelected()) {
            specificStoresRadioButton.click();
        }
        wait.until(ExpectedConditions.visibilityOf(storeIdInput));
        storeIdInput.sendKeys(storeIdValue);
        wait.until(ExpectedConditions.elementToBeClickable(includeButton));
        includeButton.click();
    }

    public void selectRandomDate() {
        wait.until(ExpectedConditions.elementToBeClickable(calendarButton));
        calendarButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dateButtonsLocator));

        List<WebElement> dateButtons = driver.findElements(dateButtonsLocator);

        if (!dateButtons.isEmpty()) {
            dateButtons.get(random.nextInt(dateButtons.size())).click();
        } else {
            System.out.println("No date buttons available to select.");
        }
    }

    public void selectRandomTime() {
        wait.until(ExpectedConditions.elementToBeClickable(timeBox));
        timeBox.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(timeOptionsLocator));

        List<WebElement> timeOptions = driver.findElements(timeOptionsLocator);

        if (timeOptions.size() > 1) {
            int randomIndex = random.nextInt(timeOptions.size() - 1) + 1; // +1 to skip placeholder
            timeOptions.get(randomIndex).click();
        } else {
            System.out.println("No available time options to select.");
        }
    }

    public void clickCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
    }

    public boolean isVoucherCreated() {
        wait.until(ExpectedConditions.visibilityOf(downloadButton));
        return downloadButton.isDisplayed();
    }



}
