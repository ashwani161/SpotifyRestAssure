package Spotify.Spotify;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class test05_GETTrack {
	
	public static String token = setup();
	public static String userId;

	public static String setup() {
		token = "Bearer BQCdLXLePb3ZHPk0dfCnOcEZXIS-_Z1iBDf5zJ6-E-W_YkQgAunXa12uznaIo0Ps-"
				+ "4WqxU6lSR1FAid9XyBO8p5qpsS0YctTQNOP0ADB-CyRJ8qAD-"
				+ "Xl3qGkl07Y2Ucs3BXFU67G7hiugrplZPKvBjEDqQ8rtlp8Z5amuNuv6Edui4DOYvLVv69IXC" 
				+ "eg70nOVAMbYsUIXsIk4n00xRfv2zCUydCGXrO6LASU1lswMJ4U_PExI7-"
				+ "kBShsKSQGPslCSLUCIXEwZOQqKGD_VqfDtlZHprN-";
		return token;
	}

	@Test
	public void test04_GETTrack_ShouldReturn_StatusCode200() {
		Response response = given().contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				.header("Authorization", token)
				.get("https://api.spotify.com/v1/tracks/0EvjYWSwXvMjJNsKeNSPaV?market=in");
		response.prettyPrint();
		response.then().statusCode(200);
	}

}
