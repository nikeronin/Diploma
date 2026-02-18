package FrontEnd;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;


@Epic("Демо-форма")
@Feature("Заполнение Practice Form на demoqa.com")
public class InputFieldTestAllFields {

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
        takeScreenshot(); // Allure автоматически прикрепит скриншот
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
        inputFieldTest.setFirstName("Никита");
        inputFieldTest.setLastName("Еронин");
        inputFieldTest.setEmail("eronin.crm@yandex.ru");
        inputFieldTest.setGender();
        inputFieldTest.setMobile("89504543762");
        inputFieldTest.setBirthdate();
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
        // Здесь можно добавить проверку успешной отправки
        // Например: assertThat(successMessage).isDisplayed();
    }
}



//public class Main {
//
//    InputFieldTest InputFieldTest = new InputFieldTest();
//    private DemoQAPage demoQAPage = new DemoQAPage();
//
//    @BeforeAll
//    static void setupAllureReports() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//        );
//    }
//
//    @Test
//    void autotest() {
//        demoQAPage.openPage("https://demoqa.com/");
//        demoQAPage.goToForms();
//        demoQAPage.goToPracticeForm();
////      InputFieldTest.openPage()
//        InputFieldTest.setFirstName("Никита");
//        InputFieldTest.setLastName("Еронин");
//        InputFieldTest.setEmail("eronin.crm@yandex.ru");
//        InputFieldTest.setGender();
//        InputFieldTest.setMobile("89504543762");
//        InputFieldTest.setBirthdate();
//        InputFieldTest.setSubjects("Math, Biology, English, Geography");
//        InputFieldTest.setHobbies();
//        InputFieldTest.uploadbutton("easter-celebration-with-dreamy-bunny.jpg");
//        InputFieldTest.setCurrentAddress("123 Main St Apt 4, New York, NY 10001, USA");
//        InputFieldTest.SelectState();
//        InputFieldTest.SelectCity();
//        try {
//            Thread.sleep(10_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
