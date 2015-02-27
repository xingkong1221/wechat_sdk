package com.dw.ccm.wechat.base.message.mass;

import java.util.List;

/**
 * 群发消息基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public abstract class BaseMassMessage {
	
	/**
	 * 用于群发的消息的 <code>media_id</code>
	 */
	private String mediaId;

	/**
	 * 群发到的分组的 <code>group_id</code>
	 */
	private Integer groupId;
	
	/**
	 * OpenId列表
	 */
	private List<String> openIds;
	
	/**
	 * 
	 */
	public BaseMassMessage() { }
	
	/**
	 * 将该对象序列化为支持按分组群发的 <code>JSON</code> 字符串
	 * @return 返回 <code>JSON</code>　字符串
	 */
	public abstract String toJsonByGroup();
	
	/**
	 * 将该对象序列化为支持按OpenId群发的 <code>JSON</code> 字符串
	 * @return 返回 <code>JSON</code>　字符串
	 */
	public abstract String toJsonByOpenId();
	
	/**
	 * 获取 <code>Json</code> 格式的 <code>openid</code> 列表
	 * @return <code>Json</code> 字符串
	 */
	public String toJsonFromOpenIds() {
		// 设置初始化容量，可提高速度(每个openId长度约为28个字符)
		StringBuilder openIdBuilder = new StringBuilder(28 * openIds.size());
		for (String openId: openIds) {
			openIdBuilder.append("\"")
				.append(openId)
				.append("\",");
		}
		return openIdBuilder.substring(0, openIdBuilder.length()-1).toString();
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public List<String> getOpenIds() {
		return openIds;
	}

	public void setOpenIds(List<String> openIds) {
		this.openIds = openIds;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
