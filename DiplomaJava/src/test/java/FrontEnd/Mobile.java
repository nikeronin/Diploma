package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Mobile {

    SelenideElement mobilefield;

    public Mobile (SelenideElement mobileField) {
        this.mobilefield = mobileField;
    }

    public void click() {
        mobilefield.shouldBe(Condition.exist);
        mobilefield.click();
    }

    public void setValue(String value) {
        System.out.println("Устанавливаем значение: " + value);
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Значение не может быть пустым");
        }
        mobilefield.setValue(value);
    }

}
