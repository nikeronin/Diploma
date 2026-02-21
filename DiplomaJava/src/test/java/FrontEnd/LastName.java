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
        lastNamefield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        lastNamefield.setValue(text);
        lastNamefield.shouldHave(Condition.value(text));
        System.out.println("Значение '" + text + "' успешно установлено в поле Last Name");
    }
}
