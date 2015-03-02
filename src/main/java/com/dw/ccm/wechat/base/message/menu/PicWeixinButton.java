package com.dw.ccm.wechat.base.message.menu;

/**
 * 弹出微信相册发图器菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class PicWeiXinButton extends EventButton {

    /**
     * 实例化一个弹出微信相册发图器菜单按钮
     */
    public PicWeiXinButton() {}

    /**
     * 实例化一个弹出微信相册发图器菜单按钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public PicWeiXinButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.PIC_WEIXIN);
    }
}
