package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 * 企业消息 - 文件消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class FileCorpMessage extends BaseCorpMessage {

	private File file;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	/**
	 * 实例化一个文件企业消息
	 */
	public FileCorpMessage() {
		setMsgType("file");
		file = new File();
	}
	
	/**
	 * 获取文件ID
	 * @return 文件ID
	 */
	public String getMediaId() {
		return file.getMediaId();
	}
	
	/**
	 * 设置文件ID
	 * @param mediaId 文件ID
	 */
	public void setMediaId(String mediaId) {
		file.setMediaId(mediaId);
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	class File {
		
		/**
		 * 文件ID
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
