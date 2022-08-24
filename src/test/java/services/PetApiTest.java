package services;

import body.PostPet;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PetApiTest {

    static String baseURI = "https://petstore.swagger.io/v2/";
    static long petId;

    @Test(priority = 1)
    public static void POSTPet() {

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

    @Test(priority = 2)
    public void GETPetById() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of GET \\pet\\petId" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

    @Test(priority = 3)
    public static void PUTPet() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body("{\n" +
                        "  \"id\": " + petId + ",\n" +
                        "  \"name\": \"cattie\"\n" +
                        "}")
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of PUT \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

    @Test(priority = 4)
    public void GETPetById2() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "After PUT \\pet Method, response of GET \\pet\\petId with last Pet id " + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

    @Test(priority = 5)
    public void DELETEPet() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .delete("/pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of DELETE \\pet\\petId" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

    @Test(priority = 6)
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
                .assertThat()
                .log()
                .all()
                .statusCode(404);
        //.extract().response().asString();

        //System.out.println("----------" + "\n" + "After DELETE \\pet\\petId Method, response of GET \\pet\\petId with DELETED Pet id " + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
