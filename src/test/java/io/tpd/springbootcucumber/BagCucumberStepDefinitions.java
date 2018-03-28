package io.tpd.springbootcucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BagCucumberStepDefinitions {

    @Given("^the bag is empty$")
    public void the_bag_is_empty() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I put (\\d+) (\\w+) in the bag$")
    public void i_put_something_in_the_bag(final int quantity, final String something) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the bag should contain only (\\d+) (\\w+)$")
    public void the_bag_should_contain_only_something(final int quantity, final String something) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the bag should contain (\\d+) (\\w+)$")
    public void the_bag_should_contain_something(final int quantity) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
