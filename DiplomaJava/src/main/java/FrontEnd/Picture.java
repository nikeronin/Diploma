package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class Picture {

    SelenideElement uploadbutton;

    public Picture(SelenideElement uploadbutton_) {
        this.uploadbutton = uploadbutton_;
    }

    public void click() {
        uploadbutton.shouldBe(Condition.exist);
        uploadbutton.click();
    }

    public void uploadPicture(String filePath) {
        uploadbutton.uploadFromClasspath(filePath);
    }

}