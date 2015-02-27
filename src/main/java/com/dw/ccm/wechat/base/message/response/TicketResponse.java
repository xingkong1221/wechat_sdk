package com.dw.ccm.wechat.base.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * 二维码Ticket响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月9日
 */
public class TicketResponse extends BaseResponse {

	/**
	 * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码
	 */
	private String ticket;
	
	/**
	 * 二维码的有效时间，以秒为单位。最大不超过1800<br>
	 * 注：若请求的是永久二维码，该项为空
	 */
	@SerializedName("expire_seconds")
	private String expireSeconds;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(String expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
}
