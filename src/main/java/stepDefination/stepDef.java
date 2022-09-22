package stepDefination;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class stepDef {
    @Given("Send to {string} {string} {string} request with {string} for store api")
    public void sendToRequestWithForStoreAPI(String domain,String url, String id, String method){
        Response response = null;
        String fullPath="";
        if(id.isEmpty()) {
            fullPath= URL_EnumList.valueOf(domain).getUrl()+ URL_EnumList.valueOf(url).getUrl();
        }
        else
            fullPath= URL_EnumList.valueOf(domain).getUrl()+ URL_EnumList.valueOf(url).getUrl()+"/"+id;


        switch (method){
            case "get","Get","GET"->
                    response= RestAssured.given().accept(ContentType.JSON).get(fullPath);
            case "post","POST","Post"->
                response= RestAssured.given().accept(ContentType.JSON).body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 0,\n" +
                        "  \"shipDate\": \"2022-09-04T19:18:20.590Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}").post(fullPath);
        }
        
        response.prettyPrint();
    }

    @Given("Assert to status code {int}")
    public void assert_to_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
