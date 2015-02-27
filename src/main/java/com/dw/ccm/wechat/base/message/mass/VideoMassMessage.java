package com.dw.ccm.wechat.base.message.mass;

/**
 * 视频消息群发基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class VideoMassMessage extends BaseMassMessage {
	
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;

	@Override
	public String toJsonByGroup() {
		String json = "{\"filter\":{\"group_id\":\"%s\"},\"mpvideo\":{\"media_id\":\"%s\",},\"msgtype\":mpvideo\"}";
		return String.format(json,
				getGroupId(),
				getMediaId());
	}

	@Override
	public String toJsonByOpenId() {
		String json = "{\"touser\":[%s],\"video\":{\"media_id\":\"%s\",\"title\":\"%s\",\"description\":\"%s\"},\"msgtype\":\"video\"}";
		return String.format(json,
				toJsonFromOpenIds(),
				getMediaId(),
				getTitle(),
				getDescription());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
