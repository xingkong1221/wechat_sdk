package com.dw.ccm.wechat.base.utils;

import com.dw.ccm.wechat.base.message.response.DownloadResponse;
import com.dw.ccm.wechat.base.message.response.UploadResponse;
import com.dw.ccm.wechat.base.utils.handler.ResponseHandlerMedia;
import com.dw.ccm.wechat.base.utils.handler.ResponseHandlerString;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * HTTP工具类
 * 
 * @author xingkong1221
 * @date 2014年5月7日
 */
public class HttpUtils {
	
	/**
	 * 默认字符编码（UTF-8）
	 */
	public static final Charset DEFAULT_CHARSET = Consts.UTF_8;
	
	/**
	 * 默认传输超时时间（单位：毫秒）
	 */
	private static final int DEFAULT_SOCKET_TIMEOUT = 5000;
	
	/**
	 * 默认连接超时时间（单位：毫秒）
	 */
	private static final int DEFAULT_CONNECT_TIMEOUT = 6000;

	/**
	 * 发送一个GET请求<br>
	 * 将请求响应的内容转换成字符串返回
	 * @param url 请求地址
	 * @return 请求成功返回响应的字符串，失败返回 <code>null</code>
	 */
	public static String get(String url) {
		// 创建一个GET请求方法
		HttpGet httpGet = new HttpGet(url);
		// 字符串响应处理器
		ResponseHandlerString handler = new ResponseHandlerString();
		return execute(httpGet, handler);
	}
	
	/**
	 * 发送一个GET请求<br>
	 * 将请求响应的JSON串反序列化为指定的对象T
	 * @param url 请求地址
	 * @param clazz 指定对象 <code>T</code> 的 <code>Class</code> 类型
	 * @return 成功返回指定的对象，失败返回 <code>null</code>
	 */
	public static <T> T get(String url, Class<T> clazz) {
		// 发送GET请求
		String result = get(url);
		if (result == null) {
			return null;
		}
		return JsonUtils.fromJson(result, clazz);
	}
	
	/**
	 * 发送一个POST请求<br>
	 * 将请求响应的内容转换成字符串返回
	 * @param url 请求地址
	 * @param raw 请求参数
	 * @return 请求成功返回响应的字符串，失败返回 <code>null</code>
	 */
	public static String post(String url, String raw) {
		// 创建一个POST请求方法
		HttpPost httpPost = new HttpPost(url);
		// 字符串实体对象
		StringEntity entity = new StringEntity(raw, DEFAULT_CHARSET);
		httpPost.setEntity(entity);
		// 字符串响应处理器
		ResponseHandlerString handler = new ResponseHandlerString();
		return execute(httpPost, handler);
	}

    /**
     * 发送一个POST请求
     *
     * @param url 请求地址
     * @param param 请求参数
     * @return 请求成功返回相应的字符串
     */
    public static String post(String url, Map<String, String> param) {
        List<NameValuePair> postParams = new LinkedList<NameValuePair>();
        if (param != null && !param.isEmpty()) {
            Iterator<Map.Entry<String, String>> iterator = param.entrySet().iterator();
            Map.Entry<String, String> entry = null;
            while (iterator.hasNext()) {
                entry = iterator.next();
                postParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(postParams, DEFAULT_CHARSET));
        ResponseHandlerString handler = new ResponseHandlerString();
        return execute(post, handler);
    }
	
	/**
	 * 发送一个POST请求<br>
	 * 将请求响应的内容反序列化为指定的对象T
	 * @param url 请求地址
	 * @param raw 请求参数
	 * @param clazz 指定对象 <code>T</code> 的 <code>Class</code> 类型
	 * @return
	 */
	public static <T> T post(String url, String raw, Class<T> clazz) {
		// 发送POST请求
		String result = post(url, raw);
		if (result == null) {
			return null;
		}
		return JsonUtils.fromJson(result, clazz);
	}
	
	/**
	 * 上传一个文件<br>
	 * 将上传响应的内容反序列化为 <code>UploadResponse</code> 对象
	 * @param url 上传地址
	 * @param data 待上传的文件
	 * @return HTTP请求成功，返回一个 <code>UploadResponse</code> 对象，请求失败返回 <code>null</code>
	 */
	public static UploadResponse upload(String url, byte[] data, String filename) {
		// 创建一个POST请求
		HttpPost httpPost = new HttpPost(url);
		HttpEntity entity = MultipartEntityBuilder.create()
				.addPart("media", new ByteArrayBody(data, filename))
				.build();
		httpPost.setEntity(entity);
		// 字符串响应处理器
		ResponseHandlerString handler = new ResponseHandlerString();
		String result = execute(httpPost, handler);
		if (result == null) {
			return null;
		}
		return JsonUtils.fromJson(result, UploadResponse.class);
	}
	
	/**
	 * 下载一个文件
	 * @param url 下载地址
	 * @return 返回一个包含下载信息的 <code>DownloadResponse</code> 对象
	 */
	public static DownloadResponse download(String url) {
		HttpGet httpGet = new HttpGet(url);
		ResponseHandlerMedia handler = new ResponseHandlerMedia();
		return execute(httpGet, handler);
	}
	
	/**
	 * 执行一次HTTP请求
	 * @param <T>
	 * @param request 请求对象（GET, POST， PUT）
	 */
	private static <T> T execute(HttpRequestBase request, ResponseHandler<? extends T> responseHandler) {
		// 设置请求配置
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
				.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
				.build();
		request.setConfig(requestConfig);
		try {
			return initHttpClient().execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			throw new RuntimeException("HTTP协议错误，请求URI[ " + request.getURI() + " ]", e);
		} catch (IOException e) {
			throw new RuntimeException("I/O错误", e);
		}
	}
	
	/**
	 * 创建一个 <code>CloseableHTTPClient</code> 对象
	 * @return 成功返回一个 <code>CloseableHttpClient</code>
	 */
	private static CloseableHttpClient initHttpClient() {
        /*try {
            SSLContext sslContext = SSLContexts.custom().useTLS().build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }


*/
        return HttpClients.createDefault();
        /*SSLContext sslContext = SSLContexts.createSystemDefault();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        return HttpClients.custom().setSSLSocketFactory(sslsf).build();*/
	}
}
