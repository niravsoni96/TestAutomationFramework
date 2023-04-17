package endpoints;
import payload.Userpayload;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createEmp(Userpayload payload){
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
			
	}

	public static Response getemp(String username) {

		Response response = given().pathParam("username", username)
				.when()
				 	.get(Routes.get_all_emp);

		return response;

	}

}
