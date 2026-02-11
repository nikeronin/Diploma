package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LastName {

    SelenideElement lastNamefield;

    public LastName(SelenideElement lastNameField) {
        this.lastNamefield = lastNameField;
    }

    public void click() {
        lastNamefield.shouldBe(Condition.exist);
        lastNamefield.click();
    }

    public void setValue(String text) {
        System.out.println("Устанавливаем значение: " + text);
        lastNamefield.setValue(text);
    }
}
