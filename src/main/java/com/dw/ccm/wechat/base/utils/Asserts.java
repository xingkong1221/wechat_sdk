package com.dw.ccm.wechat.base.utils;

/**
 * 断言
 * 
 * @author xingkong1221
 * @date 2014年6月25日
 */
public class Asserts {

	/**
	 * 对象不为空
	 * @param object 待检测对象
	 * @param msg 对象为空则抛出错误消息为 {@code msg} 的 {@code IllegalArgumentExcetpion} 异常
	 */
	public static void notNull(Object object, final String msg) {
		if (object == null)
			throw new IllegalArgumentException(msg);
	}

	/**
	 * 表达式值为真
	 *
	 * @param expression 表达式
	 * @param message 表达式值为假时抛出的错误消息
	 */
	public static void isTrue(boolean expression, String message) {
		if (!expression) {
			throw new IllegalArgumentException(message);
		}
	}
}
