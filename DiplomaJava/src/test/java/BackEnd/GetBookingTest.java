package BackEnd;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Бронирование")
@Feature("Получение бронирования")
public class GetBookingTest {

    private static final String BASE_URL = "https://restful-booker.herokuapp.com";

    @BeforeEach
    void setUp() {
        baseURI = BASE_URL;
    }

    @Test
    @DisplayName("Успешное получение бронирования по ID")
    @Description("Проверяет, что API возвращает корректные данные бронирования по существующему ID")
    @Severity(SeverityLevel.CRITICAL)
    void testGetBooking_Success() {
        int bookingId = 1425;

        given()
                .log().all()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().ifValidationFails()  // Логируем ответ при ошибке
                .statusCode(200)
                .body("firstname", equalTo("Сергей"))
                .body("lastname", equalTo("Сергеев"))
                .body("totalprice", equalTo(1345))
                .body("depositpaid", equalTo(true))
                .body("bookingdates.checkin", equalTo("2026-03-02"))
                .body("bookingdates.checkout", equalTo("2026-03-11"))
                .body("additionalneeds", equalTo("Дополнительные запросы"));
    }

    @Test
    @DisplayName("Ошибка 404 при запросе несуществующего бронирования")
    @Description("Проверяет, что API возвращает 404 Not Found для несуществующего ID")
    @Severity(SeverityLevel.NORMAL)
    void testGetBooking_NotFound() {
        int invalidId = 999999;


        given()
                .log().all()
                .when()
                .get("/booking/" + invalidId)
                .then()
                .log().ifValidationFails()
                .statusCode(404);
    }

    @Test
    @DisplayName("Проверка обязательных полей в ответе")
    @Description("Убеждается, что ответ содержит все ожидаемые поля")
    @Severity(SeverityLevel.NORMAL)
    void testGetBooking_RequiredFields() {
        int bookingId = 5412;

        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .statusCode(200)
                .body("$", hasKey("firstname"))
                .body("$", hasKey("lastname"))
                .body("$", hasKey("totalprice"))
                .body("$", hasKey("depositpaid"))
                .body("$", hasKey("bookingdates"))
                .body("bookingdates", hasKey("checkin"))
                .body("bookingdates", hasKey("checkout"));
    }
}