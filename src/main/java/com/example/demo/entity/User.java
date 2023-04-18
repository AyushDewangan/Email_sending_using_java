package com.example.demo.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document( collection = "user")
public class User {

	@NonNull
    @Indexed(unique = true)
	private String userId;
	@NonNull
	private String userName;
	@NonNull
	private String emailId;
	private Boolean deleteFlag;
	private String contactNo;
	public String getUserId() {
		return userId;
	}
	//String.valueOf(DateUtil.getUniqueSiteId())
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId
				+ ", deleteFlag=" + deleteFlag + ", contactNo=" + contactNo + "]";
	}
	
}
