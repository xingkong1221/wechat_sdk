package com.dw.ccm.wechat.base;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dw.ccm.wechat.base.exception.WeChatException;
import com.dw.ccm.wechat.base.message.response.smartbind.CallbackUrlResponse;
import com.dw.ccm.wechat.base.message.response.smartbind.LoginResponse;
import com.dw.ccm.wechat.base.message.response.smartbind.StartDevModeResponse;
import com.dw.ccm.wechat.base.message.response.smartbind.WechatAccount;
import com.dw.ccm.wechat.base.utils.Asserts;
import com.dw.ccm.wechat.base.utils.JsonUtils;

/**
 * 微信公众平台智能绑定
 * 
 * @author xingkong1221
 * @date 2014年7月3日
 */
/**
 * 
 * @author xingkong1221
 * @date 2014年7月4日
 */
public class WechatSmartBinder {
	
	private static final Logger logger = Logger.getLogger(WechatSmartBinder.class);
	
	/**
	 * 默认传输超时时间（单位：毫秒）
	 */
	private static final int DEFAULT_SOCKET_TIMEOUT = 4500;
	
	/**
	 * 默认连接超时时间（单位：毫秒）
	 */
	private static final int DEFAULT_CONNECT_TIMEOUT = 4500;
	
	/**
	 * 默认字符集
	 */
	private static final Charset DEFAULT_CHARSET = Consts.UTF_8;
	
	/**
	 * 微信公众平台登录地址
	 */
	private static final String LOGIN_ADDR = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";
	
	/**
	 * 微信公众号设置界面
	 */
	private static final String ACCOUNT_SETTING_ADDR = "https://mp.weixin.qq.com/cgi-bin/settingpage?t=setting/index&action=index&token=%s&lang=zh_CN";
	
	/**
	 * 开发者中心
	 */
	private static final String ADVANCED_ADDR = "https://mp.weixin.qq.com/advanced/advanced?action=dev&t=advanced/dev&token=%s&lang=zh_CN";
	
	/**
	 * 设置接受微信消息推送的URL地址
	 */
	private static final String CALLBACK_URL_ADDR = "https://mp.weixin.qq.com/advanced/callbackprofile?t=ajax-response&token=%s&lang=zh_CN";
	
	/**
	 * 启动开发者模式的地址
	 */
	private static final String START_DEV_MODE_ADDR = "https://mp.weixin.qq.com/misc/skeyform";
	
	/**
	 * 启动开发者模式的 {@code referer}
	 */
	private static final String START_DEV_MODE_REFERER = "https://mp.weixin.qq.com/advanced/advanced?action=dev&t=advanced/dev&token=%s&lang=zh_CN";
	
	/**
	 * 登录邮箱
	 */
	private String email;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 微信公众平台 {@code URL} 参数中的 {@code token}
	 */
	private Integer tokenParam;
	
	/**
	 * 接受微信消息推送的 {@code URL}
	 */
	private String url;
	
	/**
	 * 验证微信消息签名的 {@code token}
	 */
	private String token;

	private CloseableHttpClient httpClient;
	
