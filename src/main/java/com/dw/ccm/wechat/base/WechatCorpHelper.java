package com.dw.ccm.wechat.base;

import org.apache.http.util.Asserts;

import com.dw.ccm.wechat.base.exception.WechatException;
import com.dw.ccm.wechat.base.utils.weixin.AesException;
import com.dw.ccm.wechat.base.utils.weixin.WXBizMsgCrypt;

/**
 * 微信企业号工具类
 * 
 * @author xingkong1221
 * @date 2014年10月8日
 */
public class WechatCorpHelper {
	
	
	/**
	 * 获取微信企业号加密解密接口
	 * @param token 公众平台上，开发者设置的token
	 * @param corpId 企业的corpid
	 * @param encodingAesKey 公众平台上，开发者设置的EncodingAESKey
	 * @return 微信企业号加密解密接口
	 * @throws WechatException 实例化失败
	 */
	public static WXBizMsgCrypt getWXCrypt(String token, String corpId, String encodingAesKey) throws WechatException {
		Asserts.notBlank(token, "Token参数不能为空");
		Asserts.notBlank(corpId, "企业的corpid不能为空");
		Asserts.notBlank(encodingAesKey, "开发者设置的EncodingAESKey不能为空");
		try {
			return new WXBizMsgCrypt(token, encodingAesKey, corpId);
		} catch (AesException e) {
			throw new WechatException("实例化微信企业号加密解密接口失败", e);
		}
	}
	
}
