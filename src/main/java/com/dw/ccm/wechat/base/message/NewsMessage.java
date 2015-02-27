package com.dw.ccm.wechat.base.message;

import java.util.List;

/**
 * 图文消息基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class NewsMessage extends BaseMessage {
	
	/**
	 * 图文消息列表
	 */
	private List<ArticleMessage> items;
	
	/**
	 * 用于群发的消息的media_id
	 */
	private String mediaId;
	
	@Override
	public String toXML() {
		String xml = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>%s</ArticleCount><Articles>%s</Articles></xml> ";
		StringBuilder articlesBuilder = new StringBuilder();
		for (ArticleMessage item : items) {
			articlesBuilder.append(item.toXML());
		}
		return String.format(xml,
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				items.size(),
				articlesBuilder.toString());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\": [%s]}}";
		StringBuilder articlesBuilder = new StringBuilder(200);
		for (ArticleMessage item : items) {
			articlesBuilder.append(item.toJson());
		}
		return String.format(json,
				getToUserName(),
				articlesBuilder.substring(0, articlesBuilder.length()-1).toString());
	}
	
	/**
	 * 将对象序列化为上传图文消息素材的 <code>JSON</code> 字符串
	 * @return <code>JSON</code> 字符串
	 */
	public String toJsonForUploadNews() {
		String json = "{\"articles\": [%s]}";
		StringBuilder articlesBuilder = new StringBuilder(200);
		for (ArticleMessage item : items) {
			articlesBuilder.append(item.toJsonForUploadNews());
		}
		return String.format(json,
				articlesBuilder.substring(0, articlesBuilder.length()-1).toString());
	}

	public List<ArticleMessage> getItems() {
		return items;
	}

	public void setItems(List<ArticleMessage> items) {
		this.items = items;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
