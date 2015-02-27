package com.dw.ccm.wechat.base.message.menu;

/**
 * 动作按钮
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class ActionButton implements Button {

    /**
     * 按钮类型
     */
    public enum ButtonType {
        /** 点击推事件 */
        CLICK("click"),

        /** 扫码推事件 */
        SCAN_CODE_PUSH("scancode_push"),

        /** 扫码推事件且弹出“消息接收中”提示框 */
        SCAN_CODE_WAIT_MSG("scancode_waitmsg"),

        /** 弹出系统拍照发图 */
        PIC_SYS_PHOTO("pic_sysphoto"),

        /** 弹出拍照或者相册发图 */
        PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),

        /** 弹出微信相册发图器 */
        PC_WEIXIN("pic_weixin"),

        /** 弹出地理位置选择器 */
        LOCATION_SELECT("location_select");

        /** 按钮类型值 */
        private String label;

        ButtonType(String label) {
            this.label = label;
        }

        /**
         * 获取按钮类型值
         *
         * @return 按钮类型值
         */
        public String getLabel() {
            return label;
        }
    }

	
	/**
	 * 菜单的响应动作类型，目前有click、view两种类型
	 */
	public ButtonType type;
	
	/**
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
	private String name;
	
	/**
	 * 菜单KEY值，用于消息接口推送，不超过128字节
	 */
	private String key;

    /**
     * 实例化一个按钮
     *
     * @param type 按钮类型
     */
	public ActionButton(ButtonType type) {
        this.type = type;
    }

    /**
     * 实例化一个按钮
     *
     * @param type 按钮类型
     * @param name 按钮名称
     * @param key 按钮键值
     */
	public ActionButton(ButtonType type, String name, String key) {
        this.type = type;
		setName(name);
		setKey(key);
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

    public ButtonType getType() {
        return type;
    }

    public void setType(ButtonType type) {
        this.type = type;
    }
}
