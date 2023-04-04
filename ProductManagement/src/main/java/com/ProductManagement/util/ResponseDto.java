package com.ProductManagement.util;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

    private String status;
	
	private Object response;
	
	private String message;
	
	public int getStatus() {
		return Optional.ofNullable(Integer.parseInt(this.status)).orElse(404);
	}
}
