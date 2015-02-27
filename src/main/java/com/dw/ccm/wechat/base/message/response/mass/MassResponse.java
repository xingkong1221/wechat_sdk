package com.dw.ccm.wechat.base.message.response.mass;

import com.dw.ccm.wechat.base.message.response.BaseResponse;

/**
 * 群发响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月11日
 */
public class MassResponse extends BaseResponse {
	
	/**
	 * (注：未测试是否含有该字段)
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息为news
	 */
	private String type;
	
	/**
	 * 消息ID
	 */
	private String msgId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
}
