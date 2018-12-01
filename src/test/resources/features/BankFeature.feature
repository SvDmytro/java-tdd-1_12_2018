@Bank
@All
Feature: BankFeature

  @Transfer
  Scenario: Bank Transfer
    Given Create bank with name Amigos
    And Add account with name: 2002 ownerName: Brajan balance: 1000
    And Add account with name: 2003 ownerName: Dżesika balance: 1500
    When Transfer 200 zł from 2002 to 2003
    Then Account 2002 has balance: 800
    Then Account 2003 has balance: 1700
