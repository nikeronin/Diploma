package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class FirstName {

    SelenideElement firstNamefield;

    public FirstName(SelenideElement firstNamefield) {
        this.firstNamefield = firstNamefield;
    }

    public FirstName click() {
        firstNamefield.shouldBe(Condition.exist);
        firstNamefield.click();
        return this;
    }

    public void setValue(String text) {
    }
}
