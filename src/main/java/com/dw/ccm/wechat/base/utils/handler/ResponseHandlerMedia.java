package com.dw.ccm.wechat.base.utils.handler;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.dw.ccm.wechat.base.message.response.DownloadResponse;
import com.dw.ccm.wechat.base.utils.JsonUtils;

/**
 * HTTP请求媒体文件响应处理器<br>
 * 返回包含文件信息的 <code>DownloadResponse</code> 对象
 * @author xingkong1221
 * @date 2014年5月8日
 */
public class ResponseHandlerMedia implements ResponseHandler<DownloadResponse> {

	private static final Logger logger = Logger.getLogger(ResponseHandlerMedia.class);
	
	@Override
	public DownloadResponse handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		// 获取HTTP请求响应状态码
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode < 200 || statusCode >= 300) {
			// 请求未成功，下载失败
			logger.warn("请求未成功，下载文件失败 [ " + response.getStatusLine().toString() + " ]");
			return null;
		}
		// 获取响应实体
		HttpEntity entity = response.getEntity();
		if (entity == null) {
			// 请求成功，但是未响应任何内容
			logger.warn("请求成功，但是未响应任何内容 [ " + response.getStatusLine() + " ]");
			return null;
		}
		// 获取内容类型
		Header type = response.getFirstHeader("Content-Type");
		if ("text/plain".equals(type.getValue())) {
			// 文本消息，说明下载出错，解析错误信息，并返回
			return JsonUtils.fromJson(EntityUtils.toString(entity), DownloadResponse.class);
		}
		DownloadResponse download = new DownloadResponse();
		download.setContentType(type.getValue());
		Header[] headers = response.getAllHeaders();
		for (Header header : headers) {
			if ("Content-disposition".equals(header.getName())) {
				HeaderElement[] elements = header.getElements();
				for (HeaderElement element : elements) {
					NameValuePair pair = element.getParameterByName("filename");
					// 文件名
					download.setFilename(pair.getValue());
				}
			} else if ("Content-Length".equals(header.getName())) {
				// 文件大小
				download.setContentLength(header.getValue());
			}
		}
		download.setData(IOUtils.toByteArray(entity.getContent()));
		return download;
	}
}
