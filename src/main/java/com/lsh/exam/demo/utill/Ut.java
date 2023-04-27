package com.lsh.exam.demo.utill;

import java.net.URLEncoder;

public class Ut {
	
	public static boolean empty(Object obj) {
		
		//null 체크
		if ( obj == null ) {
			return true;
		}
		
		if (obj instanceof Integer) {
			return ((int) obj) == 0;
		}
		
		if (obj instanceof Long) {
			return ((long) obj) == 0;
		}
		
		//string 객체인지 아닌지 체크
		if (obj instanceof String == false) {
			return true;
		}
		
		String str = (String) obj;
		
		//빈공간인지 아닌지 체크
		return str.trim().length() == 0;
	}

	//몇개의 object가 들어올지몰라서 밑처럼 만들어주면 알아서 배열로 들어옴
	public static String f(String format, Object... args) {
		
		return String.format(format, args);
	}

	public static String jsHistoryBack(String msg) {
		
		return Ut.f("""
				<script>
					const msg = '%s'.trim();
					if (msg.length > 0) {
						alert(msg);
					}
					history.back();
				</script>
				""", msg);
	}
	
	public static String jsReplace(String msg, String uri) {
		if (msg == null ) {
			msg = "";
		}
		
		if (uri == null) {
			uri="";
		}
		return Ut.f("""
				<script>
					const msg = '%s'.trim();
					if (msg.length > 0) {
						alert(msg);
					}
					location.replace('%s');
				</script>
				""", msg, uri);
	}

	public static String getUriEncoded(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (Exception e) {
			return str;
		}
	}

	

}
