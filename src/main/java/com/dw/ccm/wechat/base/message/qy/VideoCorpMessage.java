package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 * 企业消息 - 视频消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class VideoCorpMessage extends BaseCorpMessage {
	
	private Video video;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	/**
	 * 实例化一个视频企业消息
	 */
	public VideoCorpMessage() {
		setMsgType("video");
		video = new Video();
	}
	
	/**
	 * 获取媒体资源文件ID
	 * @return 媒体资源文件ID
	 */
	public String getMediaId() {
		return video.getMediaId();
	}
	
	/**
	 * 设置媒体资源文件ID
	 * @param mediaId 媒体资源文件ID
	 */
	public void setMediaId(String mediaId) {
		video.setMediaId(mediaId);
	}

	/**
	 * 获取视频消息的标题
	 * @return 视频消息的标题
	 */
	public String getTitle() {
		return video.getTitle();
	}
	
	/**
	 * 设置视频消息的标题
	 * @param title 视频消息的标题
	 */
	public void setTitle(String title) {
		video.setTitle(title);
	}
	
	/**
	 * 获取视频消息的描述
	 * @return 视频消息的描述
	 */
	public String getDescription() {
		return video.getDescription();
	}

	/**
	 * 设置视频消息的描述
	 * @param description 视频消息的描述
	 */
	public void setDescription(String description) {
		video.setDescription(description);
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}
	
	class Video {
		
		/**
		 * 媒体资源文件ID
		 */
		@SerializedName("media_id")
		private String mediaId;
		
		/**
		 *视频消息的标题 
		 */
		private String title;
		
		/**
		 * 视频消息的描述
		 */
		private String description;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
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
	}
}
