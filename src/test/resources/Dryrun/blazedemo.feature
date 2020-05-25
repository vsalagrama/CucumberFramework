#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Blazedemo Test
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Multiple Tries
    Given open the url
    Given choose departure city "<src>"
    When choose destination city "<desti>"
    Then Find Flights
    Then get screenshot
    Then chose the flight
    Then enter details "<name>" "<zipcode>" "<creditcard>"
    Then validate json
    Then get screenshot
    
    Then close

    Examples: 
      | src      | desti  | name      | zipcode | creditcard      |
      | Portland | Berlin | venkatesh |   12345 | 112311232214124 |
      | Boston   | Rome   | Venkat    |   55454 |    112411241154 |
      
