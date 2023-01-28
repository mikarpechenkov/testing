Feature: Mathematical operations
  Scenario: Sum
    Given that "mainCalculatorPane" exists
    When expression is 2.0 "plus" 9.0
    When click "equalsButton" button
    Then answer is 11.0

    Scenario: Subtraction
      Given that "mainCalculatorPane" exists
      When expression is 2 "minus" 8.99
      When click "equalsButton" button
      Then answer is -6.99
      Then information message is "Все супер!"

      Scenario: Multiply
        Given that "mainCalculatorPane" exists
        When expression is 99 "multiply" 1
        When click "equalsButton" button
        Then answer is 99
        Then information message is "Все супер!"

        Scenario: Correct division
          Given that "mainCalculatorPane" exists
          When expression is 88 "divide" 11
          When click "equalsButton" button
          Then answer is 8
          Then information message is "Все супер!"

          Scenario: Wrong division
            Given that "mainCalculatorPane" exists
            When expression is 0.00 "divide" 0
            When click "equalsButton" button
            Then information message is "Делитель должен быть больше"
