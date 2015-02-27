package com.dw.ccm.wechat.base.message;

/**
 * 基础消息对象，包括：<ul>
 * <li>客服消息
 * <li>被动响应消息</ul>
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public abstract class BaseMessage {
	
	/**
	 * 接收方帐号（{@code open_id}）
	 */
	private String toUserName;
	
	/**
	 * 发送发帐号（{@code open_id}）
	 */
	private String fromUsername;
	
	/**
	 * 消息创建时间 （整型）
	 */
	private Long createTime;
	
	public BaseMessage() {
		// 创建时间（UNIX时间戳）
		this.createTime = System.currentTimeMillis() / 1000;
	}
	
	/**
	 * 将该消息对象序列化为 <code>XML</code> 字符串
	 * @return 返回序列化后的 <code>XML</code> 字符串
	 */
	public abstract String toXML();
	
	/**
	 * 将该对象序列化为 <code>JSON</code> 字符串
	 * @return 返回序列化后的 <code>JSON</code> 字符串
	 */
	public abstract String toJson();
	
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUsername() {
		return fromUsername;
	}

	public void setFromUsername(String fromUsername) {
		this.fromUsername = fromUsername;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
}
