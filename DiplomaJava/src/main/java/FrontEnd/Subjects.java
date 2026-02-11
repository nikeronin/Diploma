package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class Subjects {

    SelenideElement subjectfield;

    public Subjects(SelenideElement subjectField) {
        this.subjectfield = subjectField;
    }

    public void click() {
        subjectfield.shouldBe(Condition.exist);
        subjectfield.click();
    }

    public void setValue(String text) {
        System.out.println("Устанавливаем значение: " + text);
        subjectfield.setValue(text);
    }

}
