Feature: Fee

  @end-to-end
  Scenario: A coffee

    When a Coffee is ordered
    Then a Coffee should be prepared
    Then the drink should be prepared
    #Then a Coffee with no sugar and no stick should be prepared

  Scenario: A tea

    When a Tea is ordered
    Then a Tea should be prepared


  @command
  Scenario: A coffee with one sugar

    When a Coffee with one sugar is ordered
    Then the command sent to the drink maker should be "C:1:0"