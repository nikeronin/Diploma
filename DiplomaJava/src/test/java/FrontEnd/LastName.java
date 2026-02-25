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
        lastNamefield.clear();
        lastNamefield.setValue(text);

        String actualValue = lastNamefield.getValue();

        if (!actualValue.equals(text)) {
            throw new RuntimeException(String.format(
                    "Значение не было установлено корректно. Ожидалось: '%s', фактически: '%s'",
                    text, actualValue
            ));
        }

        System.out.println("Значение '" + text + "' успешно установлено в поле Last Name");
    }
}
