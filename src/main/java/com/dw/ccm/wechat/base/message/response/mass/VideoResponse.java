package com.dw.ccm.wechat.base.message.response.mass;

import com.dw.ccm.wechat.base.message.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * 用于群发接口的上传视频 <code>media_id</code> 的响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class VideoResponse extends BaseResponse {
	
	/**
	 * 文件类型为 <code>video</code>
	 */
	private String type;

	/**
	 * 用于群发的消息的视频文件的media_id
	 */
	@SerializedName("media_id")
	private String mediaId;

	/**
	 * 创建时间
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
