package FrontEnd;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Main {

    InputFieldTest InputFieldTest = new InputFieldTest();

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }
    @Test
    void autotest () {

        InputFieldTest.openPage()
                .setFirstName("Никита");
        InputFieldTest.setLastName("Еронин");
        InputFieldTest.setEmail("eronin.crm@yandex.ru");
        InputFieldTest.setGender();
        InputFieldTest.setMobile("89504543762");
        InputFieldTest.setBirthdate();
        InputFieldTest.setSubjects("Math, Biology, English, Geography");
        InputFieldTest.setHobbies();
        InputFieldTest.setCurrentAddress("123 Main St Apt 4, New York, NY 10001, USA");

    }

}
