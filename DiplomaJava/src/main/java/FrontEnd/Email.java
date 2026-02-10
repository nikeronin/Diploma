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
        emailfield.setValue(text);
    }

}
