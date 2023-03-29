import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Assertions;


public class TestGestRestAssured {
	@Test
	public void testUserById(){
		Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.get("https://reqres.in/api/users/2")
				.then()
				.extract().response();
		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("Janet", response.jsonPath().getString("data.first_name"));
		Assertions.assertEquals("Weaver", response.jsonPath().getString("data.last_name"));
		Assertions.assertEquals("janet.weaver@reqres.in", response.jsonPath().getString("data.email"));
		System.out.println("Status Code: "+response.statusCode());
	}
}
