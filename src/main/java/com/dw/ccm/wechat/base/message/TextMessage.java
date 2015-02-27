package com.dw.ccm.wechat.base.message;

/**
 * 文本消息对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class TextMessage extends BaseMessage {
	
	/**
	 * 文本消息内容
	 */
	private String content;

    /**
     * 实例化一个文本消息
     */
    public TextMessage() {
    }

    /**
     * 实例化一个文本消息
     *
     * @param content 消息内容
     */
    public TextMessage(String content) {
        this.content = content;
    }

    @Override
	public String toXML() {
		String xml = "<xml>"
				+ "<ToUserName><![CDATA[%s]]></ToUserName>"
				+ "<FromUserName><![CDATA[%s]]></FromUserName>"
				+ "<CreateTime>%s</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[%s]]></Content>"
				+ "</xml>";
		return String.format(xml, 
				getToUserName(),
				getFromUsername(),
				getCreateTime(),
				getContent());
	}

	@Override
	public String toJson() {
		String json = "{\"touser\":\"%s\","
				+ "\"msgtype\":\"text\","
				+ "\"text\":{\"content\":\"%s\"}}";
		return String.format(json, 
				getToUserName(),
				getContent());
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
