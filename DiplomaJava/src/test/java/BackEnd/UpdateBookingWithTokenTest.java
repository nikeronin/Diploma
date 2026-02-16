package BackEnd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Feature("Бронирование номеров")
@Story("Обновление бронирования")
public class UpdateBookingWithTokenTest {

    private String authToken;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response authResponse = given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"admin\", \"password\": \"password123\"}")
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().response();

        authToken = authResponse.jsonPath().getString("token");
    }

    @Test
    @DisplayName("Обновление бронирования с валидным токеном")
    @Description("Проверяет успешное обновление бронирования при наличии токена и корректных данных.")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Отправить PUT-запрос на обновление бронирования")
    public void testUpdateBooking_WithToken() {
        int bookingId = 3332;

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-04-01");
        dates.setCheckout("2026-04-10");

        Booking updatedBooking = new Booking();
        updatedBooking.setFirstname("Diana");
        updatedBooking.setLastname("Johnson");
        updatedBooking.setTotalprice(200);
        updatedBooking.setDepositpaid(false);
        updatedBooking.setBookingdates(dates);
        updatedBooking.setAdditionalneeds("Dinner");

        given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + authToken)
                .body(updatedBooking)
                .log().body()
                .when()
                .put("/booking/" + bookingId)
                .then()
                .log().body()
                .statusCode(200)
                .body("firstname", equalTo("Diana"))
                .body("lastname", equalTo("Johnson"));
    }
}
