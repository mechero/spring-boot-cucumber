package io.tpd.springbootcucumber;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootBaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBaseIntegrationTest.class);

    private final String SERVER_URL = "http://localhost";

    protected RestTemplate restTemplate;

    @LocalServerPort
    protected int port;

    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }
}
