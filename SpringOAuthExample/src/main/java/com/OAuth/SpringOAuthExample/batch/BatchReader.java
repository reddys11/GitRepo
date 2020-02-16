package com.OAuth.SpringOAuthExample.batch;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OAuth.SpringOAuthExample.client.JobAdderRestClient;
import com.OAuth.SpringOAuthExample.model.AuthTokenInfo;
import com.OAuth.SpringOAuthExample.model.OAuthCredentials;
import com.OAuth.SpringOAuthExample.service.OAuthService;

@Component
@StepScope
public class BatchReader implements ItemReader<Object>{

@Autowired
JobAdderRestClient l_objRestClient;

boolean batchJobState = false;

private static final Logger LOGGER=LoggerFactory.getLogger(BatchReader.class);

	@Override
	public Object read() {
		//l_objRestClient=new JobAdderRestClient();
		String l_sMethodName="read";
		Map l_objMap = null;
		try {
		if(!batchJobState){
		LOGGER.info("***Batch Reader***");
			l_objMap=l_objRestClient.getAllPlacements();
			batchJobState=true;
			return l_objMap;	
		}
		}catch(Exception ex){
			LOGGER.error("Exception occured in the method"+l_sMethodName+"::"+ex.getMessage());
			
		}
		return l_objMap;
	}

}
