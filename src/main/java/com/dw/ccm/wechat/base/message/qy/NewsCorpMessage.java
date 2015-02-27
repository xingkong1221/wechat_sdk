package com.dw.ccm.wechat.base.message.qy;

import java.util.List;

/**
 * 企业消息 - 新闻
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class NewsCorpMessage extends BaseCorpMessage {
	
	private News news;
	
	/**
	 * 实例化新闻企业消息
	 */
	public NewsCorpMessage() {
		setMsgType("news");
		news = new News();
	}
	
	/**
	 * 获取文章消息列表
	 * @return 文章消息列表
	 */
	public List<ArticleCorpMessage> getArticles() {
		return news.getArticles();
	}

	/**
	 * 设置文章消息列表
	 * @param articles 文章消息列表
	 */
	public void setArticles(List<ArticleCorpMessage> articles) {
		news.setArticles(articles);
	}
	
	class News {
		
		/**
		 * 文章列表
		 */
		private List<ArticleCorpMessage> articles;

		public List<ArticleCorpMessage> getArticles() {
			return articles;
		}

		public void setArticles(List<ArticleCorpMessage> articles) {
			this.articles = articles;
		}
	}
}
