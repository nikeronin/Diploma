package FrontEnd;

import com.codeborne.selenide.SelenideElement;

public class SelectState {

    SelenideElement selectstatefield;
    SelenideElement selectstatevariant;

    public SelectState (SelenideElement selectstatefield_, SelenideElement selectstatevariant_) {
        this.selectstatefield = selectstatefield_;
        this.selectstatevariant = selectstatevariant_;
    }

    public void selectfield() {
        selectstatefield.click();
    }

    public void selectvariant() {
        selectstatevariant.click();
    }

}
