package steps.resources;

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
public class testsResourcesEndPoint {
    private Response response;
    private String urlApi = "https://reqres.in/api";


    //    Start resources list--------------------------------
    @When("the resource list with GET request to {string}")
    public void getResourceList(String endpoint) {
        response = given()
                .contentType("application/json")
                .when()
                .get(urlApi+endpoint);
    }

    @Then("the response of getResourceList should be {int}")
    public void responseGetResourceList(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain the resource with a name {string}")
    public void getResourceListShouldContainName(String name) {
        boolean nameFound = response.jsonPath()
                .getList("data.name")
                .contains(name);
        Assert.assertTrue(nameFound);
    }

    //END Verify resources list------------------------------------------------

    //Start Verify resource by id---------------------------------------
    @When("get request resource id {int}")
    public void getResourceListById(int id) {
        response = given()
                .contentType("application/json")
                .when()
                .get(urlApi+"/resource/"+id);
    }

    @Then("the response of getResourceListById {int}")
    public void responseGetUserResourceById(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should contain a name {string}")
    public void shouldContainNameGetResourceListById(String email) {
        String nameResource = response.jsonPath().getString("data.name");
        Assert.assertEquals(email, nameResource);
    }

    //END Verify resource by id ------------------------------

    //START Verify put resource --------------------
    @When("put request resource id {int} with a new name {string}")
    public void putRequestResourceId(int id, String name) {
        String requestBody = "{\"name\": \"" + name + "\"}";

        response = given().contentType("application/json")
                .body(requestBody)
                .when()
                .put(urlApi+"/resource/"+id);
    }

    @Then("the response of resource put {int}")
    public void responsePutUser(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response of resource put should has {string}")
    public void putResourceShouldContain(String update) {
        JsonPath jsonPath = response.jsonPath();
        assertThat(jsonPath.getMap("$"), hasKey(update));
    }

    //END  Verify put resource ------------------------------------------------

    //START Verify patch resource --------------------------------------------------
    @When("patch request resource id {int} with a new color {string}")
    public void patchRequestResourceId(int id, String color) {
        String requestBody = "{\"color\": \"" + color + "\"}";

        response = given().contentType("application/json")
                .body(requestBody)
                .when()
                .put(urlApi+"/resource/"+id);
    }

    @Then("the response of resource patch {int}")
    public void responseResourcePatchUser(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response of resource patch should has {string}")
    public void patchResourceShouldContain(String update) {
        JsonPath jsonPath = response.jsonPath();
        assertThat(jsonPath.getMap("$"), hasKey(update));
    }

    //END Verify resource patch

    //START Verify resource delete
    @When("delete request resource id {int}")
    public void deleteRequestResourceId(int id) {
        response = given()
                .when()
                .delete(urlApi+"/resource/"+id);
    }

    @Then("the response of resource delete {int}")
    public void responseDeleteResource(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}
