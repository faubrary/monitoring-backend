package probe.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FinderControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /*
        4)
        Написать интеграционный тест на тестирование REST API (достаточно одного
        положительного).
     */
    @Test
    public void oldMemberNames() {
        String[] over50 = restTemplate.getForObject("http://localhost:" + port + "/find/old", String[].class);
        assertThat(over50).containsExactlyInAnyOrder("A51", "B51");
    }
}