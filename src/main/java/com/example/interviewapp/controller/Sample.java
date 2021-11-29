package com.example.interviewapp.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Sample {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/")
	public Object getSomething() {
		
		Object obj = restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Object.class);
		return obj;
		
	}
	
	@PostMapping("/")
	public Object putSomething() {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		JSONObject obj = new JSONObject();
		obj.put("val1", "val1");
		
		HttpEntity<Object> entity = new HttpEntity<Object>(obj, header);
		
		Object out = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", entity, Object.class);
		return out;
	}
	
	

}
