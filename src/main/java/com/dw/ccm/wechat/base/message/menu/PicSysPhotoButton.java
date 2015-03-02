package com.dw.ccm.wechat.base.message.menu;

/**
 * 弹出系统拍照发图菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class PicSysPhotoButton extends EventButton {

    /**
     * 实例化一个弹出系统拍照发图菜单按钮
     */
    public PicSysPhotoButton() {}

    /**
     * 实例化一个弹出系统拍照发图菜单按钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public PicSysPhotoButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.PIC_SYS_PHOTO);
    }
}
