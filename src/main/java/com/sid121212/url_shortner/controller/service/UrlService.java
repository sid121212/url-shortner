package com.sid121212.url_shortner.controller.service;

public interface UrlService {
	
	public String saveUrl(String longUrl);
	public String getShortUrl(String hashedId);
}
