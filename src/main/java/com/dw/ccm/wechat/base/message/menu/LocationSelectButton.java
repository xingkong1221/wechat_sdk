package com.dw.ccm.wechat.base.message.menu;

/**
 * 弹出地理位置选择器菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class LocationSelectButton extends EventButton {

    /**
     * 实例化一个弹出地理位置选择器菜单按钮
     */
    public LocationSelectButton() {}

    /**
     * 实例化一个弹出地理位置选择器菜单按钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public LocationSelectButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.LOCATION_SELECT);
    }
}


