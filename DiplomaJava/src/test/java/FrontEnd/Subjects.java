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
        System.out.println("Заполняем предметы: " + text);

        subjectfield.shouldBe(Condition.exist, Condition.visible, Condition.enabled);
        subjectfield.setValue(text);

        boolean valueSet = subjectfield
                .exists();
        if (valueSet) {
            System.out.println("Значение '" + text + "' успешно установлено в поле Subjects");
        } else {
            String actualValue = subjectfield.getValue();
            System.err.println
                    ("ОШИБКА: значение не было установлено. " +
                            "Ожидалось: '" + text + "', фактически: '" + actualValue + "'");
        }
    }

}
