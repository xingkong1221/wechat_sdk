package com.dw.ccm.wechat.base.message.mass;

/**
 * 语音消息群发基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class VoiceMassMessage extends BaseMassMessage {

	@Override
	public String toJsonByGroup() {
		String json = "{\"filter\":{\"group_id\":\"%s\"},\"voice\":{\"media_id\":\"%s\"},\"msgtype\":\"voice\"}";
		return String.format(json,
				getGroupId(),
				getMediaId());
	}

	@Override
	public String toJsonByOpenId() {
		String json = "{\"touser\":[%s],\"voice\":{\"media_id\":\"%s\"},\"msgtype\":\"voice\"}";
		return String.format(json,
				toJsonFromOpenIds(),
				getMediaId());
	}

}
