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
        mobilefield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        mobilefield.setValue(value);
        mobilefield.shouldHave(Condition.value(value));
        System.out.println("Значение '" + value + "' успешно установлено в поле Mobile");
    }

}
