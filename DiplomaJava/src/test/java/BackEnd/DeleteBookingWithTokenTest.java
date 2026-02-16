package BackEnd;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Feature("Booking API")
public class DeleteBookingWithTokenTest {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";
    private String authToken;

    private final int BOOKING_ID = 854;  // указать id бронирования

    @BeforeEach
    void setUp() {
        baseURI = BASE_URL;

        authToken = given()
                .contentType("application/json")
                .body("{\"username\": \"admin\", \"password\": \"password123\"}")
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("token");
    }

    @Test
    @DisplayName("Удаление бронирования по ID=" + BOOKING_ID)
    void testDeleteBooking_ByManualId() {
        deleteBooking(BOOKING_ID);
        verifyBookingDeleted(BOOKING_ID);
    }

    @Step("Удаление бронирования ID={bookingId}")
    private void deleteBooking(int bookingId) {
        given()
                .header("Cookie", "token=" + authToken)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .statusCode(oneOf(201, 204));
    }

    @Step("Проверка, что бронирование ID={bookingId} удалено ожидается Not Found)")
    private void verifyBookingDeleted(int bookingId) {
        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(404);
    }
}