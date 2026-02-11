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
    public LastName lastNamefield = new LastName($("#lastName"));
    public Email emailfield = new Email($("#userEmail"));
    public Mobile mobilefield = new Mobile($("#userNumber"));
    public Subjects subjectfield = new Subjects($("#subjectsInput"));

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

    @Step("Ввести данные в поле LastName")
    public InputFieldTest setLastName(String text) {
        lastNamefield.click();  // Клик по нужному полю
        lastNamefield.setValue(text);  // Ввод текста в то же поле
        return this;
    }

    @Step("Ввести данные в поле Email")
    public InputFieldTest setEmail(String text) {
        emailfield.click();  // Клик по нужному полю
        emailfield.setValue(text);  // Ввод текста в то же поле
        return this;
    }

    @Step("Ввести данные в поле Mobile")
    public InputFieldTest setMobile(String value) {
        mobilefield.click();  // Клик по нужному полю
        mobilefield.setValue(value);  // Ввод текста в то же поле
        return this;
    }

    @Step("Ввести данные в поле Subjects")
    public InputFieldTest setSubjects(String text) {
        subjectfield.click();  // Клик по нужному полю
        subjectfield.setValue(text);  // Ввод текста в то же поле
        return this;
    }

}
