Feature: Test endpoint users Reqres

  Scenario: Verify user list
    When the user list is requested with GET request to "https://reqres.in/api/users/"
    Then the response status code should be 200
    And the response should contain the user with email "george.bluth@reqres.in"

  Scenario: Verify user by id
    When get request user id "https://reqres.in/api/users/2"
    Then the response 200
    And the response should contain "janet.weaver@reqres.in"