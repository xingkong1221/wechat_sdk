package com.dw.ccm.wechat.base.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * 用户基本信息响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class UserInfoResponse extends BaseResponse {

	/**
	 * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息
	 */
	private Integer subscribe;
	
	/**
	 * 用户的标识，对当前公众号唯一
	 */
	@SerializedName("openid")
	private String openId;
	
	/**
	 * 用户的昵称
	 */
	@SerializedName("nickname")
	private String nickName;
	
	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	private Integer sex;
	
	/**
	 * 用户所在城市
	 */
	private String city;
	
	/**
	 * 用户所在国家
	 */
	private String country;
	
	/**
	 * 用户所在省份
	 */
	private String province;
	
	/**
	 * 用户的语言，简体中文为zh_CN
	 */
	private String language;
	
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	 */
	@SerializedName("headimgurl")
	private String headImageUrl;
	
	/**
	 * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	 */
	@SerializedName("subscribe_time")
	private Integer subscribeTime;

	public Integer getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadImageUrl() {
		return headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}

	public Integer getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Integer subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
}
