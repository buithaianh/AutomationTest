@popup
Feature: Behavior on Dialogs and Alerts

  Scenario: Answer the prompt box
    Given the page "http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt" is visited
    And go inside the "id=iframeResult" frame
    And input "Baymax" on prompt dialog box "css=button"
    Then assert that the text "id=demo" element is "Hello Baymax! How are you today?"
 
  Scenario: Dimiss the confirm box
    Given the page "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm" is visited Two 
    And go inside the "id=iframeResult" frame Two
    And choose CANCEL on confirm dialog box "css=button" Two
    Then assert that the text "id=demo" element is "You pressed Cancel!" Two

  Scenario: Accept the confirm box
    Given the page "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm" is visited Three
    And go inside the "id=iframeResult" frame Three
    And choose OK on confirm dialog box "css=button" Three
    Then assert that the text "id=demo" element is "You pressed OK!" Three
 @Runme
  Scenario: Verify text on the popup
    Given the page "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm" is visited Four
    And go inside the "id=iframeResult" frame Four
    Then assert that text on "css=button" popup box is "Please enter your name" Four
