package FrontEnd;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateOfBirth {

    SelenideElement input = $(By.id("dateOfBirthInput"));

    SelenideElement selectMonth = $(By.className("react-datepicker__month-select"));
    SelenideElement selectYear = $(By.className("react-datepicker__year-select"));
    String inputDayTmp = "//div[contains(@class, 'react-datepicker__day') and @role='option' and text()='%s']";

    public void input(int year, int month, int day) {
        input.click();
        selectMonth.selectOption(month - 1);
        selectYear.selectOption(String.valueOf(year));
        String inputDayXpath = String.format(inputDayTmp, day);
        SelenideElement inputDay = $(By.xpath(inputDayXpath));
        inputDay.click();
    }

    public void checkBirthdate(String value) {
        String actualValue = input.getValue();
        assertEquals(actualValue, value);
    }

}
