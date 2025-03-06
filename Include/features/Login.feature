@Login
Feature: Title of your feature
  I want to use this template for my feature file

  @LoginValid
  Scenario Outline: Title of your scenario outline
    Given user berada di login page
    When user input <username> dan <password>
    And user klik login
    Then user berhasil login

    Examples: 
      | username | password |
      | standard_user | secret_sauce |