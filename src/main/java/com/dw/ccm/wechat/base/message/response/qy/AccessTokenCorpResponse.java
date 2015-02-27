package com.dw.ccm.wechat.base.message.response.qy;

import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * 企业号获取AccessToken相应对象
 * 
 * @author xingkong1221
 * @date 2014年9月26日
 */
public class AccessTokenCorpResponse extends BaseResponse {
	
	/**
	 * 获取到的凭证
	 */
	@SerializedName("access_token")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
