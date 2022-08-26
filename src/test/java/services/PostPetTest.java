package services;

import body.PostPet;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PostPetTest {

    static String baseURI = "https://petstore.swagger.io/v2/";
    static long petId;

    @Test
    public void POSTPet() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body(PostPet.PostPetBody())
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of POST \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

        JsonPath jp = new JsonPath(response);
        petId = jp.getLong("id");
        System.out.println("Pet id:" + petId + "\n" + "----------");

    }

}