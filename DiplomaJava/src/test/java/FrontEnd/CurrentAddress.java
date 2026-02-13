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
        currentaddressfield.setValue(text);
    }

}
