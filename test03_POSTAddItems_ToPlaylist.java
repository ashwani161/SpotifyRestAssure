package Spotify.Spotify;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class test03_POSTAddItems_ToPlaylist {

		public static String token = setup();
		public static String userId;

		public static String setup() {
			token = "Bearer BQAOGb7S_yhct2f8uJZef7G0HY17UIOIAU8sh9-" +
		            "QhSpp4uye9QdtLXMv3AfTWYeH5ZI3QY4SMJo_J15q0xpSq2KYPsGCJYgXJg1y0Av92rkUrPh" +
					"A2kqpWqCfsLNyFgUEYkV_JDalHlDbvUa2R8YOup1rTPJMqC6xdVoUPUWlnxtlGUs06qunYEH" +
		            "mwzmvCCKk4zCXvHox-" +
					"rtgPaBICvi2uKSqM0vnGobufJlNnJxItJVU3wdAsYeU122_dLq3XjxitODogWc6uD-" +
		            "5GvWuSA_0DTsJr4M3";
			return token;
		}
		
		@Test
		public void test03_POSTAddItems_ToPlaylist_ShouldReturn_StatusCode201() {
			String uris = "{\"uris\":[\"spotify:track:2W21xyDCFlrgOzK2Yqv2X5\",\"spotify:track:0EvjYWSwXvMjJNsKeNSPaV\",\"spotify:track:1RlETOQUfMeUmsuchNOaZL\",\"spotify:track:3ncNP7wNX7J0iHTjkmVEsV\",\"spotify:track:4eKVw2OLhcSJSS3kNtGGM6\"]}";
		    Response response = given().contentType(ContentType.JSON)
					                   .contentType(ContentType.JSON)
					                   .header("Authorization", token)
					                   .body(uris)
					                   .post("https://api.spotify.com/v1/playlists/2VTMaG406TpppC1Vuytdv9/tracks");
			response.prettyPrint();
			response.then().statusCode(201);
			System.out.println(response.statusCode());
		}
}


