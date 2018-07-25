package com.docker.test.helloworld.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/bank")
public class TestController {

	@GetMapping
	public ResponseEntity<String> viewbank() {
		
			

			return new ResponseEntity<String>("Hello Docker", HttpStatus.OK);
}
}