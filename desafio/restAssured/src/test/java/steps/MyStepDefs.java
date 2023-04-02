package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class MyStepDefs {

    private Response response;

    @When("the user list is requested with GET request to {string}")
    public void the_user_list_is_requested_with_GET_request_to(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain the user with email {string}")
    public void the_response_should_contain_the_user_with_email(String email) {
        boolean emailFound = response.jsonPath().getList("data.email").contains(email);
        Assert.assertTrue(emailFound);
    }

    @When("get request user id {string}")
    public void the_user_list_is_requested_with_GET_request_to_two(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response {int}")
    public void the_response_status_code_should_be_two(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain_the_user_with_email_two(String email) {
        String actualEmail = response.jsonPath().getString("data.email");
        Assert.assertEquals(email, actualEmail);
    }
}
