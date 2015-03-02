package com.dw.ccm.wechat.base.message.menu;

/**
 * 菜单按钮类型
 *
 * @author xingkong1221
 * @date 2015年3月2日
 */
public enum ButtonType {

    /** 点击推事件 */
    CLICK("click"),

    /** 跳转URL */
    VIEW("view"),

    /** 扫码推事件 */
    SCAN_CODE_PUSH("scancode_push"),

    /** 扫码推事件且弹出“消息接收中”提示框 */
    SCAN_CODE_WAIT_MSG("scancode_waitmsg"),

    /** 弹出系统拍照发图 */
    PIC_SYS_PHOTO("pic_sysphoto"),

    /** 弹出拍照或者相册发图 */
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),

    /** 弹出微信相册发图器 */
    PIC_WEIXIN("pic_weixin"),

    /** 弹出地理位置选择器 */
    LOCATION_SELECT("location_select");

    /** 按钮类型值 */
    private String label;

    ButtonType(String label) {
        this.label = label;
    }

    /**
     * 获取菜单按钮的类型标签
     *
     * @return 标签
     */
    public String getLabel() {
        return label;
    }
}
