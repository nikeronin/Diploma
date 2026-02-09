package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class InputFieldTest {

    SelenideElement TextInput = $(By.name("text"));
    public FirstName firstNameField = new FirstName($("#firstName"));

    @Step("Открыть страницу demoqa")
    public InputFieldTest openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Ввести данные в поле FirstName")
    public InputFieldTest setFirstName(String text) {
        firstNameField.click();  // Клик по нужному полю
        firstNameField.setValue(text);  // Ввод текста в то же поле
        return this;
    }
}
