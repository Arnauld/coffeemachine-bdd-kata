Feature: My first feature file

  @mock
  Scenario: My First scenario

    When I order a Coffee
    Then the command sent should be "C::"

  @endToEnd
  Scenario: My First scenario

    When I order a Coffee
    Then the command sent should be "C::"

  @mock
  Scenario: Tea

    When I order a Tea
    Then the command sent should be "T::"
