package com.dw.ccm.wechat.base.message.menu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单组（一级菜单）
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class ButtonGroup extends Button {
	
	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	@SerializedName("sub_button")
	private List<Button> subButtonList;

    public ButtonGroup() {
        subButton = new ArrayList<Button>(5);
    }

    /**
     * 添加子菜单
     * @param button 子菜单
     * @return 二级菜单集合
     */
    public ButtonGroup add(Button button) {
        subButton.add(button);
        return this;
    }

    /**
     * 实例化一个二级菜单数组
     *
     * @param name 二级菜单名称
     */
    public ButtonGroup(String name) {
        setName(name);
        subButton = new ArrayList<Button>(5);
    }


	
	/**
	 * 获取二级菜单按钮
	 * @return 二级菜单按钮
	 */
	public List<Button> getSubButton() {
		return subButton;
	}

	/**
	 * 设置二级菜单按钮
	 * @param subButton 二级菜单按钮
	 */
	public void setSubButton(List<Button> subButton) {
		this.subButton = subButton;
	}
}
