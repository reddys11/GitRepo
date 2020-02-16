package com.OAuth.SpringOAuthExample.service;


import java.util.List;

import com.OAuth.SpringOAuthExample.model.OAuthCredentials;


public interface OAuthService {
    
	public List<OAuthCredentials> getOAuthDetails();
}
