package com.gateway.models;

import lombok.Data;
import java.util.Collection;

@Data
public class AuthResponse {
	
	private String userId;
	private String accessToken;
	private String refreshToken;
	private Long expireAt; 
	private Collection<String> authorities ;

}
