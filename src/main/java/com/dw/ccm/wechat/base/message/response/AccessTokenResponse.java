package com.dw.ccm.wechat.base.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * access_token响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class AccessTokenResponse extends BaseResponse {
	
	/**
	 * 获取到的API调用凭证
	 */
	@SerializedName("access_token")
	private String accessToken;
	
	/**
	 * 凭证有效时间，单位：秒
	 */
	@SerializedName("expires_in")
	private Integer expires;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpires() {
		return expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}
}
