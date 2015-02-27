package com.dw.ccm.wechat.base.message.response.mass;

import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * 上传图文消息素材响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class NewsResponse extends BaseResponse {
	
	/**
	 * 媒体文件类型，分别有<br><ul>
	 * <li>图片（image）
	 * <li>语音（voice）
	 * <li>视频（video）
	 * <li>缩略图（thumb）<br>
	 * 为news，即图文消息
	 */
	private String type;
	
	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
	 */
	@SerializedName("media_id")
	private String mediaId;
	
	/**
	 * 媒体文件上传时间
	 */
	@SerializedName("created_at")
	private String createdAt;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
