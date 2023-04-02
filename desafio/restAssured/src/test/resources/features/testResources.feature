Feature: Tests endpoint /resources

  Scenario: Verify resource list
    When the resource list with GET request to "/resources"
    Then the response of getResourceList should be 200
    And the response should contain the resource with a name "fuchsia rose"

  Scenario: Verify resource by id
    When get request resource id 3
    Then the response of getResourceListById 200
    And the response should contain a name "true red"

  Scenario: Verify put resource
    When put request resource id 2 with a new name "really red"
    Then the response of resource put 200
    And  the response of resource put should has "name"

  Scenario: Verify patch user
    When patch request resource id 2 with a new color "#FFFFF"
    Then the response of resource patch 200
    And  the response of resource patch should has "color"

  Scenario: Verify delete resource
    When delete request resource id 3
    Then the response of resource delete 204