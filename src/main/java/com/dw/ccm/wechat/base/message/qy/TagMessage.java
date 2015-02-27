package com.dw.ccm.wechat.base.message.qy;

import java.util.List;

import com.dw.ccm.wechat.base.utils.JsonUtils;

/**
 * 标签消息
 * 
 * @author xingkong1221
 * @date 2014年9月25日
 */
public class TagMessage {

	public enum Type {
		/** 创建 */
		create,
		/** 更新 */
		update,
		/** 新增 */
		add,
		/** 删除 */
		deleteuser
	}
	
	/**
	 * 标签名称。长度为1~64个字符，标签不可与其他同组的标签重名，也不可与全局标签重名
	 */
	private String tagname;
	
	/**
	 * 标签ID
	 */
	private String tagid;
	
	/**
	 * 企业员工ID列表
	 */
	private List<String> userlist;
	
	/**
	 * 将对象序列化为JSON字符串
	 * @param type 类型
	 * @return JSON字符串
	 */
	public String getJson(Type type) {
		if (type.equals(Type.create)) {
			String json = "{\"tagname\": \"%s\"}";
			return String.format(json, tagname);
		} else if (type.equals(Type.update)) {
			String json = "{\"tagid\": \"%s\",\"tagname\": \"%s\"}";
			return String.format(json, tagid, tagname);
		} else if (type.equals(Type.add)) {
			String json = "{\"tagid\": \"%s\",\"userlist\":%s}";
			return String.format(json, tagid, JsonUtils.toJson(userlist));
		} else {
			String json = "{\"tagid\": \"%s\",\"userlist\":%s}";
			return String.format(json, tagid, JsonUtils.toJson(userlist));
		}
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagid) {
		this.tagid = tagid;
	}

	public List<String> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<String> userlist) {
		this.userlist = userlist;
	}
	
}
