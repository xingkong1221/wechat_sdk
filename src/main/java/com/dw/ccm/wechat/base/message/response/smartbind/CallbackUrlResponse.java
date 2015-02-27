package com.dw.ccm.wechat.base.message.response.smartbind;

/**
 * 设置接受微信消息推送URL的响应对象
 * 
 * @author xingkong1221
 * @date 2014年7月4日
 */
public class CallbackUrlResponse {

	/**
	 * 状态码
	 */
	private Integer ret;
	
	/**
	 * 消息
	 */
	private String msg;

	public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
