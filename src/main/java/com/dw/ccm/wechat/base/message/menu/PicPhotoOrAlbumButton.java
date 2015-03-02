package com.dw.ccm.wechat.base.message.menu;

/**
 * 弹出拍照或者相册发图菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class PicPhotoOrAlbumButton extends EventButton {

    /**
     * 实例化一个弹出拍照或者相册发图菜单按钮
     */
    public PicPhotoOrAlbumButton() {}

    /**
     * 实例化一个弹出拍照或者相册发图菜单按钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public PicPhotoOrAlbumButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.PIC_PHOTO_OR_ALBUM);
    }
}
