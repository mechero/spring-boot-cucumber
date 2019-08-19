package io.tpd.springbootcucumber.bagcommons;

import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BagCommonCucumberStepDefinitions {

    @Autowired
    private BagHttpClient bagHttpClient;

    @Given("^the bag is empty$")
    public void the_bag_is_empty() {
        bagHttpClient.clean();
        assertThat(bagHttpClient.getContents().isEmpty()).isTrue();
    }

}
