package com.example.springvertxproject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringVertxProjectApplicationTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void givenUrl_whenReceivedArticles_thenSuccess() throws InterruptedException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/articles", String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        System.out.println("body = " + responseEntity.getBody());
    }

}
