package com.dw.ccm.wechat.base.message.menu;

/**
 * Abstract - 菜单按钮
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public abstract class SubButton implements Button {

    /**
     * 菜单按钮的名称
     */
    private String name;

    /**
     * 菜单按钮的类型
     */
    public ButtonType type;

    /**
     * 设置菜单按钮的类型
     */
    public abstract void setButtonType();

    /**
     * 获取菜单按钮的名称
     *
     * @return 菜单按钮的名称
     */
    public String getName() {
        setButtonType();
        return name;
    }

    /**
     * 设置菜单按钮的名称<br/>
     * 注：一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替
     *
     * @param name 菜单按钮的名称
     */
    public void setName(String name) {
        setButtonType();
        this.name = name;
    }

    /**
     * 获取菜单按钮的类型
     *
     * @return 菜单按钮的类型
     */
    public ButtonType getType() {
        return type;
    }

    /**
     * 设置菜单按钮的类型
     *
     * @param type 菜单按钮的类型
     */
    public void setType(ButtonType type) {
        this.type = type;
    }
}
