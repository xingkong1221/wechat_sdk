package com.dw.ccm.wechat.base.message.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 菜单响应对象
 * 
 * @author xingkong1221
 * @date 2014年5月9日
 */
public class MenuResponse extends BaseResponse {
	
	private Menu menu;
	
	public static class Menu {
		/**
		 * 一级菜单数组，个数应为1~3个
		 */
		private List<Button> button;

		public List<Button> getButton() {
			return button;
		}

		public void setButton(List<Button> button) {
			this.button = button;
		}
	}
	
	public static class Button {
		
		/**
		 * 菜单的响应动作类型，目前有click、view两种类型
		 */
		private String type;
		
		/**
		 * 菜单标题，不超过16个字节，子菜单不超过40个字节
		 */
		private String name;
		
		/**
		 * 菜单KEY值，用于消息接口推送，不超过128字节
		 */
		private String key;
		
		/**
		 * 网页链接，用户点击菜单可打开链接，不超过256字节
		 */
		private String url;
		
		/**
		 * 二级菜单数组，个数应为1~5个
		 */
		@SerializedName("sub_button")
		private List<Button> subButton;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<Button> getSubButton() {
			return subButton;
		}

		public void setSubButton(List<Button> subButton) {
			this.subButton = subButton;
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
