package com.sid121212.url_shortner.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sid121212.url_shortner.ShortUrl;

public interface JpaRepo extends JpaRepository<ShortUrl, Long>{
	
	@Query("SELECT s.longUrl FROM ShortUrl s WHERE s.hashedId = :hashedId")
	String getByHashedId(String hashedId);

}
