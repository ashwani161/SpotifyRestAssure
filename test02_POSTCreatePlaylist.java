package Spotify.Spotify;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class test02_POSTCreatePlaylist {

	public static String token = setup();
	public static String userId;

	public static String setup() {
		token = "Bearer BQDbNP3H_hilV7JWQxWFzB6N-AsA5i5d1rNedp5mqRrUa-" +
	            "emUi1A5AXGOkJe9hUlDIHDpFg3mAlTY-sc2_G7VaDbpS-" +
				"GpANMBftQIywbJ3jEIi7H8sQlmXlt2QGl1HWRRN4Bde_HX7fwH5i89Izixpbz1EXkVK2070c" +
	            "9MQ6My_2YrnsFOBRIgg43uNmlKmLnLWEZY85GQRhEJGGPcjAN1RtLqC_VTIULoL5LoogrEX-" +
				"xVhZhFJnFTHL3sP9wJhlxHmnsi7fhjBM9f7G-QG64w-HyVw";
		return token;
	}
	
	@Test
	public void test02_POSTCreatePlaylist_ShouldReturn_StatusCode201() {
		//String[] uris = {"name","S P Bala Subramanyam","description","SongsList","public", "false" };
		JSONObject body = new JSONObject();
		body.put("name","S P Bala Subramanyam");
		body.put("description","SongsList");
		body.put("public", "false");
      	Response response = given().contentType(ContentType.JSON)
				                   .accept(ContentType.JSON)
				                   .header("Authorization", token)
				                   .body(body.toJSONString())
				                   .post("https://api.spotify.com/v1/users/vb7i57b07flhgt2kpkxhfsm36/playlists");
		response.prettyPrint();
		response.then().statusCode(201);
	}
}
