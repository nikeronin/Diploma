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
        firstNamefield.setValue(text);
    }
}
