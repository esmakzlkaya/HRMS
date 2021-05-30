package com.esmakzlkaya.HRMS.core.utilities.results;

public class Result {

	public Result(boolean success) {
		super();
		this.success=success;
	}
	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	private boolean success;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
