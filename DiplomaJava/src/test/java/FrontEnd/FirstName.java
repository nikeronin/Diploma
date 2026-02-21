package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class FirstName {

    SelenideElement firstNamefield;

    public FirstName(SelenideElement firstNameField) {
        this.firstNamefield = firstNameField;
    }

    public void click() {
        firstNamefield.shouldBe(Condition.exist);
        firstNamefield.click();

    }

    public void setValue(String text) {
        System.out.println("Устанавливаем значение: " + text);
        firstNamefield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        firstNamefield.setValue(text);
        firstNamefield.shouldHave(Condition.value(text));
        System.out.println("Значение '" + text + "' успешно установлено в поле First Name");
    }
}
