package com.dw.ccm.wechat.base.message.menu;

/**
 * 点击事件菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class ClickButton extends EventButton {

    /**
     * 实例化一个点击事件菜单按钮
     */
    public ClickButton() {}

    /**
     * 实例化一个点击事件按菜单钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public ClickButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.CLICK);
    }
}
