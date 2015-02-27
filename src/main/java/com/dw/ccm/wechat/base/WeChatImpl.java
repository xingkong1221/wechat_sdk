package com.dw.ccm.wechat.base;

import com.dw.ccm.wechat.base.message.BaseMessage;
import com.dw.ccm.wechat.base.message.NewsMessage;
import com.dw.ccm.wechat.base.message.VideoMessage;
import com.dw.ccm.wechat.base.message.mass.BaseMassMessage;
import com.dw.ccm.wechat.base.message.response.*;
import com.dw.ccm.wechat.base.message.response.mass.MassResponse;
import com.dw.ccm.wechat.base.message.response.mass.NewsResponse;
import com.dw.ccm.wechat.base.message.response.mass.VideoResponse;
import com.dw.ccm.wechat.base.message.response.template.TemplateResponse;
import com.dw.ccm.wechat.base.message.template.TemplateMessage;
import com.dw.ccm.wechat.base.proxy.WeChatInvocationProxy;
import com.dw.ccm.wechat.base.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Proxy;
import java.net.URLEncoder;

/**
 * 微信公众平台基础接口实现
 * 
 * @author xingkong1221
 * @date 2014年6月30日
 */
public class WeChatImpl implements WeChat {
	
	/**
	 * 接口调用凭证
	 */
	private String accessToken;

	/**
	 * 
	 * @param accessToken
	 */
	private WeChatImpl(String accessToken) {
		this.accessToken = accessToken;
	}
	
	private WeChatImpl() {	}
	
	/**
	 * 根据指定的 {@code access_token} 创建一个 {@code Wechat} 基础接口对象
	 * 
	 * @param accessToken 微信公众平台接口调用唯一凭证
	 * @param interceptor 响应消息拦截器
	 * @return 返回一个 {@code IWeChat} 基础接口对象
	 */
	public static WeChat getInstance(String accessToken, ResponseInterceptor interceptor) {
		// 创建IWeChat实例
		WeChat weChat = new WeChatImpl(accessToken);
		// 获取IWeChat实例的所有接口
		Class<?>[] proxyInterface = weChat.getClass().getInterfaces();
		// 创建IWeChat接口动态代理对象
		WeChatInvocationProxy handler = new WeChatInvocationProxy(weChat, interceptor);
		// 获取类加载器
		ClassLoader loader = weChat.getClass().getClassLoader();
		// 返回 IWeChat 接口代理类的实例
		return (WeChat) Proxy.newProxyInstance(loader, proxyInterface, handler);
	}

	@Override
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public AccessTokenResponse getAccessToken(String appId, String appSecret) {
		if (StringUtils.isEmpty(appId)) {
			throw new IllegalArgumentException("微信公众号的app_id不能空！");
		} 
		if (StringUtils.isEmpty(appSecret)) {
			throw new IllegalArgumentException("微信公众号的app_secret不能空!");
		}
		String url = String.format(WeChat.TOKEN, "client_credential", appId, appSecret);
		return HttpUtils.get(url, AccessTokenResponse.class);
	}

	@Override
	public DownloadResponse download(String mediaId) {
		if (StringUtils.isEmpty(mediaId)) {
			throw new IllegalArgumentException("媒体文件id不能为空！");
		}
		String url = String.format(WeChat.GET_MEDIA, this.accessToken, mediaId);
		return HttpUtils.download(url);
	}

	@Override
	public UploadResponse upload(byte[] data, String filename, String type) {
		if (data.length <= 0) {
			throw new IllegalArgumentException("媒体文件数据不能为空！");
		}
		if (StringUtils.isEmpty(type)) {
			throw new IllegalArgumentException("媒体文件名称不能为空！");
		}
		if (StringUtils.isEmpty(type)) {
			throw new IllegalArgumentException("媒体文件类型不能为空！");
		}
		if (!WeChat.UploadMediaType.contains(type)) {
			throw new IllegalArgumentException("上传多媒体文件，文件类型不合法： " + type);
		}
		String url = String.format(WeChat.UPLOAD_MEDIA, this.accessToken, type);
		return HttpUtils.upload(url, data, filename);
	}
	
