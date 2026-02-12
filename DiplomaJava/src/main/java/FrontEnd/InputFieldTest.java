package FrontEnd;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InputFieldTest {

    SelenideElement TextInput = $(By.name("text"));
    public FirstName firstNameField = new FirstName($("#firstName"));
    public LastName lastNamefield = new LastName($("#lastName"));
    public Email emailfield = new Email($("#userEmail"));
    public Gender genderField = new Gender(
            $("label[for='gender-radio-1']"),
            $("label[for='gender-radio-2']"),
            $("label[for='gender-radio-3']")
    );
    public Mobile mobilefield = new Mobile($("#userNumber"));
    public DateOfBirth dateOfbirthfield = new DateOfBirth(
            $("#dateOfBirthInput"),
            $(".react-datepicker__year-select"),
            $(".react-datepicker__month-select")
    );
    public Subjects subjectfield = new Subjects($("#subjectsInput"));
    public Hobbies hobbiesField = new Hobbies(
            $("label[for='hobbies-checkbox-1']"),
            $("label[for='hobbies-checkbox-2']"),
            $("label[for='hobbies-checkbox-3']")
    );
    public CurrentAddress currentaddressfield = new CurrentAddress($("#currentAddress"));

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

    @Step("Выбрать Gender")
    public InputFieldTest setGender() {
        genderField.malebutton.click();  // Клик по полю Male
//        genderField.femalebutton.click(); // Клик по полю Female
//        genderField.otherbutton.click(); // Клик по полю Other
        return this;
    }

    @Step("Ввести данные в поле Mobile")
    public InputFieldTest setMobile(String value) {
        mobilefield.click();  // Клик по нужному полю
        mobilefield.setValue(value);  // Ввод текста в то же поле
        return this;
    }

    @Step("Ввести данные в поле Date of Birth")

    public void pickDate() {
        dateOfbirthfield.openDatePicker();
        dateOfbirthfield.selectYear("1995");
        dateOfbirthfield.selectMonth("December");
        dateOfbirthfield.selectDay("5");
    }

    @Step("Ввести данные в поле Subjects")
    public InputFieldTest setSubjects(String text) {
        subjectfield.click();  // Клик по нужному полю
        subjectfield.setValue(text);  // Ввод текста в то же поле
        return this;
    }

    @Step("Выбрать Hobbies")
    public InputFieldTest setHobbies() {
        hobbiesField.sportsbox.click(); // Отметить чекбокс Sports
        System.out.println("Отмечен чекбокс: Sports");
        hobbiesField.readingbox.click(); // Отметить чекбокс Reading
        System.out.println("Отмечен чекбокс: Reading");
        hobbiesField.musicbox.click(); // Отметить чекбокс Music
        System.out.println("Отмечен чекбокс: Music");
        return this;
    }

    @Step("Ввести данные в поле Current Address")
    public InputFieldTest setCurrentAddress(String text) {
        currentaddressfield.click();  // Клик по нужному полю
        currentaddressfield.setValue(text);  // Ввод текста в то же поле
        return this;
    }

}
