package com.dw.ccm.wechat.base.message.response.template;

import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * 模板消息响应对象
 * 
 * @author xingkong1221
 * @date 2014年9月15日
 */
public class TemplateResponse extends BaseResponse {

	/**
	 * 模板消息编号
	 */
	@SerializedName("msgid")
	private String msgId;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}
