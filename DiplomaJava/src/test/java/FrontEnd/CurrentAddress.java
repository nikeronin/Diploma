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
        System.out.println("Устанавливаем адрес: " + text);
        currentaddressfield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        currentaddressfield.setValue(text);
        currentaddressfield.shouldHave(Condition.value(text));
        System.out.println("Значение '" + text + "' успешно установлено в поле Current Address");
    }

}
