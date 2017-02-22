package almond.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import almond.support.test.AbstractIntegrationTest;
import almond.support.test.HtmlFormDataBuilder;

public class UserControllerTest extends AbstractIntegrationTest {
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	
    @Test
    public void loginForm() {
        ResponseEntity<String> result = template.getForEntity("/login", String.class);
        log.debug("body : {}", result.getBody());
    }

    @Test
	public void registration() throws Exception {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
            .addParameter("email", "javajigi@rockplace.co.kr")
            .addParameter("password", "password")
            .build();
    	ResponseEntity<String> response = template.postForEntity( "/registration", request , String.class );
    	assertEquals(HttpStatus.FOUND, response.getStatusCode());
    }
}
