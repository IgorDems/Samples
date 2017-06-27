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
Feature: Test WS Smoke scenario

  @tag1
  Scenario: Login test into WS with valid credentials
    Given Open web browser and start app
    When I enter valid "qauber.sa1@mailinator.com" and valid "123456"
    And Push login button
    Then User sould be able to login successfully

  #	Examples:
  #	| uname  										 | passwd |
  #	| qauber.sa1@mailinator.com  | 123456 |
  #	|	dems_i@mail.ru						 |11111111|
  @tag2
  Scenario: entity
    Given Main page start app
    When Navigate to entity page
    Then We are on entity page

  @tag3
  Scenario: Choicing a department
    When Make a choice the department "Dep 11"
    Then Subject Information page

  @tag4
  Scenario: Subject Information
    When Fill in all fields of Subject Information
    Then Go to Identifiers page

  @tag5
  Scenario: Identifiers
    When Fill in all fields of Identifiers
    Then Go to ID Information page

  @tag6
  Scenario: ID Information
    When Fill in all fields of ID Information
    Then Go to Gang Membership page

  @tag7
  Scenario: Gang Membership
    When Fill in all fields of Gang Membership
    Then Go to Vehicle page

  @tag8
  Scenario: Vehicle
    When Fill in all fields of Vehicle
    Then Go to Photos page

  @tag9
  Scenario: Photos
    When Adding Photos by link
    Then Go to finish page

  @tag10
  Scenario: Photos
    Given Filled fillds
    When Adding report
    Then Check the report
#Scenario Outline: Title of your scenario outline
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
