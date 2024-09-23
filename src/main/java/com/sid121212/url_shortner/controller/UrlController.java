package com.sid121212.url_shortner.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid121212.url_shortner.controller.service.UrlService;

@RestController
public class UrlController {
	
	@Autowired
	private UrlService urlService;
	@PostMapping("/url")
	public String addUrl(@RequestBody Map<String, String> requestBody) {
	    String longUrl = requestBody.get("longUrl"); // Extract the long URL from the request body
	    return urlService.saveUrl(longUrl);          // Pass the long URL to the service
	}
	
	@GetMapping("/url")
	public String getUrl(@RequestParam String shortUrl) {
		return urlService.getShortUrl(shortUrl);
	}
	
}
