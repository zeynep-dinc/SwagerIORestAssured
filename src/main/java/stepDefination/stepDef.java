package stepDefination;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class stepDef {

    Response response=null;
    String fullPath="";
    String requestBody="";

    @Given("Set to request body for store {string} string")
    public void setToRequestBodyStringValue( String bodyReqestValue) {
        requestBody="{\n"+bodyReqestValue.replaceAll("\n","\n").replaceAll("'","\"")+"\n}";
        System.out.println(requestBody);
    }


        @Given("Send to {string} {string} {string} request with {string} for store api")
    public void sendToRequestWithForStoreAPI(String domain, String url, String id, String method) {
        if (id.isEmpty()) {
            fullPath = URL_EnumList.valueOf(domain).getUrl() + URL_EnumList.valueOf(url).getUrl();
        } else
            fullPath = URL_EnumList.valueOf(domain).getUrl() + URL_EnumList.valueOf(url).getUrl() + "/" + id;

            System.out.println(fullPath);

        switch (method) {
            case "get", "Get", "GET" ->
            {
                if(id.isEmpty()) {
                    response = given().accept(ContentType.JSON).get(fullPath);
                }
                else
                {
                    response=given().accept(ContentType.JSON).body(requestBody).get(fullPath);
                }
            }
            case "post", "POST", "Post" -> response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(requestBody).post(fullPath);
            case "del","delete","DELETE","DEL"->response = given().accept(ContentType.JSON).body(requestBody).delete(fullPath);

        }

        response.prettyPrint();
    }

    @Given("Send to {string} {string} {string} {string} request with {string} for pet api")
    public void sendToRequestWithForPetAPI(String domain, String url,String status ,String id, String method) {
        if (id.isEmpty()) {
            fullPath = URL_EnumList.valueOf(domain).getUrl() + URL_EnumList.valueOf(url).getUrl();
        } else
            fullPath = URL_EnumList.valueOf(domain).getUrl() + URL_EnumList.valueOf(url).getUrl() + "/" + id;

        if (!status.isEmpty()) {
            fullPath = URL_EnumList.valueOf(domain).getUrl() + URL_EnumList.valueOf(url).getUrl() + status;
        }

        System.out.println(fullPath);
        switch (method) {
            case "get", "Get", "GET" -> response = given().accept(ContentType.JSON).get(fullPath);
            case "post", "POST", "Post" -> response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(requestBody).post(fullPath);
            case "del","delete","DELETE","DEL"->response = given().accept(ContentType.JSON).body(requestBody).delete(fullPath);

        }

        response.prettyPrint();
    }
    @Given("Assert to status code {int}")
    public void assert_to_status_code(Integer expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode);
    }
}
