package com.dw.ccm.wechat.base.message.qy;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 企业消息 - mp新闻消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class MpNewsCorpMessage extends BaseCorpMessage {
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	@SerializedName("mpnews")
	private MpNews mpNews;
	
	/**
	 * 实例化一个mp新闻消息
	 */
	public MpNewsCorpMessage() {
		setMsgType("mpnews");
		mpNews = new MpNews();
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}
	
	public List<MpArticleCorpMessage> getArticles() {
		return mpNews.getArticles();
	}

	public void setArticles(List<MpArticleCorpMessage> articles) {
		mpNews.setArticles(articles);
	}

	public String getMediaId() {
		return mpNews.getMediaId();
	}

	public void setMediaId(String mediaId) {
		mpNews.setMediaId(mediaId);
	}
	
	class MpNews {
		
		/**
		 * 图文消息，一个图文消息支持1到10个图文
		 */
		private List<MpArticleCorpMessage> articles;
		
		/**
		 * 缩略图编号
		 */
		@SerializedName("media_id")
		private String mediaId;

		public List<MpArticleCorpMessage> getArticles() {
			return articles;
		}

		public void setArticles(List<MpArticleCorpMessage> articles) {
			this.articles = articles;
		}

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}

}