	@Override
	public CustomResponse sendCustomMessage(BaseMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("发送客服消息，客服消息不能为空！");
		}
		String url = String.format(WeChat.CUSTOM_MESSAGE, this.accessToken);
		return HttpUtils.post(url, message.toJson(), CustomResponse.class);
	}

	@Override
	public NewsResponse uploadNews(NewsMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("上传图文消息素材，图文消息对象不能空！");
		}
		String url = String.format(WeChat.UPLOAD_NEWS, this.accessToken);
		return HttpUtils.post(url, message.toJsonForUploadNews(), NewsResponse.class);
	}

	@Override
	public VideoResponse uploadVideo(VideoMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("上传视频消息素材，视频消息对象不能为空！");
		}
		String url = String.format(WeChat.UPLOAD_VIDEO, this.accessToken);
		return HttpUtils.post(url, message.toJsonForUploadVideo(), VideoResponse.class);
	}

	@Override
	public MassResponse sendMassMessageByGroup(BaseMassMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("群发消息对象不能为空！");
		}
		String url = String.format(WeChat.SEND_ALL_BY_GROUP, this.accessToken);
		return HttpUtils.post(url, message.toJsonByGroup(), MassResponse.class);
	}

	@Override
	public MassResponse sendMassMessageByOpenId(BaseMassMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("群发消息对象不能为空！");
		}
		String url = String.format(WeChat.SEND_ALL_BY_OPENID, this.accessToken);
		return HttpUtils.post(url, message.toJsonByOpenId(), MassResponse.class);
	}

	@Override
	public GroupResponse createGroup(String name) {
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("创建微信公众号分组，分组名称不能为空");
		}
		String url = String.format(WeChat.GROUPS_CREATE, this.accessToken);
		/* 创建分组的JSON格式的POST数据 */
		String raw = String.format("{\"group\":{\"name\":\"%s\"}}", name);
		return HttpUtils.post(url, raw, GroupResponse.class);
	}

	@Override
	public GroupResponse getGroups() {
		String url = String.format(WeChat.GET_GROUPS, this.accessToken);
		return HttpUtils.get(url, GroupResponse.class);
	}

	@Override
	public GroupResponse getGroupId(String openId) {
		if (StringUtils.isEmpty(openId)) {
			throw new IllegalArgumentException("获取用户的分组信息，用户的openid不能为空！");
		}
		String url = String.format(WeChat.GET_GROUP_ID, this.accessToken);
		/*查用用户分组的POST数据*/
		String raw = String.format("{\"openid\":\"%s\"}", openId);
		return HttpUtils.post(url, raw, GroupResponse.class);
	}

	@Override
	public GroupResponse updateGroupName(Long id, String name) {
		if (id == null) {
			throw new IllegalArgumentException("更新分组名称，分组id(由微信分配)不能为空！");
		}
		if (StringUtils.isEmpty(name)) {
			throw new IllegalArgumentException("更新分组名称，分组名称不能为空！");
		}
		if (name.length() >= 30) {
			throw new IllegalArgumentException("更新分组名称，分组名称不能超过30个字符");
		}
		String url = String.format(WeChat.UPDATE_GROUP_NAME, this.accessToken);
		String raw = String.format("{\"group\":{\"id\":%s,\"name\":\"%s\"}}", id, name);
		return HttpUtils.post(url, raw, GroupResponse.class);
	}

	@Override
	public GroupResponse updateGroupMember(String openId, Long id) {
		if (StringUtils.isEmpty(openId)) {
			throw new IllegalArgumentException("移动用户分组，用户唯一标识符(open_id)不能为空！");
		}
		if (id == null) {
			throw new IllegalArgumentException("移动用户分组，分组id不能为空！");
		}
		String url = String.format(WeChat.UPDATE_GROUP_MEMBER, this.accessToken);
		String raw = String.format("{\"openid\":\"%s\",\"to_groupid\":108}", openId);
		return HttpUtils.post(url, raw, GroupResponse.class);
	}
	@Override
	public UserInfoResponse getUserInfo(String openId, String lang) {
		if (StringUtils.isEmpty(openId)) {
			throw new NullPointerException("获取用户基本信息，用户标识（open_id）不能为空！");
		}
		if (!WeChat.Lang.contains(lang)) {
			throw new IllegalArgumentException("获取用户基本信息，国家地区语言版本错误： " + lang);
		}
		String url = String.format(WeChat.GET_USER_INFO, this.accessToken, openId, lang);
		return HttpUtils.get(url, UserInfoResponse.class);
	}

	@Override
	public FollowersResponse getFollowers(String nextOpenId) {
        nextOpenId = nextOpenId == null ? "" : nextOpenId;
		String url = String.format(WeChat.GET_FOLLOWERS, this.accessToken, nextOpenId);
		return HttpUtils.get(url, FollowersResponse.class);
	}

	@Override
	public MenuResponse createMenu(String raw) {
		if (StringUtils.isEmpty(raw)) {
			throw new NullPointerException("为微信公众号创建菜单，原始菜单数据不能为空！");
		}
		String url = String.format(WeChat.CREATE_MENU, this.accessToken);
		return HttpUtils.post(url, raw, MenuResponse.class);
	}

	@Override
	public MenuResponse getMenu() {
		String url = String.format(WeChat.GET_MENU, this.accessToken);
		return HttpUtils.get(url, MenuResponse.class);
	}

	@Override
	public MenuResponse deleteMenu() {
		String url = String.format(WeChat.DELETE_MENU, this.accessToken);
		return HttpUtils.get(url, MenuResponse.class);
	}

	@Override
	public TicketResponse createTicket(Integer sceneId, Integer expireSeconds) {
		if (sceneId == null) {
			throw new IllegalArgumentException("创建二维码ticket，场景值ID不能为空");
		}
		// json格式的post数据
		String raw = null;
		if (expireSeconds != null) {
			/**
			 * 临时二维码
			 */
			
			// 验证场景值ID是否合法
			if (sceneId == 0 || sceneId > Integer.MAX_VALUE || sceneId < Integer.MIN_VALUE) {
				throw new IllegalArgumentException("临时二维码的场景值ID必须为32位非0整型");
			}
			// 验证二维码有效期是否合法
			if (expireSeconds >= 1800 || expireSeconds <= 0) {
				throw new IllegalArgumentException("二维码的有效时间不能超过1800秒或小于等于零秒！ expire_seconds = " + expireSeconds);
			}
			raw = String.format("{\"expire_seconds\": %s, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %s}}}", 
					expireSeconds,
					sceneId);
		} else {
			/**
			 * 永久二维码
			 */
			
			// 验证场景值ID是否合法
			if (sceneId < 1 || sceneId > 100000) {
				throw new IllegalArgumentException("永久二维码时最大值为100000，最小值为1！");
			}
			raw = String.format("{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %s}}}", sceneId);
		}
		String url = String.format(WeChat.CREATE_TICKET, this.accessToken);
		return HttpUtils.post(url, raw, TicketResponse.class);
	}
	
	/**
	 * 通过ticket换取二维码地址
	 * @param ticket 二维码ticket
	 * @return 二维码图片地址
	 */
	@Override
	public String getQrCode(String ticket) {
		try {
			ticket = URLEncoder.encode(ticket, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ticket进行UrlEncode出错！");
		}
		return String.format(WeChat.GET_QRCODE, ticket);
	}

	@Override
	public BaseResponse updateRemark(String openId, String remark) {
		String url = String.format(WeChat.UPDATE_REMARK, this.accessToken);
		String raw = String.format("{\"openid\":\"%s\",\"remark\":\"%s\"}", openId, remark);
		return HttpUtils.post(url, raw, BaseResponse.class);
	}

	@Override
	public TemplateResponse sendTemplate(TemplateMessage message) {
		String url = String.format(WeChat.SEND_TEMPLATE, this.accessToken);
		String raw = message.toJson();
		return HttpUtils.post(url, raw, TemplateResponse.class);
	}
}