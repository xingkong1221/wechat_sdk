package com.dw.ccm.wechat.base.message.menu;

/**
 * 网页链接菜单按钮
 *
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class ViewButton extends SubButton {

    /** 网页链接 */
    private String url;

    /**
     * 实例化一个网页链接菜单按钮
     */
    public ViewButton() {}

    /**
     * 实例化一个网页链接菜单按钮
     *
     * @param name 菜单按钮名称
     * @param url 网页链接地址
     */
    public ViewButton(String name, String url) {
        setName(name);
        setUrl(url);
    }

    @Override
    public void setButtonType() {
        setType(ButtonType.VIEW);
    }

    /**
     * 设置网页链接，用户点击菜单可打开链接<br/>
     * 注：不超过256字节
     *
     * @return 网页链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 获取网页链接
     *
     * @param url 网页链接
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
