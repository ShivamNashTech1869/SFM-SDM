Feature: Deal

@DealPurchaseWithPurchases
Scenario: Create a loyalty offer with Credit Points
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

# TC-1.0: Minimum Quantity Required, Add Product Manually, All Deal Customers, All Deal Stores
  @Deal1.0
  Scenario: Create a deal with Credit Points TC-1.0
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.1: Minimum Spend Required, Add Product Manually, All Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.1
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with a minimum spend required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.2: Basket Level, Add Product Manually, All Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.2
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.3: Minimum Quantity Required, Import from CSV, All Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.3
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I import product inclusions from a CSV file in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.4: Minimum Spend Required, Add Product Manually, All Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.4
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with a minimum spend required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.5: Basket Level, Add Product Manually, Specific Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.5
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.6: Minimum Quantity Required, Add Product Manually, Deal Exclusions, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.6
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.7: Minimum Spend Required, Add Product Manually, All Deal Customers, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.7
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with a minimum spend required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.8: Minimum Quantity Required, Add Product Manually, Specific Deal Customers, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.8
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.9: Basket Level, Add Product Manually, All Deal Customers, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.9
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as All Deal Customers
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.10: Minimum Quantity Required, Add Product Manually, Deal Exclusions, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.10
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.11: Minimum Spend Required, Add Product Manually, Specific Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.11
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with a minimum spend required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.12: Basket Level, Add Product Manually, Deal Exclusions, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.12
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.13: Minimum Quantity Required, Add Product Manually, Specific Deal Customers, Specific Deal Store ID
  @Deal
  Scenario: Create a deal with Credit Points TC-1.13
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with minimum quantity required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as Specific Deal Store ID
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.14: Minimum Spend Required, Add Product Manually, Deal Exclusions, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.14
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the deal that applies at product level with a minimum spend required condition
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Deal Exclusions
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created

# TC-1.15: Basket Level, Add Product Manually, Specific Deal Customers, All Deal Stores
  @Deal
  Scenario: Create a deal with Credit Points TC-1.15
    Given I am on the Promotions page and I click on Deal
    When I select Shoppers Drug Mart as the store for deal
    And I create a deal with "Purchasewithpurchases"
    And I fill the deal input fields
    And I select the offer that applies as basket level and set deal conditions
    And I add a product manually and include it in the deal
    And I toggle the Always badge checkbox in deal
    And I set the limit number of applications under Additional configurations
    And I select Customer eligibility as Specific deal customer segments
    And I select Store eligibility as All Deal Stores
    And I select a random date and time for the deal offer
    When I click the Create Deal button
    Then I should see the deal voucher successfully created
