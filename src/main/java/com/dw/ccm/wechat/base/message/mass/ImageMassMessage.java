package com.dw.ccm.wechat.base.message.mass;

/**
 * 图片消息群发基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class ImageMassMessage extends BaseMassMessage {

	@Override
	public String toJsonByGroup() {
		String json = "{\"filter\":{\"group_id\":\"%s\"},\"image\":{\"media_id\":\"%s\"},\"msgtype\":\"image\"}";
		return String.format(json,
				getGroupId(),
				getMediaId());
	}

	@Override
	public String toJsonByOpenId() {
		String json = "{\"touser\":[%s],\"image\":{\"media_id\":\"%s\"},\"msgtype\":\"image\"}";
		return String.format(json,
				toJsonFromOpenIds(),
				getMediaId());
	}

}
