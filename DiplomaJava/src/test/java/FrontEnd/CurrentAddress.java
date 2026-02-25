package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CurrentAddress {

    SelenideElement currentaddressfield;

    public CurrentAddress (SelenideElement currentaddressField) {
        this.currentaddressfield = currentaddressField;
    }

    public void click() {
        currentaddressfield.shouldBe(Condition.exist);
        currentaddressfield.click();
    }

    public void setValue(String text) {
        System.out.println("Устанавливаем значение: " + text);

        currentaddressfield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        currentaddressfield.clear();
        currentaddressfield.setValue(text);

        String actualValue = currentaddressfield.getValue();

        if (!actualValue.equals(text)) {
            throw new RuntimeException(String.format(
                    "Значение не было установлено корректно. Ожидалось: '%s', фактически: '%s'",
                    text, actualValue
            ));
        }

        System.out.println("Значение '" + text + "' успешно установлено в поле Current Address");
    }

}
