Feature: Unlimit Test Project
    Background: Create a user
            Given Get response of api whose url is https://randomuser.me/api/
            Then Get all details of sender

    Scenario: Test case 1
        Given Get response of api whose url is https://randomuser.me/api/
        Then Get all details of recipient
        Given Open Url - https://parabank.parasoft.com/parabank/index.htm
        Given Click on Register link
        Then Enter sender details in field
        Given Click on Register button
        But Check if user already present or not
        Then Verify h1 heading text should be Welcome {}
        And Click on Bill Pay link


