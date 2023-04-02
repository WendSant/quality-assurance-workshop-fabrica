Feature: Test endpoint users Reqres

  Scenario: Verify user list
    When the user list is requested with GET request to "/users"
    Then the response status code should be 200
    And the response should contain the user with email "george.bluth@reqres.in"

  Scenario: Verify user by id
    When get request user id 2
    Then the response 200
    And the response should contain "janet.weaver@reqres.in"
#
  Scenario: Verify put user
    When put request user id 2 with a new email "teste@email.com"
    Then the response of put 200
    And  the response of put should has "email"
#
  Scenario: Verify patch user
    When patch request user id 2 with a new first name "Carlos"
    Then the response of patch 200
    And  the response of patch should has "first_name"

  Scenario: Verify delete user
    When delete request user id 2
    Then the response of delete 204
