package com.dw.ccm.wechat.base.message.menu;

/**
 * 扫码推事件菜单按钮
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class ScanCodePushButton extends EventButton {

    /**
     * 实例化一个扫码推事件菜单按钮
     */
    public ScanCodePushButton() {}

    /**
     * 实例化一个扫码推事件菜单按钮
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public ScanCodePushButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.SCAN_CODE_PUSH);
    }
}
