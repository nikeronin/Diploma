package BackEnd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateBookingTest {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    public void testCreateBooking_Success() {

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-03-02");
        dates.setCheckout("2026-03-11");

        Booking booking = new Booking();
        booking.setFirstname("Василий");
        booking.setLastname("Иванов");
        booking.setTotalprice(1345);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Дополнительные запросы");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(200)
                .body("booking.firstname", equalTo("Василий"))
                .body("booking.lastname", equalTo("Иванов"))
                .body("booking.totalprice", equalTo(1345))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", equalTo("2026-03-02"))
                .body("booking.bookingdates.checkout", equalTo("2026-03-11"))
                .body("booking.additionalneeds", equalTo("Дополнительные запросы"))
                .extract().response();

        int bookingId = response.jsonPath().getInt("bookingid");
        assert bookingId > 0 : "Booking ID должен быть положительным числом";
    }

    @Test
    public void testCreateBooking_MissingFirstName_Failure() {

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-03-01");
        dates.setCheckout("2026-03-10");

        Booking booking = new Booking();
        booking.setLastname("Doe");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);

        given()
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking")
                .then()
                .log().ifValidationFails()
                .statusCode(400);
    }
}
