package com.OAuth.SpringOAuthExample.client;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.OAuth.SpringOAuthExample.model.AuthTokenInfo;
import com.OAuth.SpringOAuthExample.model.OAuthCredentials;
import com.OAuth.SpringOAuthExample.service.OAuthService;


@Component
public class JobAdderRestClient {
	
	@Value("${api.base-uri}")
	String REST_SERVICE_URI;
   
	@Value("${spring.security.oauth2.client.provider.jobadder.token-uri}")
	String AUTH_SERVER_URI;
    
	@Value("${spring.security.oauth2.client.registration.jobadder.client-secret}")
	String client_secret;
	
	@Value("${spring.security.oauth2.client.registration.jobadder.client-id}")
	String client_id;
	
    public static final String QPM_ACCESS_TOKEN = "?access_token=";
	
    private static final Logger LOGGER=LoggerFactory.getLogger(JobAdderRestClient.class);
    
    @Autowired
    OAuthService l_objOAuthServiceImpl;
    
    private static HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }
    
    private HttpHeaders getHeadersWithClientCredentials(){
       // String plainClientCredentials=client_id+":"+client_secret;
        //System.out.println("plainClientCredentials========="+plainClientCredentials);
       // String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
         
        HttpHeaders headers = getHeaders();
       // headers.add("Authorization", "Basic " + base64ClientCredentials);
       
        return headers;
    } 
    
    public AuthTokenInfo sendTokenRequest(List<OAuthCredentials> p_objAuthDetails){
        RestTemplate restTemplate = new RestTemplate(); 
         System.out.println("************sendTokenRequest**************");
         MultiValueMap<String, String> l_mapHM = new LinkedMultiValueMap<String, String>();
         String l_sRefreshToken="";
         for(OAuthCredentials l_objAuthDetails:p_objAuthDetails) {
        	 l_sRefreshToken=l_objAuthDetails.getRefresh_token();
        	 System.out.println("*************refresh_token========"+l_sRefreshToken);
         }
         l_mapHM.add("client_id", client_id);
         l_mapHM.add("refresh_token", "c06e8195ce05be026e6ed8883a54a2cb");
         l_mapHM.add("client_secret", client_secret);
         l_mapHM.add("grant_type", "refresh_token");
        HttpEntity request = new HttpEntity(l_mapHM,getHeadersWithClientCredentials());
        ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI, HttpMethod.POST, request, Object.class);
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>)response.getBody();
        AuthTokenInfo tokenInfo = null;
         
        if(map!=null){
            tokenInfo = new AuthTokenInfo();
            tokenInfo.setAccess_token((String)map.get("access_token"));
            tokenInfo.setToken_type((String)map.get("token_type"));
            tokenInfo.setRefresh_token((String)map.get("refresh_token"));
            tokenInfo.setExpires_in((int)map.get("expires_in"));
            tokenInfo.setScope((String)map.get("scope"));
           //System.out.println("access_token==="+map.get("access_token")+", token_type="+map.get("token_type")+", refresh_token="+map.get("refresh_token")
           // +", expires_in="+map.get("expires_in")+", scope="+map.get("scope"));;
        }else{
            LOGGER.info("No user exist----------");
        }
        return tokenInfo;
    }
    
 public Map getAllJobs(AuthTokenInfo tokenInfo) {
	 Assert.notNull(tokenInfo, "Authenticate first please......");
     RestTemplate restTemplate = new RestTemplate(); 
      
     HttpEntity<String> request = new HttpEntity<String>(getHeaders());
     ResponseEntity<Object> response = restTemplate.exchange(REST_SERVICE_URI+"/jobs/"+QPM_ACCESS_TOKEN+tokenInfo.getAccess_token(),
             HttpMethod.GET, request, Object.class);
     Map<Object,Object> usersMap = (Map<Object,Object>)response.getBody();
      
     if(usersMap==null){
    	 LOGGER.info("No user exist----------");
     }
	return usersMap;
 }
 
 public Map getAllPlacements() {
     RestTemplate restTemplate = new RestTemplate(); 
     List<OAuthCredentials> l_lstAuthDetails=l_objOAuthServiceImpl.getOAuthDetails();
	 AuthTokenInfo l_objAuthTokenInfo=sendTokenRequest(l_lstAuthDetails);
	 Assert.notNull(l_objAuthTokenInfo, "Authenticate first please......");
     HttpEntity<String> request = new HttpEntity<String>(getHeaders());
     ResponseEntity<Object> response = restTemplate.exchange(REST_SERVICE_URI+"/placements/"+QPM_ACCESS_TOKEN+l_objAuthTokenInfo.getAccess_token(),
             HttpMethod.GET, request, Object.class);
     Map<Object,Object> usersMap = (Map<Object,Object>)response.getBody();
      
     if(usersMap==null){
    	 LOGGER.info("No user exist----------"); 
     }
	return usersMap;
 }
}
