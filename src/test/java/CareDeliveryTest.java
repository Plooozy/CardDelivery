import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CareDeliveryTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Ростов-на-Дону");
        String date = LocalDate.now().plusDays(14).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        $("[data-test-id=date] input").setValue(date);
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+37376589312");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".notification__title").shouldBe(visible, Duration.ofSeconds(15));
    }
}
