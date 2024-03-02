package hellocucumber;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;

public class Calculator {
    private static final WebDriver webDriver = new ChromeDriver();
    private static final Map<Character, Character> transformer = Map.of(
            '-', '−',
            '*', '×',
            '/', '÷'
    );
    @BeforeAll
    public static void createWebEnv() {
        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        webDriver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
        webDriver.manage().window().fullscreen();
        webDriver.findElement(By.cssSelector("[aria-label='Consent']")).click();
    }
    @AfterAll
    public static void removeWebEnv() {
        webDriver.close();
        webDriver.quit();
    }
    @Before
    public void clearCalculator() {
        System.out.println("CLEARING");
        webDriver.findElement(By.id("clear_display")).click();
    }
    @Given("I have entered {int} into the calculator")
    public void iHaveEnteredIntoTheCalculator(int arg0) {
       webDriver.findElement(By.xpath(String.format("//button[text()='%d'][1]", arg0))).click();
    }

    @When("I press add")
    public void iPressAdd() {
        webDriver.findElement(By.xpath("//button[text()='+'][1]")).click();
    }

    @Then("the result should be {int} on the screen")
    public void theResultShouldBeOnTheScreen(int arg0) {
        Assertions.assertEquals(Integer.toString(arg0),
                webDriver.findElement(By.id("cs_display")).getAttribute("value"));
    }

    @When("I press subtract")
    public void iPressSubtract() {
        webDriver.findElement(By.xpath("//button[text()='−'][1]")).click();
    }

    @When("I press multiply")
    public void iPressMultiply() {
        webDriver.findElement(By.xpath("//button[text()='×'][1]")).click();
    }

    @When("I press divide")
    public void iPressDivide() {
        webDriver.findElement(By.xpath("//button[text()='÷'][1]")).click();
    }

    @Given("I enter {int}")
    public void iEnter(int arg0) {
        String num = Integer.toString(arg0);
        for(char c : num.toCharArray()) {
            webDriver.findElement(By.xpath(String.format("//button[text()='%c'][1]",
                    Optional.ofNullable(transformer.get(c)).orElse(c)))).click();
        }
    }

    @When("I press equals")
    public void iPressEquals() {
        webDriver.findElement(By.xpath("//button[text()='='][1]")).click();
    }

}
