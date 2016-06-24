@browser
Feature: Window

  Scenario: Demo in English version
    Given the home page is visited
    And the page "http://live.guru99.com/" is visited one
    And the page is refreshed
    And maximize the window
    And go backward one page
    And go forward one page
    And the page "https://cucumber.io/" is opened on another window
    Then assert that the "Describe behaviour in plain text" text is present
    And assert that the "Write a step definition in Java" text is not present
    And assert that the page title is "Cucumber"
    And assert that the page title is not "Serenity BDD"
    And assert that the page title has "Cu"
    And assert that the page title does not have "Cucun"
    And assert that the url is "https://cucumber.io/"
	And assert that the url is not "https://cucumber.com/"
    When window dimension is changed with size (300,500)
    And scroll up or down in screen with value (0,1000)
    And window is moved to location with coordinates (200,300) one
    And close current window one
    And switch back to the original window one
    And open "link=TV" link in new window and switch to it
    And close current window two
    And switch back to the original window two
    And open "css=img[alt='Additional Options']" dialog and switch to it
    And window is moved to location with coordinates (150,200) two
    And maximize the window one
    And close current window three
    And switch back to the original window three
    And window dimension is changed with size (300,500) one
    And window is moved to location with coordinates (100,200) three