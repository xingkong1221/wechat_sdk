package com.dw.ccm.wechat.base.message.response;

import com.google.gson.annotations.SerializedName;

/**
 * 上传文件响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class UploadResponse extends BaseResponse {

	/**
	 * 媒体文件类型，分别有:<br><ul>
	 * <li>图片（image）
	 * <li>语音（voice）
	 * <li>视频（video）
	 * <li>缩略图（thumb,主要用于视频与音乐格式的缩略图）
	 */
	private String type;
	
	/**
	 * 媒体文件上传后，获取时的唯一标识
	 */
	@SerializedName("media_id")
	private String mediaId;
	
	/**
	 * 媒体文件上传时间戳
	 */
	@SerializedName("created_at")
	private Long createdAt;

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

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
}
