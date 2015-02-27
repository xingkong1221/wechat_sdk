package com.dw.ccm.wechat.base.message.qy;

/**
 * 企业消息 - 文本消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class TextCorpMessage extends BaseCorpMessage {
	
	private Content text;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	/**
	 * 初始化一个企业文本消息
	 */
	public TextCorpMessage() {
		setMsgType("text");
		text = new Content();
	}
	
	public String getText() {
		return text.getContent();
	}

	public void setText(String text) {
		this.text.setContent(text);
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	class Content {
		/**
		 * 消息内容
		 */
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
}
