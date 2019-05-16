package com.maf.hotels.responses;

import java.util.ArrayList;
import java.util.List;

import com.maf.hotels.constants.ResponseCode;
import com.maf.hotels.constants.ResponseStatus;

public class ListResponse<T> extends BaseResponse {
	
	private int size;
	private List<T> data;

	public ListResponse(String status, String code, String message , List<T> data) {
		super(status, code, message);
		this.setData(data);
		this.setSize(data.size());
	}

	private ListResponse(Builder<T> builder) {
		super(builder);
		this.size = builder.size;
		this.data = builder.data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public List<T> getData() {
		return data;
	}

	public static Builder builder(){
		return new Builder();
	}

	private static class Builder<T> extends BaseBuilder<Builder<T>>{
		private List<T> data;
		private int size;

		public Builder<T> data(Iterable<T> data) {

			List<T> list = new ArrayList<>();
			for (T datum : data) {
				list.add(datum);
			}

			this.data = list;
			size = this.data.size();
			return this;
		}

		public Builder<T> fromPrototype(ListResponse prototype) {
			super.fromPrototype(prototype);
			data = prototype.data;
			return this;
		}

		public ListResponse<T> build() {
			return new ListResponse(this);
		}

		@Override
		protected Builder<T> getInstance() {
			return this;
		}
	}

	public static <T> ListResponse<T> found(Iterable<T> data){
		return (ListResponse<T>) new Builder<T>()
				.data(data)
				.code(ResponseCode.RESPONSE_CODE_SUCCESS)
				.status(ResponseStatus.RESPONSE_STATUS_SUCCESS)
				.message("Successfully retrieved list")
				.build();
	}

}
