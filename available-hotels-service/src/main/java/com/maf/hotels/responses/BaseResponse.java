package com.maf.hotels.responses;

import org.springframework.http.HttpStatus;

import com.maf.hotels.constants.ResponseCode;
import com.maf.hotels.constants.ResponseStatus;



public class BaseResponse {

	protected String status;
	protected String code;
	protected String message;



	public BaseResponse(String status, String code, String message ) {
		this.setStatus(status);
		this.setCode(code);
		this.setMessage(message);
	}

	protected <T> BaseResponse(BaseBuilder<T> builder) {
		this.status = builder.status;
		this.code = builder.code;
		this.message = builder.message;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}



    public static abstract class BaseBuilder<T> {
		public String status;
		public String code;
		public String message;

		public T status(String status) {
			this.status = status;
			return getInstance();
		}

		public T code(String code) {
			this.code = code;
			return getInstance();
		}

		public T message(String message) {
			this.message = message;
			return getInstance();	}

		public T fromPrototype(BaseResponse prototype) {
			status = prototype.status;
			code = prototype.code;
			message = prototype.message;
			return getInstance();
		}

		protected abstract T getInstance();

		public BaseResponse baseBuild() {
			return new BaseResponse(this);
		}

	}

	public static BaseResponse unAuthorized(){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED, ResponseCode.RESPONSE_CODE_UNAUTHORIZED,
				"sorry you are not authorized");
	}

	public static BaseResponse unAuthorized(String msg){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED, ResponseCode.RESPONSE_CODE_UNAUTHORIZED,msg);
	}

	public static BaseResponse forbidden(){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED, ResponseCode.RESPONSE_CODE_FORBIDDEN,
				"forbidden");
	}

	public static BaseResponse notFound(){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED,ResponseCode.RESPONSE_CODE_NOT_FOUND,
				"Not Found !");
	}
	
	public static BaseResponse notFound(String fieldName){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED,ResponseCode.RESPONSE_CODE_NOT_FOUND,
				fieldName);
	}
	
	public static BaseResponse noContent() {
		return new BaseResponse(HttpStatus.NO_CONTENT.name(),ResponseCode.NO_CONTENT,
				"no content");
	}

	public static BaseResponse alreadyRegistered(){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED,ResponseCode.RESPONSE_CODE_BAD_REQUEST,
				"already registered");
	}
	public static BaseResponse alreadyLoggedIn(){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED,ResponseCode.RESPONSE_CODE_BAD_REQUEST,
				"you are already logged in");
	}

	public static BaseResponse failed(String message){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_FAILED,ResponseCode.RESPONSE_CODE_BAD_REQUEST,message);
	}
	public static BaseResponse success(String message){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_SUCCESS,ResponseCode.RESPONSE_CODE_SUCCESS,message);
	}
	public static BaseResponse created(String message){
		return new BaseResponse(ResponseStatus.RESPONSE_STATUS_SUCCESS,ResponseCode.RESPONSE_CODE_CREATED,message);
	}

}
