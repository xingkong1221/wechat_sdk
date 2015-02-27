package com.dw.ccm.wechat.base.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON 工具类
 * 
 * @author xingkong1221
 * 
 * @date 2014-3-10 上午7:32:06
 * @modify 2014-3-19 上午10:18:51
 *
 */
public class JsonUtils {
	
	/**
	 * 将目标对象转化成 JSON 串
	 * 
	 * @param src	目标对象
	 * @return String	JSON 串
	 */
	public static String toJson(Object src) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(src);
	}
	
	/**
	 * 将 JSON 串转化成目标对象
	 * 
	 * @param json	能够产生 JSON 串的 Reader
	 * @param classOfT	目标对象类型
	 * @return T	目标对象
	 */
	public static <T> T fromJson(Reader json, Class<T> classOfT) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, classOfT);
	}
	
	/**
	 * 将 JSON 串转化成目标对象（默认UTF-8）
	 * 
	 * @param json JSON 串
	 * @param classOfT 	目标对象类型
	 * @return T 	目标对象
	 *
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		Charset charset = Charset.forName("UTF-8");
		return fromJson(json, classOfT, charset);
	}
	
	/**
	 * 将 JSON 串转化成目标对象
	 * 
	 * @param json	JSON 串
	 * @param classOfT	目标对象类型
	 * @param charset 	编码
	 * @return T 	目标对象
	 *
	 */
	public static <T> T fromJson(String json, Class<T> classOfT, Charset charset) {
		InputStream in = new ByteArrayInputStream(json.getBytes(charset));
		Reader reader = new InputStreamReader(in, charset);
		return fromJson(reader, classOfT);
	}
	
	/**
	 * 将JSON串转化成Map对象
	 * @param json Json字符串
	 * @return 返回解析后的Map对象
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> fromJson(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject(json);
		Iterator<String> iterator = jsonObject.keys();
		String key = null;
		Object value = null;
		while (iterator.hasNext()) {
			key = (String) iterator.next();
			value = jsonObject.get(key);
			map.put(key, value);
		}
		return map;
	}
}
