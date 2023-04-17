package com.lsh.exam.demo.utill;

public class Ut {
	
	public static boolean empty(Object obj) {
		
		//null 체크
		if ( obj == null ) {
			return true;
		}
		
		//string 객체인지 아닌지 체크
		if (obj instanceof String == false) {
			return true;
		}
		
		String str = (String) obj;
		
		//빈공간인지 아닌지 체크
		return str.trim().length()==0;
	}

}
