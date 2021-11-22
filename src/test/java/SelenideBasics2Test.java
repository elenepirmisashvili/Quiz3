import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideBasics2Test {


    @Test
    public void booksTask() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        open("https://demoqa.com/books");
        driver.manage().window().maximize();
        $$(".rt-tr-group").
                filterBy(Condition.and("Name", Condition.text("O'Reilly Media"), Condition.text("Javascript")));
    }
    @Test
    public void errorOfSize() {

        Configuration.assertionMode = SOFT;
        Configuration.browser="Chrome";
        open("https://demoqa.com/books");
        System.out.println( $(".rt-tbody").findAll(".rt-tr-group").filterBy(text("O'Reilly Media")).filterBy(text("Javascript")).shouldHave(size(10)));
    }
}
