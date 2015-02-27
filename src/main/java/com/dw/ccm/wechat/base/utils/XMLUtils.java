package com.dw.ccm.wechat.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * XML 文档解析工具类
 * 
 * @author xingkong1221
 * 
 * @date 2014-3-10 上午8:24:22
 * @modify 2014-5-7 上午10:53:58
 *
 */
public class XMLUtils {
	
	private static final Logger logger =  Logger.getLogger(XMLUtils.class);
	
	/**
	 * 将XML流转换成Map<String, String>（只支持一级元素）
	 * @param in XML流
	 * @return map 返回存放解析后的XML数据的Map
	 *
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> toMap(InputStream in) {
		if (in == null) {
			throw new NullPointerException("InputStream is null!");
		}
		Map<String, String> map = new HashMap<String, String>();
		// 创建 SAXReader 读取器，读取 XML 文档
		SAXReader reader = new SAXReader();
		// 读取 InputStream 流，获取文档对象
		Document document = null;
		try {
			document = reader.read(in);
		} catch (DocumentException e) {
			logger.error("XML解析出错", e);
		}
		// 获取根节点
		Element root = document.getRootElement();
		// 获取根节点下面的子元素
		List<Element> elementList = root.elements();
		// 遍历根节点所有的子元素，并将其放入 map 中
		for (Element element : elementList) {
			map.put(element.getName(), element.getText());
		}
		try {
			in.close();
		} catch (IOException e) {
			logger.error(e);
		}
		return map;
	}
	
	/**
	 * 将指定的XML字符串反序列化为一个对象
	 * @param xml
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromXML(String xml, Class<T> clazz) {
		XStream xstream = new XStream(new XppDriver());
		xstream.autodetectAnnotations(true);
		xstream.alias("xml", clazz);
		return (T) xstream.fromXML(xml);
	}
	
}
