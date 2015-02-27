package com.dw.ccm.wechat.base.message;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 被动响应消息
 * 
 * @author xingkong1221
 * @date 2014年6月27日
 */
public class PassiveMessage implements Serializable{

	private static final long serialVersionUID = -1152398010596731294L;
	
	/**
	 * 输出消息
	 */
	private BaseMessage message;
	
	/**
	 * 将被动响应消息序列化为 {@code XML} 消息
	 * @return 返回序列化后的 {@code XML} 消息
	 */
	public String toXML() {
		return (message == null) ? "" : message.toXML();
	}

	public BaseMessage getMessage() {
		return message;
	}

	public void setMessage(BaseMessage message) {
		this.message = message;
	}
	
}
