package com.kimdeath.domain;

import java.io.Serializable;
import java.util.Date;
public class ApplicationDTO implements Serializable{
	
	private static final long serialVersionUID = -3078175751450820169L;
	private String appId; //应用主键Id
	private String appName;//发布服务名称
	private String appNameAlias;//英文名
	private String appInstanceId;//部署服务名称ID
	private  Integer projectResource ;//服务发布方式：1-服务实例；2-URL实例
	private  String publishedChannel ;//发布渠道：1-发布到链城；2-软体云网开发者门户
	private  String appVersion ;//版本 
	private  String svcCategoryId ;//二级分类 :链城分类调用polit 接口，开发者门户svc_app_category
	private  String outerAppUrl ;//访问该服务的外网url
	private  String description ;//应用描述
	private String keyword;//关键字
	private String linkMan;//联系人姓名
	private String mobile;//联系人姓名
	private String email;//邮箱
	private String qrCode;//二维码信息。用于保存二维码的二进制数据信息
	private Integer clickedNum;//点击量
	private  String currentStatus ;//当前服务的状: 10-上架审核中；11-上架审核成功；12-上架审核失败；20-下架审核中；21-下架审核成功；22-下架审核失败
	private String slogen;//slogen, 移动端展示移动欢迎界面时，使用的类似欢迎首页提示信息
	private  Integer deleted ;//是否有效。1：有效；0：无效
	private Date createdAt ;//创建时间
	private Date updatedAt ;//更新时间
	private String createdBy ;//创建者
	
	private String fileUrl;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppNameAlias() {
		return appNameAlias;
	}
	public void setAppNameAlias(String appNameAlias) {
		this.appNameAlias = appNameAlias;
	}
	public String getAppInstanceId() {
		return appInstanceId;
	}
	public void setAppInstanceId(String appInstanceId) {
		this.appInstanceId = appInstanceId;
	}
	public Integer getProjectResource() {
		return projectResource;
	}
	public void setProjectResource(Integer projectResource) {
		this.projectResource = projectResource;
	}
	public String getPublishedChannel() {
		return publishedChannel;
	}
	public void setPublishedChannel(String publishedChannel) {
		this.publishedChannel = publishedChannel;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getSvcCategoryId() {
		return svcCategoryId;
	}
	public void setSvcCategoryId(String svcCategoryId) {
		this.svcCategoryId = svcCategoryId;
	}
	public String getOuterAppUrl() {
		return outerAppUrl;
	}
	public void setOuterAppUrl(String outerAppUrl) {
		this.outerAppUrl = outerAppUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getClickedNum() {
		return clickedNum;
	}
	public void setClickedNum(Integer clickedNum) {
		this.clickedNum = clickedNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getSlogen() {
		return slogen;
	}
	public void setSlogen(String slogen) {
		this.slogen = slogen;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
