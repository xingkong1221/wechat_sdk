package com.dw.ccm.wechat.base.message.mass;

/**
 * 群发图文消息基础对象
 * 
 * @author xingkong1221
 * @date 2014年5月21日
 */
public class NewsMassMessage extends BaseMassMessage {

	@Override
	public String toJsonByGroup() {
		String json = "{\"filter\":{\"group_id\":\"%s\"},\"mpnews\":{\"media_id\":\"%s\"},\"msgtype\":\"mpnews\"}";
		return String.format(json,
				getGroupId(),
				getMediaId());
	}

	@Override
	public String toJsonByOpenId() {
		String json = "{\"touser\":[%s],\"mpnews\":{\"media_id\":\"%s\"},\"msgtype\":\"mpnews\"}";
		return String.format(json,
				toJsonFromOpenIds(),
				getMediaId());
	}

}
