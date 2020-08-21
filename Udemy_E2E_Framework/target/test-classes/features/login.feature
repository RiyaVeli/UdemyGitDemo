Feature: WebPage Login

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on Login link to land on Secure signIn page
When User enters <username> and <password> and click login
Then Verify user login status 

Examples:
|username					|password	|
|test99@gmail.com			|123456		|
|nonrestricteduser@qw.com	|123456		|
|restricteduser@qw.com		|45678		|