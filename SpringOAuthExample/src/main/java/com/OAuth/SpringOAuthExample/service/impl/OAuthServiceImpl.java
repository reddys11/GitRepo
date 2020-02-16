package com.OAuth.SpringOAuthExample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OAuth.SpringOAuthExample.model.OAuthCredentials;
import com.OAuth.SpringOAuthExample.repository.OAuthRepository;
import com.OAuth.SpringOAuthExample.service.OAuthService;

@Service
public class OAuthServiceImpl implements OAuthService{

@Autowired
public OAuthRepository l_objRepo;
	@Override
	public List<OAuthCredentials> getOAuthDetails() {
		// TODO Auto-generated method stub
		return l_objRepo.findAuthorisation_Details();
	}

}
