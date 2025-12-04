package com.sist.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String userid,username,userpwd,sex,authority;
	private int enable;
}
