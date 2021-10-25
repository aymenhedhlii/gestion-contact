package com.ant.gc.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public class MessageResponse {
	private Boolean success;
	private String message;
	private String detail;

}
