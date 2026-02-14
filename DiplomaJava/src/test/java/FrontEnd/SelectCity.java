package FrontEnd;

import com.codeborne.selenide.SelenideElement;

public class SelectCity {

    SelenideElement selectcityfield;
    SelenideElement selectcityvariant;


    public SelectCity (SelenideElement selectcityfield_, SelenideElement selectcityvariant_) {
        this.selectcityfield = selectcityfield_;
        this.selectcityvariant = selectcityvariant_;
    }

    public void selectfield() {
        selectcityfield.click();
    }

    public void selectvariant() {
        selectcityvariant.click();
    }

}
