package com.dw.ccm.wechat.base.message.response.smartbind;

/**
 * 微信公众号信息
 * 
 * @author xingkong1221
 * @date 2014年7月4日
 */
public class WechatAccount {
	
	
	/**
	 * 微信公众号名称
	 */
	private String name;
	
	/**
	 * 微信公众号头像
	 */
	private byte[] avatar;
	
	/**
	 * 微信公众号号登录邮箱
	 */
	private String email;
	
	/**
	 * 原始 {@code id}
	 */
	private String openId;
	
	/**
	 * 微信号
	 */
	private String wechatName;
	
	/**
	 * 微信号类型
	 */
	private String type;
	
	/**
	 * 认证情况
	 */
	private String auth;
	
	/**
	 * 微信公众号介绍
	 */
	private String introduce;
	
	/**
	 * 所在地址
	 */
	private String address;
	
	/**
	 * 认证资料
	 */
	private String authDetail;
	
	/**
	 * 二维码
	 */
	private byte[] qrcode;
	
	/**
	 * 8厘米边长的二维码
	 */
	private byte[] qrcode8;
	
	/**
	 * 12厘米边长的二维码
	 */
	private byte[] qrcode12;
	
	/**
	 * 15厘米边长的二维码
	 */
	private byte[] qrcode15;
	
	/**
	 * 30厘米边长的二维码
	 */
	private byte[] qrcode30;
	
	/**
	 * 50厘米边长的二维码
	 */
	private byte[] qrcode50;
	
	/**
	 * {@code app_id}
	 */
	private String appId;
	
	/**
	 * {@code app_secret}
	 */
	private String appSecret;
	
	/**
	 * 接受微信消息推送的 {@code url}
	 */
	private String url;
	
	/**
	 * 验证微信消息签名验证的 {@code token}
	 */
	private String token;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthDetail() {
		return authDetail;
	}

	public void setAuthDetail(String authDetail) {
		this.authDetail = authDetail;
	}

	public byte[] getQrcode() {
		return qrcode;
	}

	public void setQrcode(byte[] qrcode) {
		this.qrcode = qrcode;
	}

	public byte[] getQrcode8() {
		return qrcode8;
	}

	public void setQrcode8(byte[] qrcode8) {
		this.qrcode8 = qrcode8;
	}

	public byte[] getQrcode12() {
		return qrcode12;
	}

	public void setQrcode12(byte[] qrcode12) {
		this.qrcode12 = qrcode12;
	}

	public byte[] getQrcode15() {
		return qrcode15;
	}

	public void setQrcode15(byte[] qrcode15) {
		this.qrcode15 = qrcode15;
	}

	public byte[] getQrcode30() {
		return qrcode30;
	}

	public void setQrcode30(byte[] qrcode30) {
		this.qrcode30 = qrcode30;
	}

	public byte[] getQrcode50() {
		return qrcode50;
	}

	public void setQrcode50(byte[] qrcode50) {
		this.qrcode50 = qrcode50;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
