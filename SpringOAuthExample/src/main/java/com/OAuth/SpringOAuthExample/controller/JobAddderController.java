package com.OAuth.SpringOAuthExample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OAuth.SpringOAuthExample.batch.BatchConfig;
import com.OAuth.SpringOAuthExample.model.OAuthCredentials;
import com.OAuth.SpringOAuthExample.service.OAuthService;

@RestController
public class JobAddderController {

@Autowired
OAuthService l_objOAuthServiceImpl;


@Autowired
BatchConfig l_objBatchConfig;
/*@Autowired
AuthTokenInfo l_objAuthTokenInfo;*/



/*@RequestMapping("/authdetails")
public List<OAuthCredentials> getOauthDetails() {
	List<OAuthCredentials> l_objAuthDetails=l_objOAuthServiceImpl.getOAuthDetails();
	for(OAuthCredentials l_objDetails:l_objAuthDetails) {
		System.out.println("AuthDetails=="+l_objDetails.getRefresh_token());
		System.out.println("authorisation_code=="+l_objDetails.getAuthorisation_code());
	}
		return l_objAuthDetails;
		
	}*/

@RequestMapping("/jobs")
public Map getJobDetails() {
	//AuthTokenInfo l_objAuthTokenInfo=l_objRestClient.sendTokenRequest();
	//Map l_objJobDetails=l_objRestClient.getAllJobs(l_objAuthTokenInfo);
	return null;
		
	}

@RequestMapping("/placements")
public BatchStatus getPlacementDetails() {
	BatchStatus l_objBatchStatus = null;
	l_objBatchStatus=l_objBatchConfig.perform();
	return l_objBatchStatus;
	}
}
