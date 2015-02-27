package com.dw.ccm.wechat.base.message.template;

/**
 * 模板消息属性
 * 
 * @author xingkong1221
 * @date 2014年9月15日
 */
public class Attribute {
	
	/**
	 * 模板消息属性值
	 */
	private String value;
	
	/**
	 * 模板消息属性颜色
	 */
	private String color;
	
	/**
	 * 创建一个模板消息属性
	 */
	public Attribute() {}
	
	/**
	 * 创建一个模板消息属性
	 * @param value 模板消息属性值
	 * @param color 模板消息属性颜色
	 */
	public Attribute(String value, String color) {
		this.value = value;
		this.color = color;
	}

	/**
	 * 获取模板消息属性值
	 * @return 模板消息属性值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置模板消息属性值
	 * @param value 模板消息属性值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * 获取模板消息属性颜色
	 * @return 模板消息属性颜色
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 设置模板消息属性颜色
	 * <pre>
	 * 	attribute.setColor("#173177");
	 * </pre>
	 * @param color 模板消息属性颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}

}
