package com.ProductManagement.util;

public class Constants {
	public enum STATUS {
		ACTIVE, INACTIVE, PENDING, SCHEDULE, INPROGRESS, COMPLETED
	}

	public enum RES_CODES {
		SUCCESS("200"), 
		FAILED("404"), 
		GET_SUCCESS("200"),
		INVALID_ID("404"),
		CREAT_SUCCESS("201"), 
		BAD_REQUEST("400");

		String statusCodes = "";

		RES_CODES(String statusCodes) {
			this.statusCodes = statusCodes;
		}

		public String toString() {
			return this.statusCodes;
		}

	}
}
