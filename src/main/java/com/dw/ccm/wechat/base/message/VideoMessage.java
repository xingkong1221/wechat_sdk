package com.dw.ccm.wechat.base.message;

/**
 * 视频消息对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class VideoMessage extends BaseMessage {
	
	/**
	 * 通过上传多媒体文件，得到的id
	 */
	private String mediaId;
	
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;

	@Override
	public String toXML() {
		String xml = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[%s]]></MediaId><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description></Video></xml>";
		return String.format(xml, 
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				getMediaId(),
				getTitle(),
				getDescription());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"title\":\"%s\",\"description\":\"%s\"}}";
		return String.format(json,
				getToUserName(),
				getMediaId(),
				getTitle(),
				getDescription());
	}
	
	/**
	 * 将对象序列化为获取支持群发视频消息的 <code>media_id</code> 的 <code>Json</code> 字符串
	 * @return <code>Json</code> 字符串
	 */
	public String toJsonForUploadVideo() {
		String json = "{\"media_id\":\"%s\",\"title\":\"%s\",\"description\":\"%s\"}";
		return String.format(json,
				getMediaId(),
				getTitle(),
				getDescription());
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
