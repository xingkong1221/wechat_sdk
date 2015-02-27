package com.dw.ccm.wechat.base.message.qy;

import com.google.gson.annotations.SerializedName;

/**
 * 企业消息 - 语音消息
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class VoiceCorpMessage extends BaseCorpMessage {

	private Voice voice;
	
	/**
	 * 表示是否是保密消息，0表示否，1表示是，默认0
	 */
	private int safe = 0;
	
	/**
	 * 实例化一个语音企业消息
	 */
	public VoiceCorpMessage() {
		setMsgType("voice");
		voice = new Voice();
	}
	
	/**
	 * 获取媒体资源文件ID
	 * @return 媒体资源文件ID
	 */
	public String getVoice() {
		return voice.getMediaId();
	}
	
	/**
	 * 设置媒体资源文件ID
	 * @param voice 媒体资源文件ID
	 */
	public void setVoice(String mediaId) {
		this.voice.setMediaId(mediaId);;
	}
	
	public int getSafe() {
		return safe;
	}

	public void setSafe(int safe) {
		this.safe = safe;
	}

	class Voice {
		
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
