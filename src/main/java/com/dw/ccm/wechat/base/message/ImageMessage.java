package com.dw.ccm.wechat.base.message;


/**
 * 图片消息对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class ImageMessage extends BaseMessage {
	
	/**
	 * <li>通过上传多媒体文件，得到的 <code>id</code>
	 */
	private String mediaId;

	@Override
	public String toXML() {
		String xml = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[image]]></MsgType><Image><MediaId><![CDATA[%s]]></MediaId></Image></xml>";
		return String.format(xml,
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				getMediaId());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}}";
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
