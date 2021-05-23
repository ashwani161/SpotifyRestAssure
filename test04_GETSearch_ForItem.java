package Spotify.Spotify;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class test04_GETSearch_ForItem {

	public static String token = setup();
	public static String userId;

	public static String setup() {
		token = "Bearer BQDBN74-"+
	"1YuKYnEGY9lGjOVtwGWj8chhGzaoTEa6N8XmpCNjrrITztxQLy_qGUzcLHVwts1wHkZZsdoM"+
	"OVTNuA15UdYMNMv6t-VTRKJMJ-"+
	"eYnLAj5CqmGu8xT2tIaBrWni61STH6ZmoPvr0X0YfO_SCVc0vch53gWu3mjsggXcwrfvt8cXeqA27cB6Vnt-"+
	"8V3vR0wInbgj4cq5RgCv22vnXa5RL8N4gSZhd4GUQ2c5uHiyF1Q7j7wfLxicDkKjbC4O1rFHM1OLcr6-047VRqg7MvlPPZ";
		return token;
	}

	@Test
	public void test04_GETSearch_ForItem_ShouldReturn_StatusCode200() {
		Response response = given().contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				.header("Authorization", token)
				.queryParam("q","S S Thaman")
                .queryParam("type", "artist")
                .queryParam("market", "in")
                .queryParam("limit", 10)
				.get("https://api.spotify.com/v1/search");
		response.prettyPrint();
		response.then().statusCode(200);
	}
}
