Feature: Unlimit Test Project

    Scenario: Test case 1
        Given Get response of api whose url is https://randomuser.me/api/
        Then Get all details of recipient
        Given Open Url - https://parabank.parasoft.com/parabank/index.htm
        Given Click on Register link
        Then Enter recipient details in field
        Given Click on Register button
        But Check if user already present or not
        Then Verify welcome heading should be Welcome {recipient}
        And Click on Bill Pay link
        And Get recipient account number
        And Click on Logout link
        Given Click on Register link
        Given Get response of api whose url is https://randomuser.me/api/
        Then Get all details of sender
        Then Enter sender details in field
        Given Click on Register button
        But Check if user already present or not
        Then Verify welcome heading should be Welcome {sender}
        And Click on Bill Pay link
        And Enter payee details
        And Enter amount of dollar 100.00
        Given Click on Send Payment button
        Then Verify h1 heading text should be Bill Payment Service
        Then Verify payment successful message with amount should be $100.00



