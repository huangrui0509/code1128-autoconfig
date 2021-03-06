package com.example.autoconfig.domain;

import java.net.InetAddress;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "foo")
public class FooProperties {

	private boolean	enabled;
	private	InetAddress remoteAddress;
	private	final	Security security = new	Security();
	
	
	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public InetAddress getRemoteAddress() {
		return remoteAddress;
	}


	public void setRemoteAddress(InetAddress remoteAddress) {
		this.remoteAddress = remoteAddress;
	}


	public Security getSecurity() {
		return security;
	}


	public	static	class Security {
	private	 String username;
	private	 String password;
	private	 List<String> roles = 	new	 ArrayList<>(Collections.singleton("USER"));
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	}
}
