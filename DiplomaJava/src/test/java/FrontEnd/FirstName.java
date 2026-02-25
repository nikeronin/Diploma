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
        firstNamefield.clear();
        firstNamefield.setValue(text);

        String actualValue = firstNamefield.getValue();

        if (!actualValue.equals(text)) {
            throw new RuntimeException(String.format(
                    "Значение не было установлено корректно. Ожидалось: '%s', фактически: '%s'",
                    text, actualValue
            ));
        }

        System.out.println("Значение '" + text + "' успешно установлено в поле First Name");
    }

}
