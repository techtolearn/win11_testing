Feature: User Login Functionality

  Background:
    Given The application is launched
    And The user is on the login page

  @Regression
  Scenario: Successful Login
    Given The user enters valid credentials
    When The user clicks the login button
    Then The user should be redirected to the dashboard

  @System
  Scenario Outline: Login with multiple credentials
    Given The user enters "<username>" and "<password>"
    When The user clicks the login button
    Then The login status should be "<status>"

    Examples:
      | username | password  | status  |
      | admin    | admin123  | success |
      | user1    | wrong123  | failure |
      | user2    | pass456   | success |

  Scenario: Failed Login with Invalid Credentials
    Given The user enters invalid credentials
    When The user clicks the login button
    Then An error message should be displayed

  Scenario: Remember Me Functionality
    Given The user enters valid credentials
    And The user selects the "Remember Me" checkbox
    When The user clicks the login button
    Then The user should remain logged in after reopening the browser

  Scenario: Forgot Password Functionality
    Given The user clicks on the "Forgot Password" link
    When The user enters their registered email
    And The user clicks the "Reset Password" button
    Then A password reset link should be sent to the registered email
