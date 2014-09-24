Feature: Fee

  @end-to-end
  Scenario: A coffee with just enough money

    Given I've put 30 cents in the monnayeur
    And a shortage of Coffee
    When a Coffee is ordered
    Then a message should be sent indicating there is a shortage of Coffee

    Given the following orders have been taken:
      | drink     | quantity |
      | Coffee    | 1        |
      | Chocolate | 2        |
      | Coffee    | 1        |
      | Tea       | 3        |


  @end-to-end
  Scenario: A shortage of coffee

    Given I've put 30 cents in the monnayeur
    And a shortage of Coffee
    When a Coffee is ordered
    Then a message should be sent indicating there is a shortage of Coffee


