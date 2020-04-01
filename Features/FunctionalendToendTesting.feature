Feature: IBAR Functional end to end Testing 
Description: IBAR test scenarios

Background:
Given Navigate to IBAR webpage

#Please note, before execute testing don't forget to determine chromedriver path in MySteps/CrossBrowser.Java file.
#You can run test secenarios in firefox and chrome as well.
#if you would like to execute test scenarios you can use test runner file.and dont forget to give feture file path as well.

@test
Scenario: Internationalisation 
Then see the page in "AZ" language
Then see the page in "RU" language
Then see the page in "EN" language

@test
Scenario: Global Quick Search
Given User types "American Express" to search area
Then Verify there are displayed two card options


@test
Scenario: Form Input Validation  
Given User clicks Order credit online button
Then Verify user is navigated to a new page with the urgent credit order form
Given When the user attempts to submit a form which has form fields that have not been completed see form field validation error messages



