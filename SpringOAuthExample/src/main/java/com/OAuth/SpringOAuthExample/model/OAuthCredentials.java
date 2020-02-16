package com.OAuth.SpringOAuthExample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorisation_details")
public class OAuthCredentials {
    @Id
	private int id;
    @Column
	private String authorisation_code;
	private String auth_switch;
	private String access_token;
	private String refresh_token;
	private String token_type;
	private String redirect_uri;
	private String scope;
	private String state;
	private int expires_in;
	private String acc_token_status;
	private String refresh_token_status;
	private int token_freq;
	private int refresh_token_freq;
	private Date acc_token_created_date;
	private Date acc_token_modified_date;
	private Date refresh_token_created_date;
	private Date refresh_token_modified_date;
	
	
	public String getAuthorisation_code() {
		return authorisation_code;
	}
	public void setAuthorisation_code(String authorisation_code) {
		this.authorisation_code = authorisation_code;
	}
	public String getAuth_switch() {
		return auth_switch;
	}
	public void setAuth_switch(String auth_switch) {
		this.auth_switch = auth_switch;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getAcc_token_status() {
		return acc_token_status;
	}
	public void setAcc_token_status(String acc_token_status) {
		this.acc_token_status = acc_token_status;
	}
	public String getRefresh_token_status() {
		return refresh_token_status;
	}
	public void setRefresh_token_status(String refresh_token_status) {
		this.refresh_token_status = refresh_token_status;
	}
	public int getToken_freq() {
		return token_freq;
	}
	public void setToken_freq(int token_freq) {
		this.token_freq = token_freq;
	}
	public int getRefresh_token_freq() {
		return refresh_token_freq;
	}
	public void setRefresh_token_freq(int refresh_token_freq) {
		this.refresh_token_freq = refresh_token_freq;
	}
	public Date getAcc_token_created_date() {
		return acc_token_created_date;
	}
	public void setAcc_token_created_date(Date acc_token_created_date) {
		this.acc_token_created_date = acc_token_created_date;
	}
	public Date getAcc_token_modified_date() {
		return acc_token_modified_date;
	}
	public void setAcc_token_modified_date(Date acc_token_modified_date) {
		this.acc_token_modified_date = acc_token_modified_date;
	}
	public Date getRefresh_token_created_date() {
		return refresh_token_created_date;
	}
	public void setRefresh_token_created_date(Date refresh_token_created_date) {
		this.refresh_token_created_date = refresh_token_created_date;
	}
	public Date getRefresh_token_modified_date() {
		return refresh_token_modified_date;
	}
	public void setRefresh_token_modified_date(Date refresh_token_modified_date) {
		this.refresh_token_modified_date = refresh_token_modified_date;
	}
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getRedirect_uri() {
		return redirect_uri;
	}
	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "OAuthCredentials [id=" + id + ", authorisation_code=" + authorisation_code + ", auth_switch="
				+ auth_switch + ", access_token=" + access_token + ", refresh_token=" + refresh_token + ", token_type="
				+ token_type + ", redirect_uri=" + redirect_uri + ", scope=" + scope + ", state=" + state
				+ ", expires_in=" + expires_in + ", acc_token_status=" + acc_token_status + ", refresh_token_status="
				+ refresh_token_status + ", token_freq=" + token_freq + ", refresh_token_freq=" + refresh_token_freq
				+ ", acc_token_created_date=" + acc_token_created_date + ", acc_token_modified_date="
				+ acc_token_modified_date + ", refresh_token_created_date=" + refresh_token_created_date
				+ ", refresh_token_modified_date=" + refresh_token_modified_date + "]";
	}
	
}
