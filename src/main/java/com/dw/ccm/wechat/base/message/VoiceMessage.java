package com.dw.ccm.wechat.base.message;

/**
 * 语音消息对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class VoiceMessage extends BaseMessage {

	/**
	 * 媒体 <code>id</code> ,通过上传多媒体文件得到
	 */
	private String mediaId;
	
	@Override
	public String toXML() {
		String xml = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[voice]]></MsgType><Voice><MediaId><![CDATA[%s]]></MediaId></Voice></xml>";
		return String.format(xml,
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				getMediaId());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}}";
		return String.format(json, 
				getToUserName(),
				getMediaId());
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
