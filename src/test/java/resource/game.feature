Feature: Game

  Scenario: User wins
     Given The user will choose "Scissors"
    And the computer will choose "Paper"
    When they play
    Then the user wins