package com.noahedu.noahmvpdemo.model.beans;

 
public class BeanDitu {
	
	private boolean result;

	private String code;

	private String message;

	private String cip;

	@Override
	public String toString() {
		return 
		",result"+result+
		",code"+code+
		",message"+message+
		",cip"+cip;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean getResult() {
		return this.result;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCip() {
		return this.cip;
	}

}
