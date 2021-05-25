package Spotify.Spotify;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Spotify_TestCases {

//public static String token;
public static String userId;

public String token(){
	String token = "Bearer BQCTyxOYP4uiyN5SBD6YGbDzndfR8qIESVCmtFHlyKqmFb5ERruuF7_S30bz6LNoLbYRM06m" +
            "0kJla3l4NDWG1s4QxdnTN2HTbnB5218rOAS1RkKIKZNoylvV5ceNsamBnx6jx0-" +
			"WGhsHKPggj64Ll9-RBPprOCEUfL5G1zzIryV_M_bbyuQG07wB9Oa7HBKuAVznSZm-" +
            "ifrO7Qwl1ljcxThsE1BjKOlJB-Jy2l7vzhVwFSt-wrPBDr5J3mK7EKnRF-" +
			"IzpvIOA7bMs84NHmsFrZTmAwTI";
	return token;
}
		
@Test
public void test01_GETUserProfile_ShouldReturn_StatusCode200() {
	Response response = given().contentType(ContentType.JSON)
			                   .accept(ContentType.JSON).header("Authorization", token())
			                   .get( "https://api.spotify.com/v1/me");
	userId = response.then().extract().path("id");
	System.out.println("User Id : "+userId);
	response.prettyPrint();
    response.then().statusCode(200);	
}

public  String token1() {
	 String token1 = "Bearer BQCTyxOYP4uiyN5SBD6YGbDzndfR8qIESVCmtFHlyKqmFb5ERruuF7_S30bz6LNoLbYRM06m" +
            "0kJla3l4NDWG1s4QxdnTN2HTbnB5218rOAS1RkKIKZNoylvV5ceNsamBnx6jx0-" +
			"WGhsHKPggj64Ll9-RBPprOCEUfL5G1zzIryV_M_bbyuQG07wB9Oa7HBKuAVznSZm-" +
            "ifrO7Qwl1ljcxThsE1BjKOlJB-Jy2l7vzhVwFSt-wrPBDr5J3mK7EKnRF-" +
			"IzpvIOA7bMs84NHmsFrZTmAwTI";
	return token1;
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
			                   .header("Authorization", token1())
			                   .body(body.toJSONString())
			                   .post("https://api.spotify.com/v1/users/vb7i57b07flhgt2kpkxhfsm36/playlists");
	response.prettyPrint();
	response.then().statusCode(201);
}

public  String token3() {
	String token3 = "Bearer BQCTyxOYP4uiyN5SBD6YGbDzndfR8qIESVCmtFHlyKqmFb5ERruuF7_S30bz6LNoLbYRM06m" +
            "0kJla3l4NDWG1s4QxdnTN2HTbnB5218rOAS1RkKIKZNoylvV5ceNsamBnx6jx0-" +
			"WGhsHKPggj64Ll9-RBPprOCEUfL5G1zzIryV_M_bbyuQG07wB9Oa7HBKuAVznSZm-" +
            "ifrO7Qwl1ljcxThsE1BjKOlJB-Jy2l7vzhVwFSt-wrPBDr5J3mK7EKnRF-" +
			"IzpvIOA7bMs84NHmsFrZTmAwTI";
	return token3;
}

@Test
public void test03_POSTAddItems_ToPlaylist_ShouldReturn_StatusCode201() {
	String uris = "{\"uris\":[\"spotify:track:2W21xyDCFlrgOzK2Yqv2X5\",\"spotify:track:0EvjYWSwXvMjJNsKeNSPaV\",\"spotify:track:1RlETOQUfMeUmsuchNOaZL\",\"spotify:track:3ncNP7wNX7J0iHTjkmVEsV\",\"spotify:track:4eKVw2OLhcSJSS3kNtGGM6\"]}";
    Response response = given().contentType(ContentType.JSON)
			                   .contentType(ContentType.JSON)
			                   .header("Authorization", token3())
			                   .body(uris)
			                   .post("https://api.spotify.com/v1/playlists/2VTMaG406TpppC1Vuytdv9/tracks");
	response.prettyPrint();
	response.then().statusCode(201);
	System.out.println(response.statusCode());
}

public String token4() {
	String token4 = "Bearer BQCTyxOYP4uiyN5SBD6YGbDzndfR8qIESVCmtFHlyKqmFb5ERruuF7_S30bz6LNoLbYRM06m"+
                    "0kJla3l4NDWG1s4QxdnTN2HTbnB5218rOAS1RkKIKZNoylvV5ceNsamBnx6jx0-"+
                    "WGhsHKPggj64Ll9-RBPprOCEUfL5G1zzIryV_M_bbyuQG07wB9Oa7HBKuAVznSZm-"+
                    "ifrO7Qwl1ljcxThsE1BjKOlJB-Jy2l7vzhVwFSt-wrPBDr5J3mK7EKnRF-"+
                    "IzpvIOA7bMs84NHmsFrZTmAwTI";
	return token4;
}

@Test
public void test04_GETSearch_ForItem_ShouldReturn_StatusCode200() {
	Response response = given().contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			.header("Authorization", token4())
			.queryParam("q","S S Thaman")
            .queryParam("type", "artist")
            .queryParam("market", "in")
            .queryParam("limit", 10)
			.get("https://api.spotify.com/v1/search");
	response.prettyPrint();
	response.then().statusCode(200);
}

public String token5() {
	String token5 = "Bearer BQCTyxOYP4uiyN5SBD6YGbDzndfR8qIESVCmtFHlyKqmFb5ERruuF7_S30bz6LNoLbYRM06m"
			        + "0kJla3l4NDWG1s4QxdnTN2HTbnB5218rOAS1RkKIKZNoylvV5ceNsamBnx6jx0-"
			        + "WGhsHKPggj64Ll9-RBPprOCEUfL5G1zzIryV_M_bbyuQG07wB9Oa7HBKuAVznSZm-" 
			        + "ifrO7Qwl1ljcxThsE1BjKOlJB-Jy2l7vzhVwFSt-wrPBDr5J3mK7EKnRF-"
			        + "IzpvIOA7bMs84NHmsFrZTmAwTI";
	return token5;
}

@Test
public void test04_GETTrack_ShouldReturn_StatusCode200() {
	Response response = given().contentType(ContentType.JSON)
			 .accept(ContentType.JSON)
			.header("Authorization", token5())
			.get("https://api.spotify.com/v1/tracks/0EvjYWSwXvMjJNsKeNSPaV?market=in");
	response.prettyPrint();
	response.then().statusCode(200);
}
	
}
