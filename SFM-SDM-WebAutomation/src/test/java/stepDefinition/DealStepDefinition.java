package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.TestContextSetup;



public class DealStepDefinition {

    TestContextSetup tcs;

    public DealStepDefinition(TestContextSetup tcs) {
        this.tcs = tcs;
    }



    @Given("I am on the Promotions page and I click on Deal")
    public void iAmOnThePromotionsPageAndIClickOnDeal() {
        tcs.pom.getDealPage().clickPromotionsThenDeal();
    }

    @When("I select Shoppers Drug Mart as the store for deal")
    public void iSelectShoppersDrugMartAsTheStoreForDeal() {
        tcs.pom.getDealPage().selectShoppersDrugMartAsStore();
    }

    @And("I create a deal with {string}")
    public void iCreateADealWith(String dealType) {
        tcs.pom.getDealPage().createLoyaltyOffer(dealType);
    }

    @And("I fill the deal input fields")
    public void iFillTheDealInputFields() {
        tcs.pom.getDealPage().fillDealFields();
    }

    @And("I select the deal that applies at product level with minimum quantity required condition")
    public void iSelectTheDealThatAppliesAtProductLevelWithMinimumQuantityRequiredCondition() {
        tcs.pom.getDealPage().selectProductDealLevelAndSetMinimumQuantityRequired();
    }

    @And("I select the deal that applies at product level with a minimum spend required condition")
    public void iSelectTheDealThatAppliesAtProductLevelWithAMinimumSpendRequiredCondition() {
        tcs.pom.getDealPage().selectProductDealLevelAndSetMinimumSpend();
    }

    @And("I select the offer that applies as basket level and set deal conditions")
    public void iSelectTheOfferThatAppliesAsBasketLevelAndSetDealConditions() {
        tcs.pom.getDealPage().selectBasketDealLevelAndSetSpendAndProductCode();
    }

    @And("I add a product manually and include it in the deal")
    public void iAddAProductManuallyAndIncludeItInTheDeal() {
        tcs.pom.getDealPage().addProductManuallyAndInclude();
    }

    @And("I import product inclusions from a CSV file in the deal")
    public void iImportProductInclusionsFromACSVFileInTheDeal() {
        tcs.pom.getDealPage().importProductInclusionsFromCSV();
    }

    @And("I toggle the Always badge checkbox in deal")
    public void iToggleTheAlwaysBadgeCheckboxInDeal() {
        tcs.pom.getDealPage().toggleAlwaysBadgeCheckbox();
    }

    @And("I set the limit number of applications under Additional configurations")
    public void iSetTheLimitNumberOfApplicationsUnderAdditionalConfigurations() {
        tcs.pom.getDealPage().selectLimitNumberOfApplicationsAndSetPurchaseLimit();
    }

    @And("I select no limit under Additional configurations")
    public void iSelectNoLimitUnderAdditionalConfigurations() {
        tcs.pom.getDealPage().selectNoLimitForPurchase();
    }

    @And("I select Customer eligibility as All Deal Customers")
    public void iSelectCustomerEligibilityAsAllDealCustomers() {
        tcs.pom.getDealPage().selectAllCustomers();
    }

    @And("I select Customer eligibility as Specific deal customer segments")
    public void iSelectCustomerEligibilityAsSpecificDealCustomerSegments() {
        tcs.pom.getDealPage().selectSpecificCustomerSegmentsAndAtLeastOneCheckbox();
    }

    @And("I select Customer eligibility as Deal Exclusions")
    public void iSelectCustomerEligibilityAsDealExclusions() {
        tcs.pom.getDealPage().selectExclusionsAndAtLeastOneCheckbox();
    }

    @And("I select Store eligibility as All Deal Stores")
    public void iSelectStoreEligibilityAsAllDealStores() {
        tcs.pom.getDealPage().selectAllStoresOption();
    }

    @And("I select Store eligibility as Specific Deal Store ID")
    public void iSelectStoreEligibilityAsSpecificDealStoreID() {
        tcs.pom.getDealPage().selectSpecificStoreAndInclude();
    }

    @And("I select a random date and time for the deal offer")
    public void iSelectARandomDateAndTimeForTheDealOffer() {
        tcs.pom.getDealPage().selectRandomDate();
        tcs.pom.getDealPage().selectRandomTime();
    }

    @When("I click the Create Deal button")
    public void iClickTheCreateDealButton() {
        tcs.pom.getDealPage().clickCreateButton();
    }

    @Then("I should see the deal voucher successfully created")
    public void iShouldSeeTheDealVoucherSuccessfullyCreated() {
        tcs.pom.getDealPage().isVoucherCreated();
    }
}