package com.dw.ccm.wechat.base.message;

/**
 * 文章基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月10日
 */
public class ArticleMessage {
	
	/**
	 * 图文消息标题
	 */
	private String title;
	
	/**
	 * 图文消息描述
	 */
	private String description;
	
	/**
	 * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private String picUrl;
	
	/**
	 * 点击图文消息跳转链接
	 * 在图文消息页面点击“阅读原文”后的页面
	 */
	private String url;
	
	/**
	 * 图文消息缩略图的 <code>media_id</code>，可以在基础支持-上传多媒体文件接口中获得
	 */
	private String thumbMediaId;
	
	/**
	 * 图文消息的作者
	 */
	private String author;
	
	/**
	 * 图文消息页面的内容，支持HTML标签
	 */
	private String content;
	
	/**
	 * 新建一条图文消息，支持两种类型<ul>
	 * <li>被动响应消息
	 * <li>客服消息
	 * @param title 图文消息标题
	 * @param description 图文消息描述
	 * @param url 点击图文消息跳转链接
	 * @param picUrl 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	 */
	public ArticleMessage(String title, String description, String url, String picUrl) {
		this.title = title;
		this.description = description;
		this.url = url;
		this.picUrl = picUrl;
	}
	
	/**
	 * 新建一条图文消息，只支持群发消息中的图文消息
	 * @param title 图文消息的标题
	 * @param digest 图文消息的描述
	 * @param author 图文消息的作者
	 * @param content 图文消息页面的内容，支持HTML标签
	 * @param contentSourceUrl 在图文消息页面点击“阅读原文”后的页面
	 * @param thumbMediaId 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
	 */
	public ArticleMessage(String title, String digest, String author, String content, String contentSourceUrl, String thumbMediaId) {
		this.title = title;
		this.description = digest;
		this.author = author;
		this.content = content;
		this.url = contentSourceUrl;
		this.thumbMediaId = thumbMediaId;
	}

	/**
	 * 将 <code>ArticleMessage</code> 序列化为 <code>XML</code>
	 * @return <code>XML</code> 字符串
	 */
	public String toXML() {
		String xml = "<item><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description><PicUrl><![CDATA[%s]]></PicUrl><Url><![CDATA[%s]]></Url></item>";
		return String.format(xml,
				getTitle(),
				getDescription(),
				getPicUrl(),
				getUrl());
	}
	
	/**
	 * 将 <code>ArticleMessage</code> 对象序列化为 <code>JSON</code>
	 * @return <code>JSON</code> 字符串
	 */
	public String toJson() {
		String json = "{\"title\":\"%s\",\"description\":\"%s\",\"url\":\"%s\",\"picurl\":\"%s\"},";
		return String.format(json,
				getTitle(),
				getDescription(),
				getUrl(),
				getPicUrl());
	}
	
	/**
	 * 将 <code>ArticleMessage</code> 对象序列化为支持群发接口的单条图文消息的 <code>JSON</code>
	 * @return <code>JSON</code> 字符串
	 */
	public String toJsonForUploadNews() {
		String json = "{\"thumb_media_id\":\"%s\",\"author\":\"%s\",\"title\":\"%s\",\"content_source_url\":\"%s\",\"content\":\"%s\",\"digest\":\"%s\"},";
		return String.format(json,
				getThumbMediaId(),
				getAuthor(),
				getTitle(),
				getUrl(),
				getContent(),
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
