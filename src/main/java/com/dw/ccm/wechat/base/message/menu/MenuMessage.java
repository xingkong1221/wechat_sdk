package com.dw.ccm.wechat.base.message.menu;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用菜单
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class MenuMessage {
	
	/**
	 * 一级菜单
	 */
	private List<Button> buttonList;

    public MenuMessage() {
        buttonList = new ArrayList<Button>(3);
    }

    /**
     * 添加菜单
     * @param button 菜单
     * @return 菜单集合对象
     */
    public MenuMessage add(Button button) {
        buttonList.add(button);
        return this;
    }

    /**
	 * 获取一级菜单
	 * @return 一级菜单
	 */
	public List<Button> getButtonList() {
		return buttonList;
	}

	/**
	 * 设置一级菜单
	 * @param buttonList 一级菜单
	 */
	public void setButtonList(List<Button> buttonList) {
		this.buttonList = buttonList;
	}

    /**
     * 序列化为json字符串
     *
     * @return json字符串
     */
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder().disableHtmlEscaping();
        gsonBuilder.registerTypeAdapter(ActionButton.ButtonType.class, new EnumSerializer());
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }

    public class EnumSerializer implements JsonSerializer<ActionButton.ButtonType> {
        @Override
        public JsonElement serialize(ActionButton.ButtonType src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getLabel());
        }
    }
	
}
