package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


@Epic("Демо-форма")
@Feature("Заполнение Practice Form без обязательных полей на demoqa.com")
public class InputFieldsValidationTest {

    InputFieldTest inputFieldTest = new InputFieldTest();
    private DemoQAPage demoQAPage = new DemoQAPage();

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @Attachment(type = "image/png", value = "Скриншот после шага")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @AfterEach
    void attachScreenshot() {
        takeScreenshot();
    }

    @Test
    @DisplayName("Проверка валидации обязательных полей Practice Form")
    @Description("Проверяет валидацию заполнения обязательных полей")
    @Severity(SeverityLevel.CRITICAL)
    void autotest() {
        stepOpenPage();
        stepGoToForms();
        stepGoToPracticeForm();
        stepFillPersonalInfo();
        stepUploadFile();
        stepSubmitForm();
    }

    @Step("Открыть главную страницу demoqa.com")
    private void stepOpenPage() {
        demoQAPage.openPage("https://demoqa.com/");
    }

    @Step("Перейти в раздел Forms")
    private void stepGoToForms() {
        demoQAPage.goToForms();
    }

    @Step("Перейти в Practice Form")
    private void stepGoToPracticeForm() {
        demoQAPage.goToPracticeForm();
    }

    @Step("Заполнение персональных данных")
    private void stepFillPersonalInfo() {
        inputFieldTest.setEmail("eronin.crm@yandex.ru");
        inputFieldTest.setSubjects("Math, Biology, English, Geography");
        inputFieldTest.setHobbies();
        inputFieldTest.setCurrentAddress("123 Main St Apt 4, New York, NY 10001, USA");
        inputFieldTest.SelectState();
        inputFieldTest.SelectCity();
    }

    @Step("Загрузка файла")
    private void stepUploadFile() {
        inputFieldTest.uploadbutton("easter-celebration-with-dreamy-bunny.jpg");
    }

    @Step("Отправка формы")
    private void stepSubmitForm() {
        $("#submit").click();
        $(byText("Thanks for submitting the form")).shouldNotBe(Condition.visible);
    }

}
