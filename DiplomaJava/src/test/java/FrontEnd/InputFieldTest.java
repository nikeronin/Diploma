package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class InputFieldTest {

    private final FirstName firstNameField = new FirstName($("#firstName"));
    private final LastName lastNamefield = new LastName($("#lastName"));
    private final Email emailfield = new Email($("#userEmail"));
    private final Gender genderField = new Gender(
            $("label[for='gender-radio-1']"),
            $("label[for='gender-radio-2']"),
            $("label[for='gender-radio-3']")
    );
    private final Mobile mobilefield = new Mobile($("#userNumber"));
    private final DateOfBirth birthdate = new DateOfBirth();
    private final Subjects subjectfield = new Subjects($("#subjectsInput"));
    private final Hobbies hobbiesField = new Hobbies(
            $("label[for='hobbies-checkbox-1']"),
            $("label[for='hobbies-checkbox-2']"),
            $("label[for='hobbies-checkbox-3']")
    );
    private final Picture uploadButton = new Picture(
            $(By.cssSelector("input[type='file'][id^='uploadPicture']"))
    );
    private final CurrentAddress currentaddressfield = new CurrentAddress($("#currentAddress"));

    private final SelectState SelectState = new SelectState(
            $("#react-select-3-input"),
            $(byText("NCR"))
    );
    private final SelectCity SelectCity = new SelectCity(
            $("#react-select-4-input"),
            $(byText("Delhi"))
    );

    @Step("Ввести данные в поле FirstName")
    public InputFieldTest setFirstName(String text) {
        firstNameField.click();
        firstNameField.setValue(text);
        return this;
    }

    @Step("Ввести данные в поле LastName")
    public InputFieldTest setLastName(String text) {
        lastNamefield.click();
        lastNamefield.setValue(text);
        return this;
    }

    @Step("Ввести данные в поле Email")
    public InputFieldTest setEmail(String text) {
        emailfield.click();
        emailfield.setValue(text);
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
        mobilefield.click();
        mobilefield.setValue(value);
        return this;
    }

    @Step("Ввести данные в поле Date of Birth")
    public void setBirthdate() {
        int year = 2001;
        int month = 3;
        int day = 15;
        birthdate.input(year, month, day);
        System.out.println("Заполнена дата рождения " + birthdate);
    }

    @Step("Ввести данные в поле Subjects")
    public InputFieldTest setSubjects(String text) {
        subjectfield.click();
        subjectfield.setValue(text);
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

    @Step ("Загрузить Picture")
    public InputFieldTest uploadbutton(String s) {
        uploadButton.uploadPicture("easter-celebration-with-dreamy-bunny.jpg");
        return this;
    }

    @Step("Ввести данные в поле Current Address")
    public InputFieldTest setCurrentAddress(String text) {
        currentaddressfield.click();
        currentaddressfield.setValue(text);
        return this;
    }

    @Step("Выбрать значение в Select State")
    public InputFieldTest SelectState() {
        System.out.println("Выбираем значение 'NCR' в поле Select State");

        try {
            SelectState.selectstatefield.shouldBe(Condition.exist, Condition.visible, Condition.enabled)
                    .click();
            SelectState.selectstatevariant.shouldBe(Condition.exist, Condition.visible, Condition.enabled)
                    .click();
            SelenideElement selectedValueElement = $(".css-1dimb5e-singleValue");
            selectedValueElement.shouldBe(Condition.visible, Duration.ofSeconds(3));
            selectedValueElement.shouldHave(Condition.text("NCR"), Duration.ofSeconds(5));

            System.out.println("Значение 'NCR' успешно выбрано и отображено в поле Select State");
            return this;

        } catch (Exception e) {
            System.err.println("Ошибка при выборе значения 'NCR' в поле Select State: " + e.getMessage());
            throw new RuntimeException("Не удалось выбрать значение 'NCR' в поле Select State", e);
        }
    }

    @Step("Выбрать значение в Select City")
    public InputFieldTest SelectCity() {
        System.out.println("Выбираем значение 'Delhi' в поле Select City");

        try {
            SelectCity.selectcityfield.shouldBe(Condition.exist, Condition.visible, Condition.enabled)
                    .click();
            SelectCity.selectcityvariant.shouldBe(Condition.exist, Condition.visible, Condition.enabled)
                    .click();
            SelenideElement selectedValueElement = $("#city .css-1dimb5e-singleValue");
            selectedValueElement.shouldBe(Condition.visible, Duration.ofSeconds(3));
            selectedValueElement.shouldHave(Condition.text("Delhi"), Duration.ofSeconds(5));
            System.out.println("Значение 'Delhi' успешно выбрано и отображено в поле Select City");
            return this;

        } catch (Exception e) {
            System.err.println("Ошибка при выборе значения 'Delhi' в поле Select City: " + e.getMessage());
            throw new RuntimeException("Не удалось выбрать значение 'Delhi' в поле Select City", e);
        }
    }

}
