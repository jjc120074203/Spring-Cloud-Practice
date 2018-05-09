package com.kimdeath.configuration.auth;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实名认证DTO
 * @author xx
 *
 */
@ApiModel(value = "IdentifyAccountInfoDTO", description = "实名认证DTO")
public class IdentifyAccountInfoDTO implements Serializable {

	private static final long serialVersionUID = -1L;

	@ApiModelProperty(value = "认证类型personal =个人", example = "" )
	private String authType; //认证类型personal =个人
	
	@ApiModelProperty(value = "真实姓名", example = "")
	private String authRealName; //真实姓名
	
	@ApiModelProperty(value = "昵称", example = "")
	private String nickName; //昵称
	
	@ApiModelProperty(value = "性别 0=男/ 1=女", example = "" )
	private String authSex; //性别 0=男/ 1=女
	
	@ApiModelProperty(value = "身份证号码", example = "" )
	private String authIdCard; //身份证号码
	
	@ApiModelProperty(value = "手机号码", example = "" )
	private String authPhone; //手机号码
	
	@ApiModelProperty(value = "短信验证码", example = "" )
	private String authCode; //短信验证码

	private String authStatus;// 0 认证待审核，1认证通过，2 认证失败
	
	private String authApixMsg;//认证服务商请求成功或失败的信息
	
	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthRealName() {
		return authRealName;
	}

	public void setAuthRealName(String authRealName) {
		this.authRealName = authRealName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAuthSex() {
		return authSex;
	}

	public void setAuthSex(String authSex) {
		this.authSex = authSex;
	}

	public String getAuthIdCard() {
		return authIdCard;
	}

	public void setAuthIdCard(String authIdCard) {
		this.authIdCard = authIdCard;
	}

	public String getAuthPhone() {
		return authPhone;
	}

	public void setAuthPhone(String authPhone) {
		this.authPhone = authPhone;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getAuthApixMsg() {
		return authApixMsg;
	}

	public void setAuthApixMsg(String authApixMsg) {
		this.authApixMsg = authApixMsg;
	}

	@Override
	public String toString() {
		return "IdentifyAccountInfoDTO [authType=" + authType + ", authRealName=" + authRealName + ", nickName="
				+ nickName + ", authSex=" + authSex + ", authIdCard=" + authIdCard + ", authPhone=" + authPhone
				+ ", authCode=" + authCode + ", authStatus=" + authStatus + ", authApixMsg=" + authApixMsg + "]";
	}

}
