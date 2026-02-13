package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class Picture {

    SelenideElement uploadbutton;

    public Picture(SelenideElement uploadbutton_) {
        this.uploadbutton = uploadbutton_;
    }

    public void uploadPicture(String filePath) {
        System.out.println("Загружаем картинку: easter-celebration-with-dreamy-bunny.jpg");
        uploadbutton.uploadFromClasspath(filePath);
    }

}