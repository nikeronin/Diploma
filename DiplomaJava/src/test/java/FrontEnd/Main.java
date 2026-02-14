package FrontEnd;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

    InputFieldTest InputFieldTest = new InputFieldTest();
    private DemoQAPage demoQAPage = new DemoQAPage();

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

    @Test
    void autotest() {
        demoQAPage.openPage("https://demoqa.com/");
        demoQAPage.goToForms();
        demoQAPage.goToPracticeForm();
//      InputFieldTest.openPage()
        InputFieldTest.setFirstName("Никита");
        InputFieldTest.setLastName("Еронин");
        InputFieldTest.setEmail("eronin.crm@yandex.ru");
        InputFieldTest.setGender();
        InputFieldTest.setMobile("89504543762");
        InputFieldTest.setBirthdate();
        InputFieldTest.setSubjects("Math, Biology, English, Geography");
        InputFieldTest.setHobbies();
        InputFieldTest.uploadbutton("easter-celebration-with-dreamy-bunny.jpg");
        InputFieldTest.setCurrentAddress("123 Main St Apt 4, New York, NY 10001, USA");
        InputFieldTest.SelectState();
        InputFieldTest.SelectCity();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
