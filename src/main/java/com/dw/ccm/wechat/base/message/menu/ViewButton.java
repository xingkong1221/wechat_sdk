package com.dw.ccm.wechat.base.message.menu;

/**
 * View类型的菜单按钮
 */
public class ViewButton implements Button {

	/**
	 * 菜单的响应动作类型，目前有click、view两种类型
	 */
	public String type = "view";
	
	/**
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
	private String name;
	
	/**
	 * 网页链接，员工点击菜单可打开链接，不超过256字节
	 */
	private String url;
	
	public ViewButton() {}
	
	public ViewButton(String name, String url) {
		setName(name);
		setUrl(url);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
