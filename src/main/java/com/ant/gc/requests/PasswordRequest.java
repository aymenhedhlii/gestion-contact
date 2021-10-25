package com.ant.gc.requests;

import lombok.Data;

@Data
public class PasswordRequest {
	private String username;
	private String oldPassword;
	private String newPassword;

}
