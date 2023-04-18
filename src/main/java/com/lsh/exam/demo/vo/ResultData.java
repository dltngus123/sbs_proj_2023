package com.lsh.exam.demo.vo;

import lombok.Getter;

public class ResultData<DT> {
	
	@Getter
	private String resultCode;
	
	@Getter
	private String msg;
	
	@Getter
	private  DT data1;
	
	//생성자 만들어서 객체 생성못하게?
	private ResultData() {}
	
	public static ResultData from(String rsultCode, String msg) {
		
		return from(rsultCode, msg , null);
	}
	
	public static  <DT> ResultData<DT> from (String resultCode, String msg, DT data1) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1 = data1;
		
		return rd;
	}
	
	public static<DT> ResultData<DT> newData(ResultData joinRd, DT newData) {
		
		return from(joinRd.getResultCode(), joinRd.getMsg(), newData);
	}
	
	public boolean isSuccess() {
		//S-로 시작하면 성공
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		//F-로 시작하면 실패
		return isSuccess() == false;
	}



	


	
	

}
