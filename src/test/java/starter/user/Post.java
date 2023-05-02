package starter.user;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
public class Post {
    @Step("I perform POST.operational for login")
    public void PerformPOSToperationalforlogin() {
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("username", "mor_2314");
        postContent.put("password", "83r5^_");

        given().contentType(ContentType.JSON);
        with().body(postContent);
        when().post("https://fakestoreapi.com/auth/login");
    }


    @Step("I receive valid HTTP response code 201")
    public void receiveHttpResponseCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

}