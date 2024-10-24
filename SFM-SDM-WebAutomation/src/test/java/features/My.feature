Feature: My

  @My
  Scenario: My - for test #TC001
    Given Given Scenario
      | Excel         | Location                                           | Sheet    |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Loyalty |
    When When Scenario
    And And Scenario
    Then Then Scenario
      | Excel         | Location                                           | Sheet    |
      | ddt_data.xlsx | src/main/java/resources/externalData/ddt_data.xlsx | Loyalty |
  @LoyaltyOfferCreditPoints
  Scenario: Create a loyalty offer with Credit Points TC-1
    Given I am on the Promotions page and I click on Loyalty Offers
    When I select Shoppers Drug Mart as the store
    And I create a loyalty offer with "creditPoints"
    And I fill the loyalty offer input fields
    And I select the offer that applies at product level with no conditions
#    And I select the offer that applies at product level with a minimum quantity required condition
#    And I select the offer that applies at product level with a minimum spend amount condition
#    And I select the offer that applies as basket level and set Offer conditions
    And I add a product manually and include it in the offer
#    And I import product inclusions from a CSV file
    And I toggle the Always badge checkbox
    And I set the priority points for the offer
    And I select Customer eligibility as All Customers
#    And I select Customer eligibility as Specific customer segments
#    And I select Customer eligibility as Exclusions
    And I select Store eligibility as All Stores
#    And I select Store eligibility as Specific Store ID
    And I select a random date and time for the offer
    When I click the Create button
    Then I should see the voucher successfully created

  @LoyaltyOfferPointsMultiplier
  Scenario: Create a loyalty offer with Points Multiplier TC-2.0
    Given I am on the Promotions page and I click on Loyalty Offers
    When I select Shoppers Drug Mart as the store
    And I create a loyalty offer with "pointsMultiplier"
    And I fill the loyalty offer input fields
    And I select the offer that applies at product level with no conditions
#    And I select the offer that applies at product level with Product Purchase Condition
#    And I select the offer that applies at product level with a minimum spend amount condition
#    And I select the offer that applies as basket level and set Offer conditions
    And I add a product manually and include it in the offer
#    And I import product inclusions from a CSV file
    And I toggle the Always badge checkbox
    And I set the priority points for the offer
    And I select Customer eligibility as All Customers
#    And I select Customer eligibility as Specific customer segments
#    And I select Customer eligibility as Exclusions
    And I select Store eligibility as All Stores
#    And I select Store eligibility as Specific Store ID
    And I select a random date and time for the offer
    When I click the Create button
    Then I should see the voucher successfully created

  @LoyaltyOfferRedemption
  Scenario: Create a loyalty offer with Redemption TC-3.0
    Given I am on the Promotions page and I click on Loyalty Offers
    When I select Shoppers Drug Mart as the store
    And I create a loyalty offer with "redemption"
    And I fill the loyalty offer input fields
    And I select the offer that applies at product level with no conditions
#    And I select the offer that applies at product level with a minimum quantity required condition
#    And I select the offer that applies at product level with a minimum spend amount condition
#    And I select the offer that applies as basket level and set Offer conditions
    And I add a product manually and include it in the offer
#    And I import product inclusions from a CSV file
    And I toggle the Always badge checkbox
    And I set the priority points for the offer
    And I select Customer eligibility as All Customers
#    And I select Customer eligibility as Specific customer segments
#    And I select Customer eligibility as Exclusions
    And I select Store eligibility as All Stores
#    And I select Store eligibility as Specific Store ID
    And I select a random date and time for the offer
    When I click the Create button
    Then I should see the voucher successfully created

  @DealPurchaseWithPurchases
  Scenario: Create a loyalty offer with Credit Points TC-2
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    #And I select the deal that applies at product level with a minimum spend required condition
    #And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    #And I import product inclusions from a CSV file in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    #And I select no limit under Additional configurations
    And I select Customer eligibility as All Deal Customers
    #And I select Customer eligibility as Specific deal customer segments
    #And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as All Deal Stores
    #And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

  @DealPurchaseWithPurchases
  Scenario: Create a loyalty offer with Credit Points TC-2
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Giftwithpurchase"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    #And I select the deal that applies at product level with a minimum spend required condition
    #And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    #And I import product inclusions from a CSV file in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    #And I select no limit under Additional configurations
    And I select Customer eligibility as All Deal Customers
    #And I select Customer eligibility as Specific deal customer segments
    #And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as All Deal Stores
    #And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created