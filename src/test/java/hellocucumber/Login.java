package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Login {
    private static class User {
        String email = "";
        String password = "";

        void generateRandom() {
            Random r = new Random();
            for (int i = 0; i < 10; ++i) {
                this.email += 'A' + (r.nextInt() % 26);
                this.password += 'A' + (r.nextInt() % 26);
            }
            this.email += "@on.god";
            System.out.println(this.email);
            System.out.println(this.password);
        }

        @Override
        public String toString() {
            return String.format("Username: %s\nPassword: %s", this.email, this.password);
        }
    }

    private static WebDriver webDriver;
    private static final String demoPage = "https://practicetestautomation.com";
    private User currentUser = null;

    static void initWebDriver() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.of(10, ChronoUnit.SECONDS));
    }

    static void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
    }


    @Given("the demo page")
    public void theDemoPage() {
        initWebDriver();
        webDriver.get(String.format("%s/practice-test-login/", demoPage));
    }

    @And("no user logged in")
    public void noUserLoggedIn() {
        currentUser = new User();
        Assertions.assertNull(currentUser);
    }

    @Then("generate a random user")
    public void generateARandomUser() {
        currentUser = new User();
        currentUser.generateRandom();
        System.out.println(currentUser);
    }

    @And("log in")
    public void logIn() {
        System.out.println("DO SELENIUM");
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        System.out.println("DO SELENIUM");
        closeWebDriver();
    }

}
