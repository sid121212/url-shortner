package com.sid121212.url_shortner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShortUrl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String hashedId;
	private String longUrl;
	
	
	public ShortUrl(Long id, String hashedId, String longUrl) {
		super();
		this.id = id;
		this.hashedId = hashedId;
		this.longUrl = longUrl;
	}
	
	public ShortUrl() {
        // Default constructor required by JPA
    }
    
    public ShortUrl(String longUrl) {
        this.longUrl = longUrl;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHashedId() {
		return hashedId;
	}
	public void setHashedId(String hashedId) {
		this.hashedId = hashedId;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	
	
	
}
