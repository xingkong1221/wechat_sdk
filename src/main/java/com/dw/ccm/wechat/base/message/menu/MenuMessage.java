package com.dw.ccm.wechat.base.message.menu;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 公众号菜单
 * 
 * @author xingkong1221
 * @date 2014年9月29日
 */
public class MenuMessage {
	
	/**
	 * 一级菜单集合
	 */
    @SerializedName("button")
	private List<Button> buttonList;

    /**
     * 实例化一个公众号菜单
     */
    public MenuMessage() {
        buttonList = new ArrayList<Button>(3);
    }

    /**
     * 添加菜单
     *
     * @param button 菜单
     * @return 菜单集合对象
     */
    public MenuMessage addButton(Button button) {
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
     * 序列化为json字符串
     *
     * @return json字符串
     */
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder().disableHtmlEscaping();
        gsonBuilder.registerTypeAdapter(ButtonType.class, new EnumSerializer());
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }

    public class EnumSerializer implements JsonSerializer<ButtonType> {
        @Override
        public JsonElement serialize(ButtonType src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getLabel());
        }
    }
	
}
