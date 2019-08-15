package io.tpd.springbootcucumber.bagcommons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BagCommonsCucumberStepDefinitions {

    private final Logger log = LoggerFactory.getLogger(BagCommonsCucumberStepDefinitions.class);

    @Autowired
    private BagHttpClient bagHttpClient;

    @Given("^the bag is empty$")
    public void the_bag_is_empty() {
        bagHttpClient.clean();
        assertThat(bagHttpClient.getContents().isEmpty()).isTrue();
    }

    @When("^I put (\\d+) (\\w+) in the bag$")
    public void i_put_something_in_the_bag(final int quantity, final String something) {
        IntStream.range(0, quantity)
                .peek(n -> log.info("Putting a {} in the bag, number {}", something, quantity))
                .map(ignore -> bagHttpClient.put(something))
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
        final List<String> things = bagHttpClient.getContents().getThings();
        log.info("Expecting {} times {}. The bag contains {}", quantity, something, things);
        final int timesInList = Collections.frequency(things, something);
        assertThat(timesInList).isEqualTo(quantity);
        if (onlyThat) {
            assertThat(timesInList).isEqualTo(things.size());
        }
    }

}
