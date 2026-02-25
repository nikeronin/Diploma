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
        emailfield.clear();
        emailfield.setValue(text);

        String actualValue = emailfield.getValue();

        if (!actualValue.equals(text)) {
            throw new RuntimeException(String.format(
                    "Значение не было установлено корректно. Ожидалось: '%s', фактически: '%s'",
                    text, actualValue
            ));
        }

        System.out.println("Значение '" + text + "' успешно установлено в поле Email");
    }

}
