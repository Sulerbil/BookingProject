package booking;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Booking {

    Response response;

    @Test
    public void postBookingId() {

        String newBooking = "{\n" +
                "\"firstname\" : \"Jim\",\n" +
                "\"lastname\" : \"Brown\",\n" +
                "\"totalprice\" : 111,\n" +
                "\"depositpaid\" : true,\n" +
                "\"bookingdates\" : {\n" +
                "\"checkin\" : \"2018-01-01\",\n" +
                "\"checkout\" : \"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        response = given()
                .auth().basic("admin","password123")
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType("application/json")
                .body(newBooking)
                .when()
                .post()

                .then().statusCode(200).extract().response();
        response.prettyPrint();

    }

    @Test
    public void deleteBookingId() {

        response = given()
                .auth().basic("admin","password123")
                .contentType("application/json")
                .when()
                .delete("https://restful-booker.herokuapp.com/booking/39")
                .then()
                .statusCode(200)
                .extract()
                .response();

    }



}

