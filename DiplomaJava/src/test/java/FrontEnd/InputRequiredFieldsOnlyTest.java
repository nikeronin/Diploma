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
@Feature("Заполнение Practice Form только обязательные поля на demoqa.com")
public class InputRequiredFieldsOnlyTest {

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
    @DisplayName("Автотест: заполнение Practice Form")
    @Description("Проверяет заполнение всех полей формы и отправку данных")
    @Severity(SeverityLevel.CRITICAL)
    void autotest() {
        stepOpenPage();
        stepGoToForms();
        stepGoToPracticeForm();
        stepFillPersonalInfo();
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
        inputFieldTest.setFirstName("Никита");
        inputFieldTest.setLastName("Еронин");
        inputFieldTest.setGender();
        inputFieldTest.setMobile("89504543762");
        inputFieldTest.setBirthdate();
    }

    @Step("Отправка формы")
    private void stepSubmitForm() {
        $("#submit").click();
        $(byText("Thanks for submitting the form")).shouldBe(Condition.visible);
    }


}
