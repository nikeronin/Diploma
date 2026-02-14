package FrontEnd;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQAPage {

    private SelenideElement formsCard = $(byText("Forms"));
    private SelenideElement practiceFormItem = $(byText("Practice Form"));


    public void openPage(String url) {
        open("https://demoqa.com/");
    }
    public void goToForms() {
        formsCard.scrollTo().click();
    }

    public void goToPracticeForm() {
        practiceFormItem.scrollTo().click();
    }
    public boolean isPracticeFormLoaded() {
        return $("h1").text().contains("Practice Form");
    }
}