package FrontEnd;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DateOfBirth {

    SelenideElement dateInput;
    SelenideElement yearSelect;
    SelenideElement monthSelect;

    public DateOfBirth (SelenideElement dateInput_, SelenideElement yearSelect_, SelenideElement monthSelect_) {
        this.dateInput = dateInput_;
        this.yearSelect = yearSelect_;
        this.monthSelect = monthSelect_;
    }

    public void openDatePicker() {
        dateInput.shouldBe(Condition.visible).click();
    }

    /**
     * Выбирает год в выпадающем списке
     * @param year например, "1990"
     */
    public void selectYear(String year) {
        yearSelect.selectOption(year);
    }

    /**
     * Выбирает месяц в выпадающем списке
     * @param month например, "March"
     */
    public void selectMonth(String month) {
        monthSelect.selectOption(month);
    }

    /**
     * Выбирает день в календаре по тексту через XPath (без byText)
     * @param day например, "15"
     */
//    public void selectDay(String day) {
//        SelenideElement dayElement = $(".react-datepicker__day--005")
//                .find(By.xpath(String.format(".//*[text()='%s']", day)));
//
//        dayElement.shouldBe(Condition.visible, Condition.enabled)
//                .click();
//    }


    public void selectDay(String day) {
        // 1. Убедимся, что календарь открыт
        $(".react-datepicker__calendar-container")
                .shouldBe(Condition.visible, Duration.ofSeconds(5));

        // 2. Ищем элемент по тексту внутри календаря (надёжно и универсально)
        SelenideElement dayElement = $(".react-datepicker__calendar-container")
                .find(By.xpath(String.format(".//*[text()='%s']", day)));

        // 3. Проверяем видимость и кликаем
        dayElement.shouldBe(Condition.visible, Condition.enabled)
                .click();
    }

    /**
     * Получает текущее значение поля даты
     * @return строка в формате "15 Mar 1990"
     */
    public String getDateValue() {
        return dateInput.getValue().trim();
    }


}
