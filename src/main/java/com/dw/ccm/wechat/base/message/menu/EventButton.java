package com.dw.ccm.wechat.base.message.menu;

/**
 * Abstract - 事件菜单按钮
 *
 * <p>例如：点击推送事件，扫码推事件等等...</p>
 *
 * @author xingkong1221
 * @date 2015年3月2日
 */
public abstract class EventButton extends SubButton {

    /**
     * 事件菜单按钮的KEY值
     */
    private String key;

    protected EventButton() {}

    protected EventButton(String name, String key) {
        setName(name);
        setKey(key);
    }

    /**
     * 获取事件菜单按钮的KEY值
     *
     * @return 事件菜单按钮的KEY值
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置事件菜单按钮的KEY值
     *
     * @param key 事件菜单按钮的KEY值
     */
    public void setKey(String key) {
        this.key = key;
    }
}
