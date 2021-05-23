package Spotify.Spotify;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class test01_GETUserProfile {

public static String token = setup();
public static String userId;

public static String setup() {
	token = "Bearer BQBwi54J8DK0SP25EmzjrI5SDUfGt1ZcuYMlZ8FI1jpPcuvAC-" +
            "PvPtevhFdC2rPYZ5iB-9yzqyVqEMgg_IeV-" +
			"sIOIZP2dDVoPMfuB32XudoTZbTIHvdj9tQgCIpQMuHD5pvjZ-PaS_CMHdVuKvV--" +
            "OvGsaWicC7NbuAVjB5_3J1hw1zp8AjGfZuHHkNGfZl2RHx2rwcSuwSijzSBF8oM_7TSfhpz1" +
			"Oozo5NNNoqQdvnD18wIZYPVpUdk-HrCVhFWK7EO3BNOnWe4fJ_3STa5U0X4sA";
	return token;
}
		
@Test
public void test01_GETUserProfile_ShouldReturn_StatusCode200() {
	Response response = given().contentType(ContentType.JSON)
			                   .accept(ContentType.JSON).header("Authorization", token)
			                   .get( "https://api.spotify.com/v1/me");
	userId = response.then().extract().path("id");
	System.out.println("User Id : "+userId);
	response.prettyPrint();
    response.then().statusCode(200);	
}
	
}
