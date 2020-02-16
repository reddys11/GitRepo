package com.OAuth.SpringOAuthExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.OAuth.SpringOAuthExample.model.OAuthCredentials;

@Repository
public interface OAuthRepository extends JpaRepository<OAuthCredentials, Integer>{

	@Query(value ="Select access_token,refresh_token from authorisation_details", nativeQuery = true)
	public List<OAuthCredentials> findAuthorisation_Details();
}
