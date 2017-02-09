package almond.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import almond.core.test.AbstractIntegrationTest;

public class HomeControllerTest extends AbstractIntegrationTest {
    @Test
	public void home_role_user() throws Exception {
    	template = template.withBasicAuth("javajigi@slipp.net", "test");
    	ResponseEntity<String> result = template.getForEntity("/", String.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
	}
    
    @Test
	public void home_role_admin() throws Exception {
    	template = template.withBasicAuth("sanjigi@slipp.net", "test");
    	ResponseEntity<String> result = template.getForEntity("/", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody().contains("Home page"));
	}
}
