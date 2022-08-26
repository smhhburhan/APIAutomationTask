package services;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static services.PostPetIdTest.petId;

public class GetPetById3Test  {

    String baseURI = "https://petstore.swagger.io/v2/";


    @Test
    public void GETPetById3() {



        //String response =
        given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/" + petId)
                .then()
                //.assertThat()
                .log()
                .all()
                .statusCode(404);
        //.extract().response().asString();

        //System.out.println("----------" + "\n" + "After DELETE \\pet\\petId Method, response of GET \\pet\\petId with DELETED Pet id " + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
