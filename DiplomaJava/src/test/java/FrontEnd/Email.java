package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Email {

    SelenideElement emailfield;

    public Email(SelenideElement emailField) {
        this.emailfield = emailField;
    }

    public void click() {
        emailfield.shouldBe(Condition.exist);
        emailfield.click();
    }

    public void setValue(String text) {
        System.out.println("Устанавливаем значение: " + text);
        emailfield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        emailfield.setValue(text);
        emailfield.shouldHave(Condition.value(text));
        System.out.println("Значение '" + text + "' успешно установлено в поле Email");
    }

}
