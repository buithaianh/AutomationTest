Feature: General Steps

  Scenario: Element attribute in English
    Given the page "http://live.guru99.com/" is visited first
    Then assert that the "alt" attribute of "xpath=//div[2]/a/img" is "Additional Options" text
    Then assert that the "title" attribute of "xpath=//div[2]/a/img" is "Additional Options" string
    Then assert that the "src" attribute of "xpath=//div[2]/a/img" is "https://www.paypalobjects.com/en_US/i/bnr/bnr_nowAccepting_150x60.gif"
    Then assert that the "src" attribute of "xpath=//div[2]/a/img" has "bnr_nowAccepting_150x60.gif"
    Then assert that the "src" attribute of "xpath=//div[2]/a/img" does not have "bnr_nowAccepting.gif"
    Then assert that the "src" attribute of "xpath=//div[2]/a/img" is not "https://www.paypalobjects.com"