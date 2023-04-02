package steps.users;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.matchesRegex;

public class testsUsersEndPoint {

    private Response response;
    private String urlApi = "https://reqres.in/api";
//    Start Verify user list--------------------------------
    @When("the user list is requested with GET request to {string}")
    public void the_user_list_is_requested_with_GET_request_to(String endpoint) {
        response = given()
                .contentType("application/json")
                .when()
                .get(urlApi+endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain the user with email {string}")
    public void the_response_should_contain_the_user_with_email(String email) {
        boolean emailFound = response.jsonPath()
                .getList("data.email")
                .contains(email);
        Assert.assertTrue(emailFound);
    }

    //END Verify user list------------------------------------------------


    // Start Verify user by id---------------------------------------------
    @When("get request user id {int}")
    public void the_user_list_is_requested_with_GET_request_to_two(int id) {
        response = given()
                .contentType("application/json")
                .when()
                .get(urlApi+"/users/"+id);
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

    //END Verify user by id----------------------------------------

    //START Verify put user------------------------------------------
    @When("put request user id {int} with a new email {string}")
    public void putRequestUserId(int id, String email) {
        String requestBody = "{\"email\": \"" + email + "\"}";

        response = given().contentType("application/json")
                .body(requestBody)
                .when()
                .put(urlApi+"/users/"+id);
    }

    @Then("the response of put {int}")
    public void responsePutUser(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response of put should has {string}")
    public void putShouldContain(String update) {
        JsonPath jsonPath = response.jsonPath();
        assertThat(jsonPath.getMap("$"), hasKey(update));
    }

    //END Verify put user--------------------

    //START Verify patch user--------------------------------------------------
    @When("patch request user id {int} with a new first name {string}")
    public void patchRequestUserId(int id, String name) {
        String requestBody = "{\"first_name\": \"" + name + "\"}";

        response = given().contentType("application/json")
                .body(requestBody)
                .when()
                .put(urlApi+"/users/"+id);
    }

    @Then("the response of patch {int}")
    public void responsePatchUser(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response of patch should has {string}")
    public void patchShouldContain(String update) {
        JsonPath jsonPath = response.jsonPath();
        assertThat(jsonPath.getMap("$"), hasKey(update));
    }
    // END Verify patch user--------------------------------------------
    @When("delete request user id {int}")
    public void deleteRequestUserId(int id) {
        response = given()
                .when()
                .delete(urlApi+"/users/"+id);
    }

    @Then("the response of delete {int}")
    public void responseDeleteUser(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
