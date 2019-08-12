package io.tpd.springbootcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class MoreCucumberStepDefinitions extends SpringBootBaseIntegrationTest {

    @Given("^the bag is not empty$")
    public void the_bag_is_not_empty() {
        put("something");
        assertThat(getContents().isEmpty()).isFalse();
    }

    @When("^I empty the bag$")
    public void empty_the_bag() {
        clean();
    }
}
