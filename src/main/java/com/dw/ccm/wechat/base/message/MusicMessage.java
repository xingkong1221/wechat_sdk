package com.dw.ccm.wechat.base.message;

/**
 * 音乐消息对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class MusicMessage extends BaseMessage {

	/**
	 * 音乐标题
	 */
	private String title;
	
	/**
	 * 音乐描述
	 */
	private String description;
	
	/**
	 * 音乐描述
	 */
	private String musicUrl;
	
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hqMusicUrl;
	
	/**
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	private String thumbMediaId;
	
	@Override
	public String toXML() {
		String xml = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[music]]></MsgType><Music><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description><MusicUrl><![CDATA[%s]]></MusicUrl><HQMusicUrl><![CDATA[%s]]></HQMusicUrl><ThumbMediaId><![CDATA[%s]]></ThumbMediaId></Music></xml>";
		return String.format(xml, 
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				getTitle(),
				getDescription(),
				getMusicUrl(),
				getHqMusicUrl(),
				getThumbMediaId());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":{\"title\":\"%s\",\"description\":\"%s\",\"musicurl\":\"%s\",\"hqmusicurl\":\"%s\",\"thumb_media_id\":\"%s\"}}";
		return String.format(json,
				getToUserName(),
				getTitle(),
				getDescription(),
				getMusicUrl(),
				getHqMusicUrl(),
				getThumbMediaId());
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
}
