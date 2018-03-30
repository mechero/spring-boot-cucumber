package io.tpd.springbootcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class BagCucumberStepDefinitions extends SpringBootBaseIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(BagCucumberStepDefinitions.class);

    @Given("^the bag is empty$")
    public void the_bag_is_empty() {
        clean();
        assertThat(getContents().isEmpty()).isTrue();
    }

    @When("^I put (\\d+) (\\w+) in the bag$")
    public void i_put_something_in_the_bag(final int quantity, final String something) {
        IntStream.range(0, quantity)
                .peek(n -> log.info("Putting a {} in the bag, number {}", something, quantity))
                .map(ignore -> put(something))
                .forEach(statusCode -> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
    }

    @Then("^the bag should contain only (\\d+) (\\w+)$")
    public void the_bag_should_contain_only_something(final int quantity, final String something) {
        assertNumberOfTimes(quantity, something, true);
    }

    @Then("^the bag should contain (\\d+) (\\w+)$")
    public void the_bag_should_contain_something(final int quantity, final String something) {
        assertNumberOfTimes(quantity, something, false);
    }

    private void assertNumberOfTimes(final int quantity, final String something, final boolean onlyThat) {
        final List<String> things = getContents().getThings();
        log.info("Expecting {} times {}. The bag contains {}", quantity, something, things);
        final int timesInList = Collections.frequency(things, something);
        assertThat(timesInList).isEqualTo(quantity);
        if (onlyThat) {
            assertThat(timesInList).isEqualTo(things.size());
        }
    }

}