	/**
	 * 构造一个新的智能绑定对象，实现微信公众帐号开发模式中的 {@code URL} 智能绑定
	 * @param email 登录邮箱
	 * @param password 登录密码
	 * @param url 接受微信消息推送的 {@code URL}
	 * @param token 验证微信消息签名的 {@code token}
	 */
	public WechatSmartBinder(String email, String password, String url, String token) {
		Asserts.notNull(email, "登录邮箱不能为空");
		Asserts.notNull(password, "登录密码不能为空");
		Asserts.notNull(url, "微信消息推送URL不能为空");
		Asserts.notNull(token, "微信消息推送token不能为空");
		
		System.setProperty ("jsse.enableSNIExtension", "false");
		
		// 初始化
		this.email 		= email;
		this.password 	= password;
		this.url 		= url;
		this.token 		= token;
		this.httpClient = initHttpClient();
	}

	
	/**
	 * 登录到微信服务器
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException
	 */
	protected void login() throws WeChatException {
		logger.info("微信公众平台登录中...");
		
		// 设置登录参数
		List<NameValuePair> loginParams = new ArrayList<NameValuePair>();
		loginParams.add(new BasicNameValuePair("username", email));
		loginParams.add(new BasicNameValuePair("pwd", DigestUtils.md5Hex(password)));
		loginParams.add(new BasicNameValuePair("imgcode", ""));
		loginParams.add(new BasicNameValuePair("f", "json"));
		
		// 创建POST方法，并绑定登录参数
		HttpPost post = new HttpPost(LOGIN_ADDR);
		post.setHeader("Referer", "https://mp.weixin.qq.com/");
		post.setEntity(new UrlEncodedFormEntity(loginParams, DEFAULT_CHARSET));
		
		// 登录返回内容
		LoginResponse response = execute(post, LoginResponse.class);
		if (response.getBaseResp().getRet() != 0) {
			logger.info("登录微信公众平台失败!");
			throw new WeChatException("智能绑定失败，登录微信公众平台失败，失败原因：" +
					response.getBaseResp().getErrMsg());
		}
		tokenParam = Integer.parseInt(response.getRedirectUrl().split("=")[3]);
		logger.info("登录微信公众平台成功，跳转URL中的token参数为： " + tokenParam);
	}
	
	
	/**
	 * 抓取微信公众号的基本信息
	 * @return 返回 {@code WechatAccount} 对象
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException 抓取时发生异常
	 */
	public WechatAccount crawlAccount() throws WeChatException {
		logger.info("进入微信公众账号基本信息页面抓取基本信息...");
		
		WechatAccount account = new WechatAccount();

		// 发送HTTP请求
		HttpGet get = new HttpGet(String.format(ACCOUNT_SETTING_ADDR, tokenParam));
		String ret = execute(get);
		
		// 解析HTML内容
		Document document = Jsoup.parse(ret);
		Elements elements = document.getElementsByClass("meta_content");
		
		// 遍历次数和临时数据
		int i = 1;
		String tmp;
		
		for (Element element : elements) {
			tmp = element.text();
			if (i == 1) {			// 微信公众号名称
				account.setName(tmp);
			} else if (i == 2) {	// 微信公众号头像
				
			} else if (i == 3) {	// 登陆邮箱
				account.setEmail(tmp);
			} else if (i == 4) { 	// 微信公众号 open_id
				account.setOpenId(tmp);
			} else if (i == 5) {	// 微信号
				account.setWechatName(tmp);
			} else if (i == 6) {	// 微信公众号类型
				account.setType(tmp);
			} else if (i == 7) { 	// 微信公众号认证情况
				account.setAuth(tmp);
			} else if (i == 9) {	// 微信公众号介绍
				account.setIntroduce(tmp);
			} else if (i == 10) { 	// 所在地址
				account.setAddress(tmp);
			} else if (i == 11) {	// 微信认证资料
				account.setAuthDetail(tmp);
			} else if (i == 12) {	// 二维码
				
			}
			i++;
		}
		if ("订阅号".equals(account.getType())) {
			logger.info("该微信公众号为订阅号，抓取任务结束!");
			return account;
		} 
		logger.info("该账号为服务号，进入开发者中心抓取AppId，AppSecret等信息...");
		get = new HttpGet(String.format(ADVANCED_ADDR, tokenParam));
		ret = execute(get);
		document = Jsoup.parse(ret);
		elements = document.getElementsByClass("frm_vertical_pt");
		i = 1;
		for (Element element : elements) {
			tmp = element.text();
			if (i == 1) {			// app_id
				account.setAppId(tmp);
			} else if (i == 2) {	// app_secret
				account.setAppSecret(tmp);
			}
			i++;
		}
		logger.info("微信公众号基本信息抓取完毕！");
		return account;
	}
	
	/**
	 * 设置接受微信消息推送的URL
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException 设置失败，抛出 {@code WechatException} 异常
	 */
	public void setCallbackUrl() throws WeChatException {
		logger.info("设置接受微信消息推送的URL中...");
		
		Asserts.notNull(url, "接受微信消息推送的URL不能为空");
		Asserts.notNull(token, "验证微信消息签名的token不能为空");
		
		// 设置参数
		List<NameValuePair> postParams = new LinkedList<NameValuePair>();
		postParams.add(new BasicNameValuePair("url", url));
		postParams.add(new BasicNameValuePair("callback_token", token));
		
		// 创建一个POST请求，并绑定参数
		HttpPost post = new HttpPost(String.format(CALLBACK_URL_ADDR, tokenParam));
		post.setEntity(new UrlEncodedFormEntity(postParams, DEFAULT_CHARSET));
		
		CallbackUrlResponse response = execute(post, CallbackUrlResponse.class);
		if (response.getRet() != 0) {
			throw new WeChatException("设置接受微信消息推送的URL失败，失败原因： code = " +
						response.getRet() + "   msg = " + response.getMsg());
		}
		logger.info("设置接受微信消息推送的URL成功！");
	}
	
