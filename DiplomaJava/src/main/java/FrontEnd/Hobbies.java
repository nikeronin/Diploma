package FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Hobbies {

    SelenideElement sportsbox;
    SelenideElement readingbox;
    SelenideElement musicbox;


    public Hobbies (SelenideElement sportsBox, SelenideElement readingBox, SelenideElement musicBox) {
        this.sportsbox = sportsBox;
        this.readingbox = readingBox;
        this.musicbox = musicBox;
    }

    public void selectSports() {
        sportsbox.shouldBe(Condition.visible).click();
        assertTrue(sportsbox.isSelected());
        assertFalse(sportsbox.isSelected());
    }

    public void selectReading() {
        readingbox.shouldBe(Condition.visible).click();
        assertTrue(readingbox.isSelected());
        assertFalse(readingbox.isSelected());
    }

    public void selectMusic() {
        musicbox.shouldBe(Condition.visible).click();
        assertTrue(musicbox.isSelected());
        assertFalse(musicbox.isSelected());
    }

}
