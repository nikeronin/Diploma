package BackEnd;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Бронирование")
@Feature("Создание бронирования")
public class CreateBookingTest {

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    @DisplayName("Успешное создание бронирования")
    @Description("Проверяет, что бронирование создаётся с корректными данными и возвращает ожидаемые поля")
    public void testCreateBooking_Success() {

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-03-02");
        dates.setCheckout("2026-03-11");

        Booking booking = new Booking();
        booking.setFirstname("Владимир");
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
                .body("booking.firstname", equalTo("Владимир"))
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
    @DisplayName("Ошибка при создании бронирования без имени")
    @Description("Проверяет, что API возвращает 400 при отсутствии поля firstname")
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
