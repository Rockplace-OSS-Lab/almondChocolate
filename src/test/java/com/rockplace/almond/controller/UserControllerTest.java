package com.rockplace.almond.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.rockplace.almond.core.test.AbstractIntegrationTest;

public class UserControllerTest extends AbstractIntegrationTest {
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	
    @Test
    public void loginForm() {
        ResponseEntity<String> result = template.getForEntity("/login", String.class);
        log.debug("body : {}", result.getBody());
    }

}
