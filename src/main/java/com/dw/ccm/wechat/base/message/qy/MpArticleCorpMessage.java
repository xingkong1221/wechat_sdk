package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 * 加密文章消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class MpArticleCorpMessage {
	
	/**
	 * 图文消息缩略图的media_id, 可以在上传多媒体文件接口中获得。此处thumb_media_id即上传接口返回的media_id
	 */
	@SerializedName("thumb_media_id")
	private String thumbMediaId;
	
	/**
	 * 图文消息的作者
	 */
	private String author;
	
	/**
	 * 图文消息点击“阅读原文”之后的页面链接
	 */
	@SerializedName("content_source_url")
	private String contentSourceUrl;
	
	/**
	 * 图文消息的内容，支持html标签
	 */
	private String content;
	
	/**
	 * 图文消息的描述
	 */
	private String digest;
	
	/**
	 * 是否显示封面，1为显示，0为不显示
	 */
	@SerializedName("show_cover_pic")
	private int showCoverPic;

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

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getShowCoverPic() {
		return showCoverPic;
	}

	public void setShowCoverPic(int showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
}
