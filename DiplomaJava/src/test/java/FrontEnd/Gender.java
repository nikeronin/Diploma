package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Gender {

    SelenideElement malebutton;
    SelenideElement femalebutton;
    SelenideElement otherbutton;


    public Gender(SelenideElement maleButton, SelenideElement femaleButton, SelenideElement otherButton) {
        this.malebutton = maleButton;
        this.femalebutton = femaleButton;
        this.otherbutton = otherButton;
    }

    public void selectMale() {
        malebutton.shouldBe(Condition.visible).click();
        assertTrue(malebutton.isSelected());
        assertFalse(malebutton.isSelected());
    }

    public void selectFemale() {
        femalebutton.shouldBe(Condition.visible).click();
        assertTrue(femalebutton.isSelected());
        assertFalse(femalebutton.isSelected());
    }

    public void selectOther() {
        otherbutton.shouldBe(Condition.visible).click();
        assertTrue(otherbutton.isSelected());
        assertFalse(otherbutton.isSelected());
    }

}
