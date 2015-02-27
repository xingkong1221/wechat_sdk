package com.dw.ccm.wechat.base.utils.handler;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.dw.ccm.wechat.base.utils.HttpUtils;

/**
 * HTTP请求字符串响应处理器<br>
 * 将HTTP响应内容转换成字符串并返回，若HTTP状态码为2xx，则请求成功，返回响应内容，否则返回null
 * 
 * @author xingkong1221
 * @date 2014年5月7日
 */
public class ResponseHandlerString implements ResponseHandler<String>{
	
	private static final Logger logger = Logger.getLogger(ResponseHandlerString.class);
	
	@Override
	public String handleResponse(HttpResponse response) throws ClientProtocolException,
			IOException {
		// HTTP状态码
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode >= 200 && statusCode < 300) {
			// 2xx表示请求成功
			HttpEntity entity = response.getEntity();
			return entity != null ? EntityUtils.toString(entity, HttpUtils.DEFAULT_CHARSET) : null;
		}
		// 请求失败
		logger.warn("请求响应状态异常： [" + response.getStatusLine().toString() + "]");
		return null;
	}

}
