package com.dw.ccm.wechat.base.message.response.smartbind;

import com.google.gson.annotations.SerializedName;

/**
 * 微信公众平台登录响应对象
 * 
 * @author xingkong1221
 * @date 2014年7月3日
 */
public class LoginResponse {

	/**
	 * 登录基础返回
	 */
	@SerializedName("base_resp")
	private BaseResponse baseResp;
	
	/**
	 * 跳转链接
	 */
	@SerializedName("redirect_url")
	private String redirectUrl;

	public static class BaseResponse {
		/**
		 * 登录状态返回值
		 */
		private Integer ret;
		
		/**
		 * 错误信息
		 */
		@SerializedName("err_msg")
		private String errMsg;

		public Integer getRet() {
			return ret;
		}

		public void setRet(Integer ret) {
			this.ret = ret;
		}

		public String getErrMsg() {
			return errMsg;
		}

		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
	}

	public BaseResponse getBaseResp() {
		return baseResp;
	}

	public void setBaseResp(BaseResponse baseResp) {
		this.baseResp = baseResp;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
