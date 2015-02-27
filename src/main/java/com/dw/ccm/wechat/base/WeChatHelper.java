package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.InMessage;
import com.dw.ccm.wechat.base.message.response.AccessTokenResponse;
import com.dw.ccm.wechat.base.utils.XMLUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * 微信公众平台基础框架功能封装接口实现
 * 
 * @author xingkong1221
 * @date 2014年6月23日
 */
public class WeChatHelper {
	
	/**
	 * 获取微信公众平台基础接口
	 * 
	 * @param accessToken 接口调用凭证
	 * @return 返回 {@code WeChat} 接口实例
	 */
	public static WeChat getWeChat(String accessToken) {
		return WeChatImpl.getInstance(accessToken, null);
	}

	/**
	 * 获取微信公众平台基础接口
	 *
	 * @param accessToken 接口调用平台
	 * @param interceptor 响应消息拦截器
	 * @return 返回 {@code WeChat} 接口实例
	 */
	public static WeChat getWeChat(String accessToken, ResponseInterceptor interceptor) {return WeChatImpl.getInstance(accessToken, interceptor);}
	
	/**
	 * 根据微信公众号的 {@code app_id} 和 {@code app_secret} 获取  {@code access_token}.<br>
	 * {@code access_token} 是公众号的全局唯一票据，公众号调用各接口时都需使用 {@code access_token}
	 * <p>注：该方法为静态方法，无需实例，可直接调用</p>
	 * @param appId 第三方用户唯一凭证
	 * @param appSecret 第三方用户唯一凭证密钥，即appSecret
	 * @return 成功返回 {@code AccessTokenResponse} 对象，若在接口调用的过程中产生错误，则错误信息也会包含在该对象中，若HTTP请求异常，则返回 {@code null}
	 */
	public static AccessTokenResponse getAccessToken(String appId, String appSecret) {
		return WeChatImpl.getInstance(null, null).getAccessToken(appId, appSecret);
	}
	
	/**
	 * 通过 {@code ticket} 换取二维码地址
	 * @param ticket 二维码 {@code ticket} 
	 * @return 二维码图片地址
	 */
	public static String getQrCode(String ticket) {
		return WeChatImpl.getInstance(null, null).getQrCode(ticket);
	}
	
	/**
	 * 验证微信消息的真实性
	 * @param token	开发者填写的 {@code token} 参数
	 * @param signature	微信加密签名，{@code signature} 结合了开发者填写的 {@code token} 参数和请求中的 {@code timestamp} 参数、 {@code nonce} 参数
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return 验证通过返回 {@code true}， 否则返回 {@code false}
	 *
	 */
	public static boolean checkSignature(String token, String signature, 
			String timestamp, String nonce) {
		String[] array = new String[] {token, timestamp, nonce};
		Arrays.sort(array);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(array[i]);
		}
		return DigestUtils.shaHex(sb.toString()).equals(signature);
	}
	
	/**
	 * 将 {@code XML} 字符串解析成 {@code InMessage} 对象
	 * @param xml 待解析的 {@code XML} 字符串
	 * @return 成功返回 {@code InMessage} 对象
	 */
	public static InMessage toInMessage(String xml) {
		return XMLUtils.fromXML(xml, InMessage.class);
	}
	
	/**
	 * 将 {@code InputStream} 解析成 {@code InMessage} 对象
	 * @param in {@code InputStream} 对象
	 * @return 返回 {@code InMessage} 对象
	 */
	public static InMessage toInMessage(InputStream in) {
		String xml = null;
		try {
			xml = IOUtils.toString(in, "UTF-8");
		} catch (IOException e) {
			throw new RuntimeException("InputStream 转换成字符串失败", e);
		}
		if (!xml.startsWith("<xml>")) {
			throw new RuntimeException("InputStream 中没有 XML 消息");
		}
		return toInMessage(xml);
	}
	
}
