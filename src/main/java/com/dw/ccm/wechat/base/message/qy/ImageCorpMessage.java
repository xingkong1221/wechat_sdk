package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 * 企业消息 - 图片消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class ImageCorpMessage extends BaseCorpMessage {

	private Image image;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	/**
	 * 实例化一个图片企业消息
	 */
	public ImageCorpMessage() {
		setMsgType("image");
		image = new Image();
	}
	
	/**
	 * 获取媒体资源文件ID
	 * @return 媒体资源文件ID
	 */
	public String getImage() {
		return image.getMediaId();
	}
	
	/**
	 * 设置媒体资源文件ID
	 * @param mediaId 媒体资源文件ID
	 */
	public void setImage(String mediaId) {
		this.image.setMediaId(mediaId);;
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	class Image {
		/**
		 * 媒体资源文件ID
		 */
		@SerializedName("media_id")
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
