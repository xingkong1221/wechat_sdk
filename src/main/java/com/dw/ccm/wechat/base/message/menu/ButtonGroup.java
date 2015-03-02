package com.dw.ccm.wechat.base.message.menu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 一级菜单
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class ButtonGroup implements Button {

    /**
     * 菜单按钮的名称
     */
    private String name;

	/**
	 * 菜单按钮集合，个数应为1~5个
	 */
	@SerializedName("sub_button")
	private List<SubButton> subButtonList;

    /**
     * 实例化一个一级菜单
     */
    public ButtonGroup() {
        subButtonList = new ArrayList<SubButton>(5);
    }

    /**
     * 实例化一个一级菜单
     *
     * @param name 一级菜单名称
     */
    public ButtonGroup(String name) {
        setName(name);
        subButtonList = new ArrayList<SubButton>(5);
    }

    /**
     * 向一级菜单中添加二级菜单（菜单按钮）
     *
     * @param button 二级菜单（菜单按钮）
     * @return 二级菜单集合
     */
    public ButtonGroup addButton(SubButton button) {
        subButtonList.add(button);
        return this;
    }

	/**
	 * 获取一级菜单按钮集合
     *
	 * @return 一级菜单按钮集合
	 */
	public List<SubButton> getSubButton() {
		return subButtonList;
	}

    /**
     * 获取菜单按钮的名称
     *
     * @return 菜单按钮的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单按钮的名称<br/>
     * 注：一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替
     *
     * @param name 菜单按钮的名称
     */
    public void setName(String name) {
        this.name = name;
    }
}
