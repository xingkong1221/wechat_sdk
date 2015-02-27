package com.dw.ccm.wechat.base.message.mass;

/**
 * 文本消息群发基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class TextMassMessage extends BaseMassMessage {
	
	/**
	 * 群发文本消息的内容
	 */
	private String content;

	@Override
	public String toJsonByGroup() {
		String json = "{\"filter\":{\"group_id\":\"%s\"},\"text\":{\"content\":\"%s\"},\"msgtype\":\"text\"}";
		return String.format(json,
				getGroupId(),
				getContent());
	}

	@Override
	public String toJsonByOpenId() {
		String json = "{\"touser\":[%s],\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
		return String.format(json,
				toJsonFromOpenIds(),
				getContent());
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