	public void startDeveloperMode() throws WeChatException {
		logger.info("开启微信公众号的开发者模式中...");
		
		// 设置POST参数
		List<NameValuePair> postParams = new LinkedList<NameValuePair>();
		postParams.add(new BasicNameValuePair("flag", "1"));
		postParams.add(new BasicNameValuePair("type", "2"));
		postParams.add(new BasicNameValuePair("lang", "zh_CN"));
		postParams.add(new BasicNameValuePair("ajax", "1"));
		postParams.add(new BasicNameValuePair("form", "advancedswitchform"));
		postParams.add(new BasicNameValuePair("token", tokenParam.toString()));
		
		// 创建POST请求，并绑定请求参数
		HttpPost post = new HttpPost(START_DEV_MODE_ADDR);
		post.setEntity(new UrlEncodedFormEntity(postParams, DEFAULT_CHARSET));
		post.setHeader("Referer", String.format(START_DEV_MODE_REFERER, tokenParam));
		
		StartDevModeResponse response = execute(post, StartDevModeResponse.class);
		if (response.getBaseResp().getRet() != 0) {
			throw new WeChatException("开启开发者模式失败，错误码： " + response.getBaseResp().getRet() +
					"  ,错误消息： " + response.getBaseResp().getErrMsg());
		}
		logger.info("开启开发者模式成功！");
	}
	
	
	/**
	 * 初始化一个 {@code CloseableHttpClient} 对象	
	 * @return 返回 {@code CloseableHttpClient} 对象
	 */
	protected CloseableHttpClient initHttpClient() {
		/*try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType)
						throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			return HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
		} catch (Exception e) {
			throw new WechatException(e);
		}*/
		return HttpClients.createDefault();
	}
	
	/**
	 * 发送 {@code HTTP} 请求，并返回结果
	 * @param request 请求方法
	 * @return 成功返回 {@code HTTP} 响应的内容，失败返回 {@code null}
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException 请求失败，抛出微信异常
	 */
	protected String execute(HttpRequestBase request) throws WeChatException {
		// 设置请求配置参数
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
				.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
				.build();
		request.setConfig(requestConfig);
		
		// 错误消息
		StringBuilder error = new StringBuilder(100);
		error.append("智能绑定失败，发送HTTP时出现异常，请求方法：")
			.append(request.getMethod())
			.append(" ，请求地址：")
			.append(request.getURI())
			.append(" ，失败原因：");
		
		try {
			CloseableHttpResponse response = httpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = response.getEntity();
				String ret;
				if (entity != null && 
						StringUtils.isNotEmpty(
								(ret = EntityUtils.toString(entity, DEFAULT_CHARSET)))) {
					return ret;
				}
			}
		} catch (ClientProtocolException e) {
			error.append("HTTP协议错误，" + e.getMessage());
			throw new RuntimeException(error.toString(), e);
		} catch (IOException e) {
			error.append("IO错误， " + e.getMessage());
			throw new RuntimeException(error.toString(), e);
		} catch (Exception e) {
			error.append(e.getMessage());
			throw new WeChatException(error.toString(), e);
		}
		error.append("无响应内容");
		throw new RuntimeException(error.toString());
	}
	
	/**
	 * 发送 {@code HTTP} 请求，并将返回结果反序列化为指定的对象
	 * @param request 请求方法
	 * @param clazz 反序列化对象的 {@code Class}
	 * @return 返回反序列化后的对象
	 * @throws com.dw.ccm.wechat.base.exception.WeChatException 请求失败，抛出微信异常
	 */
	protected <T> T execute(HttpRequestBase request, Class<T> clazz) throws WeChatException {
		String ret = execute(request);
		return JsonUtils.fromJson(ret, clazz);
	}
}
