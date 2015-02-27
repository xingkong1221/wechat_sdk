package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 *  企业消息基础消息对象
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class BaseCorpMessage {

	/**
	 * UserID列表
	 */
	@SerializedName("touser")
	private String toUser;
	
	/**
	 * PartyID列表
	 */
	@SerializedName("toparty")
	private String toParty;
	
	/**
	 * TagID列表
	 */
	@SerializedName("totag")
	private String toTag;
	
	/**
	 * 消息类型
	 */
	@SerializedName("msgtype")
	private String msgType;
	
	/**
	 * 企业应用的id
	 */
	@SerializedName("agentid")
	private int agentId;
	
	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToParty() {
		return toParty;
	}

	public void setToParty(String toParty) {
		this.toParty = toParty;
	}

	public String getToTag() {
		return toTag;
	}

	public void setToTag(String toTag) {
		this.toTag = toTag;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
}
