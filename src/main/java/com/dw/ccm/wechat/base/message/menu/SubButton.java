package com.dw.ccm.wechat.base.message.menu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * 二级菜单
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class SubButton implements Button {
	
	/**
	 * 菜单标题，不超过16个字节，子菜单不超过40个字节
	 */
	private String name;
	
	/**
	 * 二级菜单数组，个数应为1~5个
	 */
	@SerializedName("sub_button")
	private List<Button> subButton;

    public SubButton() {
        subButton = new ArrayList<Button>(5);
    }

    /**
     * 添加子菜单
     * @param button 子菜单
     * @return 二级菜单集合
     */
    public SubButton add(Button button) {
        subButton.add(button);
        return this;
    }

    /**
     * 实例化一个二级菜单数组
     *
     * @param name 二级菜单名称
     */
    public SubButton(String name) {
        this.name = name;
        subButton = new ArrayList<Button>(5);
    }

    /**
	 * 获取二级菜单名称
	 * @return 二级菜单名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置二级菜单名称
	 * @param name 二级菜单名称
	 */
	public void setName(String name) {
		this.name = name;
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
