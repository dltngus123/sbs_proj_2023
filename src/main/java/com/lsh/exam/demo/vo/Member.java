package com.lsh.exam.demo.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String id;
	private String pwd;
	private Date regDate;
	private Date updateDate;
	private String name;
	private String nickname;
	private String cellphoneNo;
	private String email;
	

}
