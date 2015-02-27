package com.dw.ccm.wechat.base.message.template;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 模板消息
 * 
 * @author xingkong1221
 * @date 2014年9月15日
 */
public class TemplateMessage {
	
	/**
	 * 模板消息 {@code JSON} 模板
	 */
	private static final String TEMPLATE_JSON = "{\"touser\":\"%s\",\"template_id\":\"%s\",\"url\":\"%s\",\"topcolor\":\"%s\",\"data\":{%s}}";
	
	/**
	 * 模板消息属性 {@code JSON} 模板
	 */
	private static final String TEMPLATE_ATTRIBUTE_JSON = "\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}";
	
	/**
	 * 接收方帐号
	 */
	private String toUser;

	/**
	 * 模板消息模板编号
	 */
	private String templateId;
	
	/**
	 * 模板消息跳转地址
	 */
	private String url;
	
	/**
	 * 模板消息颜色
	 */
	private String topColor;
	
	/**
	 * 模版消息属性
	 */
	private HashMap<String, Attribute> attributes = new HashMap<String, Attribute>();
	
	/**
	 * 将模板消息序列化为 {@code JSON} 字符串
	 * @return {@code JSON} 字符串
	 */
	public String toJson() {
		/**
		 * 遍历属性替换属性JSON字符串
		 */
		StringBuilder attributeBuilder = new StringBuilder(200);
		Set<Entry<String, Attribute>> entrys = attributes.entrySet();
		Iterator<Entry<String, Attribute>> iterator = entrys.iterator();
		while (iterator.hasNext()) {
			Entry<String, Attribute> entry = iterator.next();
			attributeBuilder.append(
					String.format(TEMPLATE_ATTRIBUTE_JSON, 
							entry.getKey(), 
							entry.getValue().getValue(), 
							entry.getValue().getColor()));
			if (iterator.hasNext()) {
				attributeBuilder.append(",");
			}
		}
		return String.format(TEMPLATE_JSON, 
				getToUser(),
				getTemplateId(),
				getUrl(),
				getTopColor(),
				attributeBuilder.toString());
	}

	/**
	 * 获取接收方帐号
	 * @return 接收方帐号
	 */
	public String getToUser() {
		return toUser;
	}

	/**
	 * 设置接收方帐号
	 * @param toUser 接收方帐号
	 */
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	/**
	 * 获取模板消息模版编号
	 * @return 模板消息模版编号
	 */
	public String getTemplateId() {
		return templateId;
	}

	/**
	 * 设置模板消息模板编号
	 * @param templateId 模板消息模版编号
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * 获取模板消息跳转地址
	 * @return 模板消息跳转地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置模板消息跳转地址
	 * @param url 模板消息跳转地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取模板消息颜色
	 * @return 模板消息颜色
	 */
	public String getTopColor() {
		return topColor;
	}

	/**
	 * 设置模板消息颜色
	 * @param topColor 模板消息颜色
	 */
	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}

	/**
	 * 获取模板消息属性
	 * @return 模板消息属性
	 */
	public HashMap<String, Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * 添加模板消息属性
	 * @param name 模板消息名称
	 * @param attribute 模板消息属性
	 * @return 模板消息
	 */
	public TemplateMessage addAttribute(String name, Attribute attribute) {
		attributes.put(name, attribute);
		return this;
	}

	/**
	 * 设置模板消息属性
	 * @param attributes 模板消息属性
	 */
	public void setAttributes(HashMap<String, Attribute> attributes) {
		this.attributes = attributes;
	}
}
