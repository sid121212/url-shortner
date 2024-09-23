package com.sid121212.url_shortner.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid121212.url_shortner.ShortUrl;
import com.sid121212.url_shortner.controller.repo.JpaRepo;

@Service
public class UrlServiceImpl implements UrlService{
	
	@Autowired
	private JpaRepo urlRepo;

	@Override
	public String getShortUrl(String shortUrl) {
		String hashedId = getHashedIdFromShortUrl(shortUrl);
		// TODO Auto-generated method stub
		
		return urlRepo.getByHashedId(hashedId);
	}

	private String getHashedIdFromShortUrl(String shortUrl) {
		// TODO Auto-generated method stub
		int lastSlashIndex = shortUrl.lastIndexOf("/");
        if (lastSlashIndex != -1 && lastSlashIndex + 1 < shortUrl.length()) {
            return shortUrl.substring(lastSlashIndex + 1);
        }
		return null;
	}

	@Override
	public String saveUrl(String longUrl) {
		ShortUrl shortUrl = new ShortUrl(longUrl);
	    ShortUrl savedUrl = urlRepo.save(shortUrl);
	    
	    // Generate a hashed ID based on the saved entity's generated ID
	    String hashedId = hashId(savedUrl.getId());
	    
	    // Update the entity with the hashed ID and save it again
	    savedUrl.setHashedId(hashedId);
	    urlRepo.save(savedUrl);
		return "https://urlshortner/"+hashedId;
		
	}
	private String hashId(Long id) {
	    // Example: convert the ID to hexadecimal, or use Base62
	    return Long.toHexString(id);  // Convert ID to hex as an example
	}

}
