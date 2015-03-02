package com.dw.ccm.wechat.base.message.menu;

/**
 * 扫码推事件菜单按钮，并且会弹出“消息接收中”提示框
 *
 * @author xingkong1221
 * @date 2015年03月02日
 */
public class ScanCodeWaitMsgButton extends EventButton{

    /**
     * 实例化一个扫码推事件菜单按钮，并且会弹出“消息接收中”提示框
     */
    public ScanCodeWaitMsgButton() {}

    /**
     * 实例化一个扫码推事件菜单按钮，并且会弹出“消息接收中”提示框
     *
     * @param name 菜单按钮名称
     * @param key 菜单按钮KEY值
     */
    public ScanCodeWaitMsgButton(String name, String key) {
        super(name, key);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.SCAN_CODE_WAIT_MSG);
    }
}
