package com.wb.entity;

/**
 * 用户实体类
 * 
 * @author W
 *
 */
public class User {
	private int uid;
	private String uname;
	private String upwd;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public User(int uid, String uname, String upwd) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + "]";
	}
	
	public boolean equals(User user) {
		if (uname.equals(user.getUname())&&upwd.equals(user.getUpwd())) {
			return true;
		}else {
			return false;
		}
	}
}
