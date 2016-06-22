Narrative:
As a user
I want to login in gmail account
So that I can send letter

Scenario: Login with an empty login field

Given I am on LogInPage
When I leave login field empty
And I click button "Next"
Then Error message "Please enter your email" is shown

Scenario: Login with an invalid data

Given I am on LogInPage
When I enter an invalid login
And I click button "Next"
Then Error message "Please enter a valid email address" is shown

Scenario: Login with a valid data

Given I am on LogInPage
When I enter a valid login
And I click button "Next"
And I enter a valid password
And I uncheck checkbox "Stay signed in"
And I click button "Sign in"
Then InBoxPage of my account is opened